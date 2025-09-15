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
