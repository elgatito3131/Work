"""
Options & Stock Analyzer - Compact Horizontal View
"""

import yfinance as yf
from datetime import datetime
import os
import warnings
warnings.filterwarnings('ignore')

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PREDICTIONS_DIR = os.path.join(SCRIPT_DIR, "predictions")


def get_trading_days_left():
    """Get remaining trading days this week."""
    now = datetime.now()
    today = now.weekday()
    hour = now.hour
    market_closed = hour >= 16
    days = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri']
    if today > 4:
        return days
    start = today + 1 if market_closed else today
    if start > 4:
        return days
    return days[start:5]


def get_stock_data(ticker):
    """Fetch stock data and calculate technical indicators."""
    stock = yf.Ticker(ticker)
    hist = stock.history(period="3mo")
    if hist.empty:
        return None

    current_price = hist['Close'].iloc[-1]
    prev_close = hist['Close'].iloc[-2]
    daily_change = ((current_price - prev_close) / prev_close) * 100

    sma_20 = hist['Close'].rolling(window=20).mean().iloc[-1]
    sma_50 = hist['Close'].rolling(window=50).mean().iloc[-1]

    delta = hist['Close'].diff()
    gain = (delta.where(delta > 0, 0)).rolling(window=14).mean()
    loss = (-delta.where(delta < 0, 0)).rolling(window=14).mean()
    rs = gain / loss
    rsi = 100 - (100 / (1 + rs))
    rsi_value = rsi.iloc[-1]

    high_low = hist['High'] - hist['Low']
    atr = high_low.rolling(window=14).mean().iloc[-1]

    five_day_change = ((current_price - hist['Close'].iloc[-5]) / hist['Close'].iloc[-5]) * 100

    return {
        'ticker': ticker,
        'price': current_price,
        'daily_change': daily_change,
        'five_day_change': five_day_change,
        'sma_20': sma_20,
        'sma_50': sma_50,
        'rsi': rsi_value,
        'atr': atr,
        'above_sma20': current_price > sma_20,
        'above_sma50': current_price > sma_50,
    }


def get_options_data(ticker):
    """Fetch options chain for nearest expiration."""
    stock = yf.Ticker(ticker)
    try:
        expirations = stock.options
        if not expirations:
            return None

        nearest_exp = expirations[0]
        opt_chain = stock.option_chain(nearest_exp)
        calls = opt_chain.calls
        puts = opt_chain.puts
        current_price = stock.history(period="1d")['Close'].iloc[-1]

        calls['diff'] = abs(calls['strike'] - current_price)
        puts['diff'] = abs(puts['strike'] - current_price)
        atm_call = calls.loc[calls['diff'].idxmin()]
        atm_put = puts.loc[puts['diff'].idxmin()]

        total_call_vol = calls['volume'].sum()
        total_put_vol = puts['volume'].sum()
        pc_ratio = total_put_vol / total_call_vol if total_call_vol > 0 else 1

        strikes = calls['strike'].unique()
        max_pain_strike = current_price
        min_pain = float('inf')
        for strike in strikes:
            call_itm = calls[calls['strike'] < strike]['openInterest'].sum()
            put_itm = puts[puts['strike'] > strike]['openInterest'].sum()
            total_pain = call_itm + put_itm
            if total_pain < min_pain:
                min_pain = total_pain
                max_pain_strike = strike

        return {
            'expiration': nearest_exp,
            'atm_call_strike': atm_call['strike'],
            'atm_call_price': atm_call['lastPrice'],
            'atm_put_strike': atm_put['strike'],
            'atm_put_price': atm_put['lastPrice'],
            'put_call_ratio': pc_ratio,
            'max_pain': max_pain_strike,
        }
    except:
        return None


def calculate_bias(data, options):
    """Calculate overall directional bias score (-100 to +100)."""
    score = 0

    if data['above_sma20'] and data['above_sma50']:
        score += 30
    elif not data['above_sma20'] and not data['above_sma50']:
        score -= 30

    if data['rsi'] > 60:
        score += 15
    elif data['rsi'] < 40:
        score -= 15

    if data['five_day_change'] > 2:
        score += 25
    elif data['five_day_change'] > 0:
        score += 10
    elif data['five_day_change'] < -2:
        score -= 25
    elif data['five_day_change'] < 0:
        score -= 10

    if options and 'put_call_ratio' in options:
        pc = options['put_call_ratio']
        if pc < 0.7:
            score += 25
        elif pc > 1.3:
            score -= 25

        if options['max_pain']:
            diff = ((options['max_pain'] - data['price']) / data['price']) * 100
            if diff > 1:
                score += 10
            elif diff < -1:
                score -= 10

    return min(max(score, -100), 100)


def get_direction_short(score):
    """Convert score to emoji direction."""
    if score >= 40:
        return "🟢🟢"
    elif score >= 15:
        return "🟢"
    elif score <= -40:
        return "🔴🔴"
    elif score <= -15:
        return "🔴"
    else:
        return "⚪"


def get_play(score, options):
    """Get the suggested play."""
    if not options:
        return "N/A"
    if score >= 15:
        return f"${options['atm_call_strike']:.0f}C"
    elif score <= -15:
        return f"${options['atm_put_strike']:.0f}P"
    else:
        return "SKIP"


def save_report(all_data):
    """Save a short prediction report."""
    os.makedirs(PREDICTIONS_DIR, exist_ok=True)

    now = datetime.now()
    day_name = now.strftime('%A')
    month_day = now.strftime('%b%d')
    time_str = now.strftime('%I-%M%p').lstrip('0')
    filename = f"predict_{day_name}_{month_day}_{time_str}.md"
    filepath = os.path.join(PREDICTIONS_DIR, filename)

    # Build prediction data first
    predictions = []
    for item in all_data:
        d = item['data']
        o = item['options']
        score = item['score']

        if score >= 40:
            call = "🟢🟢 UP"
        elif score >= 15:
            call = "🟢 UP"
        elif score <= -40:
            call = "🔴🔴 DOWN"
        elif score <= -15:
            call = "🔴 DOWN"
        else:
            call = "⚪ FLAT"

        atr = d['atr']
        if score >= 15:
            low = d['price'] + atr * 0.5
            high = d['price'] + atr * 2
            target = f"${low:.0f}-${high:.0f}"
            play = f"${o['atm_call_strike']:.0f}C @ ${o['atm_call_price']:.2f}" if o else "CALL"
            cost = o['atm_call_price'] * 100 if o else 0
        elif score <= -15:
            low = d['price'] - atr * 2
            high = d['price'] - atr * 0.5
            target = f"${low:.0f}-${high:.0f}"
            play = f"${o['atm_put_strike']:.0f}P @ ${o['atm_put_price']:.2f}" if o else "PUT"
            cost = o['atm_put_price'] * 100 if o else 0
        else:
            low = d['price'] - atr
            high = d['price'] + atr
            target = f"${low:.0f}-${high:.0f}"
            play = "SKIP"
            cost = 0

        predictions.append({
            'ticker': d['ticker'],
            'price': f"${d['price']:.2f}",
            'call': call,
            'target': target,
            'play': play,
            'cost': cost
        })

    lines = []
    lines.append(f"# {day_name} {now.strftime('%b %d')} - {now.strftime('%I:%M %p').lstrip('0')}")
    lines.append("")

    # Starting prices table
    lines.append("## STARTING PRICES")
    lines.append("")
    lines.append("| Ticker   | Price    |")
    lines.append("|----------|----------|")
    for p in predictions:
        lines.append(f"| {p['ticker']:<8} | {p['price']:>8} |")
    lines.append("")

    # Predictions table
    lines.append("## PREDICTIONS FOR NEXT WEEK")
    lines.append("")
    lines.append("| Ticker   | Call        | Target      | Play              | Cost (1 contract) |")
    lines.append("|----------|-------------|-------------|-------------------|-------------------|")
    for p in predictions:
        if p['play'] == "SKIP":
            cost_str = "N/A"
        else:
            cost_str = f"${p['cost']:.0f}"
        lines.append(f"| {p['ticker']:<8} | {p['call']:<11} | {p['target']:<11} | {p['play']:<17} | {cost_str:<17} |")
    lines.append("")

    # Total investment
    total_cost = sum(p['cost'] for p in predictions if p['cost'] > 0)
    lines.append(f"**Total to invest (all plays): ${total_cost:.0f}**")
    lines.append("")

    # Entry instructions
    lines.append("## ENTRY RULES")
    lines.append("")
    lines.append("- **When:** Monday 9:45 AM ET (15 min after open, let dust settle)")
    lines.append("- **Price:** Use your BROKER's live price, not the price above (that's Friday's close)")
    lines.append("- **Confirm:** Check that stock direction still matches before entering")
    lines.append("- **Stop:** Exit if option loses 50% of value")
    lines.append("- **Target:** Exit at 80-100% gain or Friday close")
    lines.append("")

    # Results section - Direction
    lines.append("## RESULTS (Fill in next Saturday)")
    lines.append("")
    lines.append("### Stock Price (Friday Close)")
    lines.append("")
    lines.append("| Ticker   | Start       | Predicted   | Actual      | Direction? |")
    lines.append("|----------|-------------|-------------|-------------|------------|")
    for p in predictions:
        lines.append(f"| {p['ticker']:<8} | {p['price']:<11} | {p['target']:<11} |             |            |")
    lines.append("")

    # Results section - Options P/L
    lines.append("### Option Plays P/L")
    lines.append("")
    lines.append("| Ticker   | Play              | Cost        | Entry       | Exit        | P/L         |")
    lines.append("|----------|-------------------|-------------|-------------|-------------|-------------|")
    for p in predictions:
        if p['play'] != "SKIP":
            lines.append(f"| {p['ticker']:<8} | {p['play']:<17} | ${p['cost']:<10.0f} |             |             |             |")
    lines.append("")

    # Summary
    lines.append("### Summary")
    lines.append("")
    lines.append("- **Direction Correct:** __/5")
    lines.append("- **Options Profitable:** __/4")
    lines.append("- **Total P/L:** $____")
    lines.append("- **Best Play:** ")
    lines.append("- **Worst Play:** ")
    lines.append("- **Lessons:** ")

    with open(filepath, 'w') as f:
        f.write('\n'.join(lines))

    print(f"\n  Report saved: predictions/{filename}")
    return filepath


def main():
    print("\n" + "="*90)
    print("  OPTIONS ANALYZER - " + datetime.now().strftime('%Y-%m-%d %H:%M'))
    print("  NOT FINANCIAL ADVICE - Technical signals only - You can lose 100%")
    print("="*90)

    tickers = ['SPY', 'QQQ', 'AAPL', 'NVDA', 'TSLA', 'PLTR', 'GOOGL']
    all_data = []

    for ticker in tickers:
        try:
            data = get_stock_data(ticker)
            options = get_options_data(ticker)
            if data:
                score = calculate_bias(data, options)
                all_data.append({
                    'ticker': ticker,
                    'data': data,
                    'options': options,
                    'score': score
                })
        except Exception as e:
            print(f"  Error: {ticker} - {e}")

    if not all_data:
        print("  No data available")
        return

    # === PRICE & MOMENTUM TABLE ===
    print("\n  PRICE & MOMENTUM")
    print("  " + "-"*86)
    print(f"  {'TICKER':<8}{'PRICE':>10}{'TODAY':>10}{'5-DAY':>10}{'RSI':>8}{'SMA20':>10}{'SMA50':>10}{'TREND':>10}")
    print("  " + "-"*86)

    for item in all_data:
        d = item['data']
        trend = "ABOVE" if d['above_sma20'] and d['above_sma50'] else "BELOW" if not d['above_sma20'] and not d['above_sma50'] else "MIXED"
        print(f"  {d['ticker']:<8}${d['price']:>8.2f}{d['daily_change']:>+9.2f}%{d['five_day_change']:>+9.2f}%{d['rsi']:>7.0f}  {'✓' if d['above_sma20'] else '✗':>8}  {'✓' if d['above_sma50'] else '✗':>8}  {trend:>8}")

    # === OPTIONS TABLE ===
    print("\n  OPTIONS DATA")
    print("  " + "-"*86)
    print(f"  {'TICKER':<8}{'EXPIRES':>12}{'MAX PAIN':>12}{'MP DIFF':>10}{'P/C':>8}{'CALL':>12}{'PUT':>12}")
    print("  " + "-"*86)

    for item in all_data:
        d = item['data']
        o = item['options']
        if o:
            mp_diff = ((o['max_pain'] - d['price']) / d['price']) * 100
            print(f"  {d['ticker']:<8}{o['expiration']:>12}${o['max_pain']:>10.2f}{mp_diff:>+9.1f}%{o['put_call_ratio']:>8.2f}  ${o['atm_call_price']:>8.2f}  ${o['atm_put_price']:>8.2f}")
        else:
            print(f"  {d['ticker']:<8}{'N/A':>12}{'N/A':>12}{'N/A':>10}{'N/A':>8}{'N/A':>12}{'N/A':>12}")

    # === SIGNALS & PLAYS TABLE ===
    print("\n  SIGNALS & SUGGESTED PLAYS")
    print("  " + "-"*86)
    print(f"  {'TICKER':<8}{'BIAS':>8}{'SCORE':>8}{'PLAY':>12}{'COST':>10}{'BREAKEVEN':>12}{'TO BE':>12}")
    print("  " + "-"*86)

    for item in all_data:
        d = item['data']
        o = item['options']
        score = item['score']
        bias = get_direction_short(score)
        play = get_play(score, o)

        if o and score >= 15:
            cost = o['atm_call_price']
            be = o['atm_call_strike'] + cost
            be_pct = ((be - d['price']) / d['price']) * 100
        elif o and score <= -15:
            cost = o['atm_put_price']
            be = o['atm_put_strike'] - cost
            be_pct = ((be - d['price']) / d['price']) * 100
        else:
            cost = 0
            be = 0
            be_pct = 0

        cost_str = f"${cost:.2f}" if cost > 0 else "-"
        be_str = f"${be:.2f}" if be > 0 else "-"
        be_pct_str = f"{be_pct:+.1f}%" if be > 0 else "-"

        print(f"  {d['ticker']:<8}{bias:>8}{score:>+8}  {play:>10}  {cost_str:>8}  {be_str:>10}  {be_pct_str:>10}")

    # === DAY-BY-DAY OUTLOOK ===
    trading_days = get_trading_days_left()

    print("\n  DAY-BY-DAY OUTLOOK (bias shifts toward max pain as expiration approaches)")
    print("  " + "-"*86)
    header = f"  {'TICKER':<8}"
    for day in trading_days:
        header += f"{day:>16}"
    print(header)
    print("  " + "-"*86)

    for item in all_data:
        d = item['data']
        o = item['options']
        base_score = item['score']

        row = f"  {d['ticker']:<8}"
        for i, day in enumerate(trading_days):
            day_score = base_score
            if o and o['max_pain']:
                mp_pull = ((o['max_pain'] - d['price']) / d['price']) * 100
                pull_weight = (i + 1) * 5
                day_score += pull_weight if mp_pull > 0 else -pull_weight

            direction = get_direction_short(day_score)
            play = get_play(day_score, o)
            row += f"  {direction} {play:>10}"

        print(row)

    # === QUICK SUMMARY ===
    print("\n  " + "="*86)
    print("  QUICK SUMMARY")
    print("  " + "="*86)

    bulls = [item for item in all_data if item['score'] >= 15]
    bears = [item for item in all_data if item['score'] <= -15]
    neutral = [item for item in all_data if -15 < item['score'] < 15]

    if bulls:
        bull_str = ", ".join([f"{b['ticker']}({b['score']:+d})" for b in sorted(bulls, key=lambda x: -x['score'])])
        print(f"  🟢 BULLISH:  {bull_str}")

    if bears:
        bear_str = ", ".join([f"{b['ticker']}({b['score']:+d})" for b in sorted(bears, key=lambda x: x['score'])])
        print(f"  🔴 BEARISH:  {bear_str}")

    if neutral:
        neut_str = ", ".join([f"{n['ticker']}({n['score']:+d})" for n in neutral])
        print(f"  ⚪ NEUTRAL:  {neut_str}")

    # Best play
    best_bull = max(all_data, key=lambda x: x['score'])
    best_bear = min(all_data, key=lambda x: x['score'])

    print(f"\n  STRONGEST BULL: {best_bull['ticker']} (score {best_bull['score']:+d}) → {get_play(best_bull['score'], best_bull['options'])}")
    print(f"  STRONGEST BEAR: {best_bear['ticker']} (score {best_bear['score']:+d}) → {get_play(best_bear['score'], best_bear['options'])}")

    print("\n  ⚠️  Options can go to $0. These are signals, not guarantees.")

    # Save report
    save_report(all_data)

    print("="*90 + "\n")


if __name__ == "__main__":
    main()
