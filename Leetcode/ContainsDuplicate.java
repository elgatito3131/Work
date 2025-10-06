import java.util.*;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    // Alternative one-liner approach
    public boolean containsDuplicateOneLiner(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        // Test case 1: Contains duplicate
        assert solution.containsDuplicate(new int[]{1, 2, 3, 1}) == true;

        // Test case 2: No duplicates
        assert solution.containsDuplicate(new int[]{1, 2, 3, 4}) == false;

        // Test case 3: Multiple duplicates
        assert solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}) == true;

        // Test case 4: Single element
        assert solution.containsDuplicate(new int[]{1}) == false;

        // Test case 5: All same elements
        assert solution.containsDuplicate(new int[]{5, 5, 5, 5}) == true;

        // Test case 6: Large range
        assert solution.containsDuplicate(new int[]{-1, -2, -3, 0, 1, 2, 3}) == false;

        // Test case 7: Negative duplicates
        assert solution.containsDuplicate(new int[]{-5, -10, -5}) == true;

        System.out.println("All tests passed!");
    }
}

/**
 * REFRESHER:
 * - Input: array of integers.
 * - Goal: check if any number appears more than once.
 *
 * LAZY-FRIENDLY GAME PLAN:
 * 1. Create an empty HashSet to track numbers you've seen.
 * 2. Walk through the array one element at a time.
 * 3. For each number, check if it's already in the set.
 * 4. If yes, return true (found a duplicate!).
 * 5. If no, add it to the set and continue.
 * 6. If you finish the loop, return false (no duplicates).
 *
 * WHY IT WORKS:
 * HashSet lookups and inserts are O(1) on average. You check each number once,
 * so total time is O(n). Space is O(n) in worst case when all numbers are unique.
 * As soon as you find one duplicate, you can immediately return true.
 *
 * TIPS:
 * - HashSet automatically handles uniqueness - can't store duplicates.
 * - Alternative: add all to set, compare set.size() vs array.length (but slower).
 * - Alternative: sort array first O(n log n), then check adjacent elements.
 * - Early return optimization: stop as soon as you find first duplicate.
 * - In Java, use HashSet<Integer> for primitives (auto-boxing).
 */
