/**
 * LeetCode 49: Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Explanation:
 * - "bat" is grouped alone.
 * - "nat" and "tan" are anagrams and grouped together.
 * - "ate", "eat", and "tea" are anagrams and grouped together.
 * Note: The order of groups and the order of strings within each group do not matter.
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * - 1 <= strs.length <= 10^4
 * - 0 <= strs[i].length <= 100
 * - strs[i] consists of lowercase English letters.
 */

import java.util.*;

public class CodexGroupAnagram {
    // Returns a list of anagram groups for the given array of strings
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        /*
         * Walkthrough (Example 1): ["eat","tea","tan","ate","nat","bat"]
         *
         * Start: groups = {}
         * i=0, s="eat" -> chars=['e','a','t'] -> sort -> ['a','e','t'] -> key="aet"
         *   groups["aet"] = ["eat"]
         *   groups = { "aet": ["eat"] }
         *
         * i=1, s="tea" -> chars=['t','e','a'] -> sort -> ['a','e','t'] -> key="aet"
         *   groups["aet"] exists -> append "tea"
         *   groups = { "aet": ["eat","tea"] }
         *
         * i=2, s="tan" -> chars=['t','a','n'] -> sort -> ['a','n','t'] -> key="ant"
         *   groups["ant"] = ["tan"]
         *   groups = { "aet": ["eat","tea"], "ant": ["tan"] }
         *
         * i=3, s="ate" -> chars=['a','t','e'] -> sort -> ['a','e','t'] -> key="aet"
         *   groups["aet"] exists -> append "ate"
         *   groups = { "aet": ["eat","tea","ate"], "ant": ["tan"] }
         *
         * i=4, s="nat" -> chars=['n','a','t'] -> sort -> ['a','n','t'] -> key="ant"
         *   groups["ant"] exists -> append "nat"
         *   groups = { "aet": ["eat","tea","ate"], "ant": ["tan","nat"] }
         *
         * i=5, s="bat" -> chars=['b','a','t'] -> sort -> ['a','b','t'] -> key="abt"
         *   groups["abt"] = ["bat"]
         *   groups = { "aet": ["eat","tea","ate"], "ant": ["tan","nat"], "abt": ["bat"] }
         *
         * Return values grouped by anagram key: [["eat","tea","ate"], ["tan","nat"], ["bat"]]
         */
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars); // canonical key for anagram groups
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        CodexGroupAnagram solution = new CodexGroupAnagram();

        String[] ex1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("Output: " + solution.groupAnagrams(ex1) + "\nExpected: [[bat],[nat,tan],[ate,eat,tea]] (order may vary)");

        String[] ex2 = {""};
        String dq = "\""; // double-quote character
        System.out.println("Output: " + solution.groupAnagrams(ex2) + "\nExpected: [[" + dq + dq + "]] (order may vary)");

        String[] ex3 = {"a"};
        System.out.println("Output: " + solution.groupAnagrams(ex3) + "\nExpected: [[a]] (order may vary)");

        // Extra test: duplicates and empty strings
        String[] ex4 = {"", "", "b", "bb", "b"};
        System.out.println(
            "Output: " + solution.groupAnagrams(ex4)
            + "\nExpected: [[" + "\"" + "\"" + "," + "\"" + "\"" + "],[b,b],[bb]] (order may vary)"
        );
    }
}

/*
 * NOTES (to add AFTER finalizing solution behavior):
 *
 * Time Complexity: O(N · K log K) where N is number of strings and K is max string length (sorting each string).
 * Space Complexity: O(N · K) for map keys and output lists.
 *
 * Key Insight:
 * - Sorting each string produces a canonical form that is identical for anagrams.
 *
 * Algorithm:
 * 1) Initialize a HashMap<String, List<String>>.
 * 2) For each string, sort its chars to form the key and append to the corresponding list.
 * 3) Return the map's values as a list.
 *
 * Example walkthrough:
 * - Input: ["eat","tea","tan","ate","nat","bat"]
 * - Keys: "aet" -> [eat, tea, ate]; "ant" -> [tan, nat]; "abt" -> [bat]
 *
 * Alternative Approaches:
 * 1) Frequency key (26-length array): Time O(N · (K + 26)), Space O(N · 26)
 * 2) Prime multiplication key: Avoids sorting but risks overflow; more complex.
 */
