"""
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]

    Constraints:
    - 2 <= nums.length <= 10^4
    - -10^9 <= nums[i] <= 10^9
    - -10^9 <= target <= 10^9
    - Only one valid answer exists.

    Time Complexity: O(n)
    Space Complexity: O(n)
    """

def two_sum(nums, target):
    num_map = {}

    for i, num in enumerate(nums):
        complement = target - num
        if complement in num_map:
            return [num_map[complement], i]
        num_map[num] = i

    return []


def test_two_sum():
    # Test case 1: Example from LeetCode
    assert two_sum([2, 7, 11, 15], 9) == [0, 1]

    # Test case 2: Numbers at end
    assert two_sum([3, 2, 4], 6) == [1, 2]

    # Test case 3: Same number twice
    assert two_sum([3, 3], 6) == [0, 1]

    # Test case 4: Negative numbers
    assert two_sum([-1, -2, -3, -4, -5], -8) == [2, 4]

    # Test case 5: Zeros and duplicates
    assert two_sum([0, 4, 3, 0], 0) == [0, 3]

    # Test case 6: Mixed negatives and positives
    assert two_sum([-3, 4, 3, 90], 0) == [0, 2]

    # Test case 7: Large numbers
    assert two_sum([1000000000, -999999995, 5], 5) == [0, 1]

    # Test case 8: Single digit targets
    assert two_sum([1, 0], 1) == [0, 1]

    # Test case 9: Multiple duplicates
    assert two_sum([1, 5, 1, 5], 10) == [1, 3]

    print("All tests passed!")


if __name__ == "__main__":
    test_two_sum()


"""
SOLUTION APPROACH:

Problem: Find two numbers in array that sum to target, return their indices.

Algorithm: Hash Map (Dictionary) Lookup
1. Create empty hash map to store {value: index} pairs
2. For each element in array:
   - Calculate complement = target - current_element
   - Check if complement exists in hash map
   - If yes: return [hash_map[complement], current_index]
   - If no: store current_element and its index in hash map

Why this works:
- We're looking for two numbers: a + b = target
- When processing 'a', we check if 'b' (complement) was seen before
- Hash map gives O(1) lookup time vs O(n) for array search

Time Complexity: O(n) - single pass through array
Space Complexity: O(n) - hash map can store up to n elements

Key insight: Instead of checking all pairs O(n²), we trade space for time
"""