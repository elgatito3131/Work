"""
    Given a roman numeral, convert it to an integer.

    Example 1:
    Input: s = "III"
    Output: 3

    Example 2:
    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.

    Example 3:
    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    Constraints:
    - 1 <= len(s) <= 15
    - s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').

    Time Complexity: O(n)
    Space Complexity: O(1)
"""

def roman_to_int(s):
    roman_values = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000,
    }

    total = 0
    prev_value = 0

    for char in reversed(s):
        value = roman_values[char]
        if value < prev_value:
            total -= value
        else:
            total += value
            prev_value = value

    return total


def test_roman_to_int():
    # Basic numerals
    assert roman_to_int("III") == 3
    assert roman_to_int("VIII") == 8

    # Subtractive notation
    assert roman_to_int("IV") == 4
    assert roman_to_int("IX") == 9
    assert roman_to_int("XL") == 40
    assert roman_to_int("CM") == 900

    # Mixed numerals
    assert roman_to_int("LVIII") == 58
    assert roman_to_int("MCMXCIV") == 1994

    # Largest value in constraints
    assert roman_to_int("MMMCMXCIX") == 3999

    # Random checks
    assert roman_to_int("DCXXI") == 621
    assert roman_to_int("CCXLVI") == 246

    print("All tests passed!")


if __name__ == "__main__":
    test_roman_to_int()


"""
SOLUTION APPROACH:

Problem: Convert Roman numeral string to integer.

Algorithm: Reverse Iteration with Previous Value Comparison
1. Create mapping of Roman symbols to values
2. Start from rightmost character (reverse iteration)
3. For each character:
   - If current_value < previous_value: subtract (subtractive notation)
   - Else: add normally and update previous_value

Why reverse iteration:
- Roman numerals are built left-to-right with largest values first
- Subtractive cases (IV, IX, XL, XC, CD, CM) have smaller before larger
- Processing right-to-left lets us detect when current < previous

Examples:
- "IV": V(5) + I(1<5, subtract) = 5-1 = 4
- "VI": I(1) + V(5≥1, add) = 1+5 = 6
- "MCMXC": C(100) + X(10<100, subtract) + M(1000≥10, add) + C(100<1000, subtract) + M(1000≥100, add)
           = 100-10+1000-100+1000 = 1990

Key insight: Only update prev_value when adding (not subtracting) because
subtracted values shouldn't influence future comparisons.

Time Complexity: O(n) - single pass through string
Space Complexity: O(1) - constant space for mapping and variables

Alternative approaches:
- Left-to-right with lookahead: More complex logic
- Replace subtractive patterns first: Multiple string operations
"""
