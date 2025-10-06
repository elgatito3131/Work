import java.util.*;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * - 1 <= s.length, t.length <= 5 * 10^4
 * - s and t consist of lowercase English letters.
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution?
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) - fixed size array of 26
 */

public class ValidAnagram {

    // Approach 1: Using frequency array (optimal for lowercase only)
    public boolean isAnagram(String s, String t) {
        // Quick check: different lengths can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Count characters in s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Subtract characters in t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        // Check if all counts are zero
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    // Approach 2: Using HashMap (works for Unicode)
    public boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> count = new HashMap<>();

        // Count characters in s
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Subtract characters in t
        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) - 1);
        }

        // Check if all counts are zero
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }

    // Approach 3: Sorting (simple but slower)
    public boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        // Test case 1: Valid anagram
        assert solution.isAnagram("anagram", "nagaram") == true;

        // Test case 2: Not an anagram
        assert solution.isAnagram("rat", "car") == false;

        // Test case 3: Single character
        assert solution.isAnagram("a", "a") == true;

        // Test case 4: Different lengths
        assert solution.isAnagram("abc", "abcd") == false;

        // Test case 5: Empty strings
        assert solution.isAnagram("", "") == true;

        // Test case 6: All same character
        assert solution.isAnagram("aaaa", "aaaa") == true;

        // Test case 7: Same characters different count
        assert solution.isAnagram("aab", "abb") == false;

        System.out.println("All tests passed!");
    }
}

/**
 * REFRESHER:
 * - Input: two strings s and t.
 * - Goal: check if t is an anagram of s (same letters, different order).
 *
 * LAZY-FRIENDLY GAME PLAN:
 * 1. Quick check: if lengths differ, return false immediately.
 * 2. Create a frequency counter (array of 26 for lowercase letters).
 * 3. Walk through string s, incrementing count for each character.
 * 4. Walk through string t, decrementing count for each character.
 * 5. Check if all counts are zero - if yes, it's an anagram!
 *
 * WHY IT WORKS:
 * Anagrams have the exact same character frequencies. By incrementing for s and
 * decrementing for t, everything should cancel out to zero. Time is O(n) where n
 * is string length. Space is O(1) since array size is fixed at 26.
 *
 * TIPS:
 * - Array approach: fastest for lowercase only, count[c - 'a'] maps a→0, b→1, etc.
 * - HashMap approach: more flexible, handles Unicode, slightly slower.
 * - Sorting approach: O(n log n) time, simpler to code but not optimal.
 * - Early exit: check lengths first before doing any work.
 * - Alternative: sort both strings and compare - simple but slower.
 * - For Unicode/special chars, must use HashMap instead of fixed array.
 */
