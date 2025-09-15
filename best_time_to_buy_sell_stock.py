"""
Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the i-th day.

You want to maximize your profit by choosing a single day to buy one stock and choosing
a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve
any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:
- 1 <= prices.length <= 10^5
- 0 <= prices[i] <= 10^4

Time Complexity Goal: O(n)
Space Complexity Goal: O(1)
"""

def max_profit(prices):
    """
    Find the maximum profit from buying and selling stock once.

    Algorithm: Single Pass with Min Price Tracking
    - Track the minimum price seen so far
    - For each price, calculate profit if we sold today
    - Keep track of maximum profit seen

    Time Complexity: O(n) - single pass through array
    Space Complexity: O(1) - only using constant extra space
    """
    if len(prices) <= 1:
        return 0

    min_price = prices[0]  # Track minimum price seen so far
    max_profit = 0         # Track maximum profit possible

    for price in prices[1:]:
        # Calculate profit if we sell at current price
        current_profit = price - min_price

        # Update maximum profit if current is better
        max_profit = max(max_profit, current_profit)

        # Update minimum price for future transactions
        min_price = min(min_price, price)

    return max_profit


def test_max_profit():
    # Test case 1: Example from problem
    assert max_profit([7, 1, 5, 3, 6, 4]) == 5

    # Test case 2: No profit possible
    assert max_profit([7, 6, 4, 3, 1]) == 0

    # Test case 3: Single day
    assert max_profit([1]) == 0

    # Test case 4: Two days - profit possible
    assert max_profit([1, 5]) == 4

    # Test case 5: Two days - no profit
    assert max_profit([5, 1]) == 0

    # Test case 6: All same prices
    assert max_profit([3, 3, 3, 3]) == 0

    # Test case 7: Large profit at end
    assert max_profit([1, 2, 3, 4, 5]) == 4

    print("All tests passed!")


if __name__ == "__main__":
    test_max_profit()