import java.util.*;

/**
 * 217. Contains Duplicate
 *
 * 🔍 Problem:
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and false if every element is distinct.
 *
 * 🧠 Approach (Using HashSet):
 * - HashSet stores only unique values — duplicates are ignored automatically.
 * - So if the set size < array length, duplicates exist.
 *
 * 🧩 Steps:
 * 1️⃣ Create a HashSet
 * 2️⃣ Add each number in the array
 * 3️⃣ If the final set is smaller than the array → duplicates found
 *
 * 🧮 Example:
 * Input: [1, 2, 3, 1]
 * Step 1: Add 1 → set = [1]
 * Step 2: Add 2 → set = [1, 2]
 * Step 3: Add 3 → set = [1, 2, 3]
 * Step 4: Add 1 → already in set (ignored)
 *
 * Array length = 4
 * Set size = 3
 * 3 < 4 → true (duplicates exist)
 *
 * ⏱️ Time: O(n)
 * 💾 Space: O(n)
 */

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return set.size() < nums.length;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + solution.containsDuplicate(nums1)); // Expected: true

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test 2: " + solution.containsDuplicate(nums2)); // Expected: false

        // Test case 3
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Test 3: " + solution.containsDuplicate(nums3)); // Expected: true
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(n)
 * - We iterate through the array once to add all elements to the HashSet
 * - HashSet.add() is O(1) on average
 * - Total: O(n) where n is the length of the array
 *
 * Space Complexity: O(n)
 * - In the worst case (no duplicates), the HashSet will contain all n elements
 * - HashSet stores references to Integer objects
 *
 * Key Insight:
 * A HashSet automatically ignores duplicate values. When you try to add
 * a duplicate, it simply doesn't add it again. So if the final set size
 * is smaller than the array length, duplicates must exist!
 *
 * Alternative Approaches:
 *
 * 1. Early Return Optimization (Better):
 *    Instead of adding all elements then comparing sizes, check during addition
 *    Time: O(n), Space: O(n) - but faster in practice
 *
 *    for (int num : nums) {
 *        if (set.contains(num)) {
 *            return true;  // Found duplicate immediately!
 *        }
 *        set.add(num);
 *    }
 *    return false;
 *
 * 2. Sorting Approach:
 *    Sort array, then check adjacent elements for duplicates
 *    Time: O(n log n), Space: O(1) or O(n) depending on sort algorithm
 *
 *    Arrays.sort(nums);
 *    for (int i = 1; i < nums.length; i++) {
 *        if (nums[i] == nums[i - 1]) {
 *            return true;
 *        }
 *    }
 *    return false;
 *
 * 3. Brute Force (NOT RECOMMENDED):
 *    Nested loops comparing every pair
 *    Time: O(n²), Space: O(1)
 *    Too slow for large inputs
 */
