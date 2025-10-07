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
        // 🪣 Step 1: Create a set for unique elements
        HashSet<Integer> set = new HashSet<>();

        // 🌀 Step 2: Loop through numbers and add them to the set
        for (int num : nums) {
            set.add(num); // duplicates automatically ignored
            System.out.println("Adding " + num + " → " + set);
        }

        // 🧾 Step 3: Print lengths to visualize
        System.out.println("Array length: " + nums.length);
        System.out.println("Set size: " + set.size());

        // ✅ Step 4: Compare
        boolean hasDuplicate = set.size() <
