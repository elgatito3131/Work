/**
 * 242. Valid Anagram
 * 
 * 🔍 Problem:
 * Given two strings s and t, return true if t is an anagram of s.
 * 
 * 🧩 Definition:
 * An anagram is when two words have the *same letters* in *any order*.
 * Example: "anagram" → "nagaram" ✅
 *           "rat" → "car" ❌
 * 
 * 🧠 Hint:
 * Easiest approach → sort both strings and compare them.
 * Because anagrams, when sorted, look identical!
 * 
 * ⚙️ Approach:
 * 1️⃣ Convert both strings to character arrays (since strings can't be sorted directly)
 * 2️⃣ Sort both arrays alphabetically
 * 3️⃣ Compare them → if equal → return true, else false
 * 
 * 🧮 Example:
 * s = "listen"
 * t = "silent"
 *
 * Step 1: Convert to arrays
 *   sChars = ['l','i','s','t','e','n']
 *   tChars = ['s','i','l','e','n','t']
 *
 * Step 2: Sort them
 *   sChars → ['e','i','l','n','s','t']
 *   tChars → ['e','i','l','n','s','t']
 *
 * Step 3: Compare
 *   Equal → ✅ return true
 *
 * ⏱️ Time Complexity: O(n log n)
 * 💾 Space Complexity: O(1) or O(n) depending on char arrays
 * 
 * 🧠 Alternative idea:
 * Use a frequency counter (array of 26 letters) → O(n) time (faster for long inputs).
 */

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // ✅ Quick check: if lengths differ, can’t be anagrams
        if (s.length() != t.length()) return false;

        // 🪄 Step 1: Convert to char arrays (makes sorting possible)
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // 🧾 Optional debug prints (helpful for visual learners)
        System.out.println("Before sorting:");
        System.out.println("sChars: " + Arrays.toString(sChars));
        System.out.println("tChars: " + Arrays.toString(tChars));

        // 🌀 Step 2: Sort both arrays alphabetically
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        // 🧾 Check how they look after sorting
        System.out.println("After sorting:");
        System.out.println("Sorted sChars: " + Arrays.toString(sChars));
        System.out.println("Sorted tChars: " + Arrays.toString(tChars));

        // ✅ Step 3: Compare arrays directly
        boolean result = Arrays.equals(sChars, tChars);

        // 🧩 Print result for clarity
        System.out.println("Are they anagrams? " + result);
        System.out.println("--------------------------------");

        return result;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        // 🧪 Example 1
        System.out.println("Example 1:");
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        // Expected: true (same letters in different order)

        // 🧪 Example 2
        System.out.println("Example 2:");
        System.out.println(solution.isAnagram("rat", "car"));
        // Expected: false (different letters)

        // 🧪 Example 3
        System.out.println("Example 3:");
        System.out.println(solution.isAnagram("listen", "silent"));
        // Expected: true (classic anagram)
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(n log n)
 * - Converting strings to char arrays: O(n)
 * - Sorting both arrays: O(n log n) each
 * - Comparing arrays: O(n)
 * - Total: O(n log n) dominated by sorting
 *
 * Space Complexity: O(n)
 * - Two char arrays of length n
 * - Sorting may use additional O(log n) or O(n) space depending on implementation
 *
 * Key Insight:
 * Anagrams contain the exact same characters in different orders.
 * When sorted alphabetically, anagrams become identical strings!
 * Example: "listen" → "eilnst", "silent" → "eilnst" ✓
 *
 * Alternative Approaches:
 *
 * 1. Frequency Counter (FASTER - O(n)):
 *    Use an array to count frequency of each character
 *    Time: O(n), Space: O(1) - since only 26 letters
 *
 *    if (s.length() != t.length()) return false;
 *
 *    int[] count = new int[26];  // For lowercase a-z
 *
 *    for (int i = 0; i < s.length(); i++) {
 *        count[s.charAt(i) - 'a']++;  // Increment for s
 *        count[t.charAt(i) - 'a']--;  // Decrement for t
 *    }
 *
 *    for (int c : count) {
 *        if (c != 0) return false;  // Mismatch found
 *    }
 *    return true;
 *
 * 2. HashMap Approach:
 *    Similar to frequency counter but works with Unicode characters
 *    Time: O(n), Space: O(1) - at most 26 entries for lowercase English
 *
 *    HashMap<Character, Integer> map = new HashMap<>();
 *    for (char c : s.toCharArray()) {
 *        map.put(c, map.getOrDefault(c, 0) + 1);
 *    }
 *    for (char c : t.toCharArray()) {
 *        map.put(c, map.getOrDefault(c, 0) - 1);
 *    }
 *    for (int count : map.values()) {
 *        if (count != 0) return false;
 *    }
 *    return true;
 *
 * Comparison:
 * - Sorting: Simple to implement, O(n log n)
 * - Frequency counter: Fastest, O(n), best for interviews
 * - HashMap: Most flexible, works with any character set
 */
