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
