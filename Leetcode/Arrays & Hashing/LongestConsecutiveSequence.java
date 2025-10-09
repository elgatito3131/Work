import java.util.HashSet;

/**
 * LeetCode 128: Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 *
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 */

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();

        // Add all numbers to HashSet
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        // Check each number to see if it's the start of a sequence
        for (int num : nums) {
            // Only start counting if this is the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        // Test case 1: Basic example
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test 1: " + solution.longestConsecutive(nums1)); // Expected: 4

        // Test case 2: Longer sequence with duplicates
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test 2: " + solution.longestConsecutive(nums2)); // Expected: 9

        // Test case 3: Empty array
        int[] nums3 = {};
        System.out.println("Test 3: " + solution.longestConsecutive(nums3)); // Expected: 0

        // Test case 4: Single element
        int[] nums4 = {1};
        System.out.println("Test 4: " + solution.longestConsecutive(nums4)); // Expected: 1

        // Test case 5: No consecutive elements
        int[] nums5 = {10, 5, 100};
        System.out.println("Test 5: " + solution.longestConsecutive(nums5)); // Expected: 1
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(n)
 * - First loop: Add all n elements to HashSet → O(n)
 * - Second loop: Iterate through n elements, but each number is processed at most twice
 *   - Once as the start of a sequence
 *   - Once when it's part of counting (the while loop)
 * - Total: O(n + n) = O(n)
 *
 * Space Complexity: O(n)
 * - HashSet stores n elements
 *
 * Key Insight:
 * We only start counting from the BEGINNING of a sequence (when num-1 doesn't exist).
 * This prevents redundant counting and ensures O(n) time complexity.
 *
 * Algorithm:
 * 1. Add all numbers to a HashSet for O(1) lookups
 * 2. For each number:
 *    - Check if it's the start of a sequence (num-1 not in set)
 *    - If yes, count how many consecutive numbers exist (num+1, num+2, etc.)
 *    - Track the maximum length found
 *
 * Example: nums = [100, 4, 200, 1, 3, 2]
 * HashSet: {100, 4, 200, 1, 3, 2}
 *
 * Check 100: Is 99 in set? No → Start of sequence
 *   - Count: 100 → maxLength = 1
 *
 * Check 4: Is 3 in set? Yes → NOT start of sequence, skip
 *
 * Check 200: Is 199 in set? No → Start of sequence
 *   - Count: 200 → maxLength = 1
 *
 * Check 1: Is 0 in set? No → Start of sequence
 *   - Count: 1, 2, 3, 4 → maxLength = 4 ✓
 *
 * Check 3: Is 2 in set? Yes → NOT start, skip
 * Check 2: Is 1 in set? Yes → NOT start, skip
 *
 * Result: 4
 *
 * Why O(n) and not O(n²)?
 * Although there's a nested while loop, each number is visited at most twice:
 * - Once in the outer for loop
 * - Once in the while loop (when it's part of a sequence being counted)
 * After a sequence is counted from its start, those numbers are never recounted.
 *
 * Alternative Approaches:
 *
 * 1. Sorting Approach:
 *    Sort array, then find longest consecutive sequence
 *    Time: O(n log n), Space: O(1) or O(n) depending on sort
 *
 *    if (nums.length == 0) return 0;
 *    Arrays.sort(nums);
 *
 *    int maxLength = 1;
 *    int currentLength = 1;
 *
 *    for (int i = 1; i < nums.length; i++) {
 *        if (nums[i] == nums[i-1]) continue;  // Skip duplicates
 *        if (nums[i] == nums[i-1] + 1) {
 *            currentLength++;
 *        } else {
 *            maxLength = Math.max(maxLength, currentLength);
 *            currentLength = 1;
 *        }
 *    }
 *    return Math.max(maxLength, currentLength);
 *
 * 2. Union Find (Overkill):
 *    Use Union-Find data structure
 *    Time: O(n), Space: O(n) - but more complex implementation
 *
 * The HashSet approach (current solution) is optimal and most intuitive!
 */
