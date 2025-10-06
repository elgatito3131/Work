import java.util.*;

/**
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
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // Map to store value -> index
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }

            seen.put(nums[i], i);
        }

        return new int[] {}; // No solution found (won't happen per constraints)
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test case 1: Example from LeetCode
        int[] result1 = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assert Arrays.equals(result1, new int[]{0, 1});

        // Test case 2: Numbers at end
        int[] result2 = solution.twoSum(new int[]{3, 2, 4}, 6);
        assert Arrays.equals(result2, new int[]{1, 2});

        // Test case 3: Same number twice
        int[] result3 = solution.twoSum(new int[]{3, 3}, 6);
        assert Arrays.equals(result3, new int[]{0, 1});

        // Test case 4: Negative numbers
        int[] result4 = solution.twoSum(new int[]{-1, -2, -3, -4, -5}, -8);
        assert Arrays.equals(result4, new int[]{2, 4});

        // Test case 5: Zero target
        int[] result5 = solution.twoSum(new int[]{0, 4, 3, 0}, 0);
        assert Arrays.equals(result5, new int[]{0, 3});

        // Test case 6: Mixed negatives and positives
        int[] result6 = solution.twoSum(new int[]{-3, 4, 3, 90}, 0);
        assert Arrays.equals(result6, new int[]{0, 2});

        // Test case 7: Large numbers
        int[] result7 = solution.twoSum(new int[]{1000000000, -999999995, 5}, 5);
        assert Arrays.equals(result7, new int[]{0, 1});

        System.out.println("All tests passed!");
    }
}

/**
 * REFRESHER:
 * - Input: list of numbers and a target sum.
 * - Goal: find two different positions whose values add to the target, return the indices.
 *
 * LAZY-FRIENDLY GAME PLAN:
 * 1. Walk through the array from left to right.
 * 2. For each number, compute `need = target - number`.
 * 3. If `need` was seen before (check the map), return [index_of_need, current_index].
 * 4. Otherwise remember the current number's index in a map and keep going.
 *
 * WHY IT WORKS:
 * You check each number once, map lookups are O(1), so the whole thing runs in O(n) time
 * and uses O(n) extra space. Instead of checking all pairs O(n²), we trade space for time.
 * When processing number 'a', we check if 'b' (complement) was seen before.
 *
 * TIPS:
 * - The map stores {value: index} pairs using HashMap<Integer, Integer>.
 * - You're looking backward as you go forward.
 * - Watch out: the problem says "return indices" not values!
 * - In Java, use HashMap.containsKey() to check if complement exists.
 * - Return format: new int[] {index1, index2} - array of two integers.
 * - Auto-boxing handles int to Integer conversion for HashMap.
 */
