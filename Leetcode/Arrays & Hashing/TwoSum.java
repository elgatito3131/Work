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

/*
 * NOTES:
 *
 * Time Complexity: O(n)
 * - Single pass through the array
 * - HashMap operations (containsKey, get, put) are O(1) average
 * - Total: O(n) where n is the length of nums
 *
 * Space Complexity: O(n)
 * - HashMap stores at most n elements
 * - In worst case, we store all elements before finding the pair
 *
 * Key Insight:
 * For each number nums[i], we need to find if (target - nums[i]) exists.
 * Instead of searching the array again (O(n²)), we use a HashMap to store
 * complements we've seen, allowing O(1) lookups!
 *
 * Algorithm:
 * For each number:
 * 1. Check if the number itself exists in the map (meaning we've seen its complement before)
 * 2. If yes, return [index_of_complement, current_index]
 * 3. If no, store (target - current_number) → current_index in the map
 *
 * Example: nums = [2, 7, 11, 15], target = 9
 * i=0, num=2:  Check if 2 in map? No. Store (9-2=7) → 0. map = {7: 0}
 * i=1, num=7:  Check if 7 in map? Yes! Return [map[7]=0, 1] = [0, 1] ✓
 *
 * Why store complement instead of the number itself?
 * Because we want to quickly check: "Have we seen the complement of this number?"
 * Storing the complement makes the lookup direct.
 *
 * Alternative Approaches:
 *
 * 1. Brute Force (NOT RECOMMENDED):
 *    Check every pair of numbers
 *    Time: O(n²), Space: O(1)
 *
 *    for (int i = 0; i < nums.length; i++) {
 *        for (int j = i + 1; j < nums.length; j++) {
 *            if (nums[i] + nums[j] == target) {
 *                return new int[] {i, j};
 *            }
 *        }
 *    }
 *
 * 2. Two-Pass HashMap:
 *    First pass: store all numbers → indices
 *    Second pass: check if complement exists
 *    Time: O(n), Space: O(n) - but requires 2 passes
 *
 *    HashMap<Integer, Integer> map = new HashMap<>();
 *    for (int i = 0; i < nums.length; i++) {
 *        map.put(nums[i], i);
 *    }
 *    for (int i = 0; i < nums.length; i++) {
 *        int complement = target - nums[i];
 *        if (map.containsKey(complement) && map.get(complement) != i) {
 *            return new int[] {i, map.get(complement)};
 *        }
 *    }
 *
 * 3. Sorting + Two Pointers:
 *    Sort array, use two pointers from both ends
 *    Time: O(n log n), Space: O(n) - but loses original indices!
 *    Need to track original indices separately
 *
 * The one-pass HashMap approach (current solution) is optimal for this problem!
 */
