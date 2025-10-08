import java.util.*;

public class LongestConsecutiveSequence {

    /**
     * LeetCode 128: Longest Consecutive Sequence
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * You must write an algorithm that runs in O(n) time.
     *
     * Example 1:
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * Example 2:
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     */

    // Approach: Use HashSet for O(1) lookup
    // Only start counting from numbers that are the beginning of a sequence
    // Time: O(n), Space: O(n)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Add all numbers to a HashSet for O(1) lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through the set
        for (int num : numSet) {
            // Only start counting if this is the beginning of a sequence
            // (i.e., num-1 is not in the set)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // Test cases
    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        // Test case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test 1: " + solution.longestConsecutive(nums1)); // Expected: 4

        // Test case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test 2: " + solution.longestConsecutive(nums2)); // Expected: 9

        // Test case 3
        int[] nums3 = {9, 1, 4, 7, 3, 2, 8, 5, 6};
        System.out.println("Test 3: " + solution.longestConsecutive(nums3)); // Expected: 9

        // Test case 4 - empty array
        int[] nums4 = {};
        System.out.println("Test 4: " + solution.longestConsecutive(nums4)); // Expected: 0

        // Test case 5 - single element
        int[] nums5 = {1};
        System.out.println("Test 5: " + solution.longestConsecutive(nums5)); // Expected: 1
    }
}
