import java.util.*;

/**
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use
 * the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> meow = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (meow.containsKey(nums[i])) {
                return new int[] {meow.get(nums[i]), i};
            }

            meow.put(complement, i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test case 1
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9))); // Expected: [0, 1]

        // Test case 2
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6))); // Expected: [1, 2]

        // Test case 3
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6))); // Expected: [0, 1]
    }
}
