/**
 * LeetCode 49: Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Explanation:
 * - "eat", "tea", "ate" are anagrams
 * - "tan", "nat" are anagrams
 * - "bat" is by itself
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
 * - strs[i] consists of lowercase English letters
 */

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // TODO: Implement solution
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        // Test case 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(strs1);
        System.out.println("Test 1:");
        System.out.println("Input: " + Arrays.toString(strs1));
        System.out.println("Output: " + result1);
        System.out.println("Expected: [[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]] (in any order)");
        System.out.println();

        // Test case 2
        String[] strs2 = {""};
        List<List<String>> result2 = solution.groupAnagrams(strs2);
        System.out.println("Test 2:");
        System.out.println("Input: " + Arrays.toString(strs2));
        System.out.println("Output: " + result2);
        System.out.println("Expected: [[\"\"]]");
        System.out.println();

        // Test case 3
        String[] strs3 = {"a"};
        List<List<String>> result3 = solution.groupAnagrams(strs3);
        System.out.println("Test 3:");
        System.out.println("Input: " + Arrays.toString(strs3));
        System.out.println("Output: " + result3);
        System.out.println("Expected: [[\"a\"]]");
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(?)
 * -
 *
 * Space Complexity: O(?)
 * -
 *
 * Key Insight:
 *
 *
 * Algorithm:
 *
 *
 * Example walkthrough:
 *
 *
 * Alternative Approaches:
 * 1. Approach name:
 *
 *    Time: O(?), Space: O(?)
 *
 * 2. Another approach:
 *
 *    Time: O(?), Space: O(?)
 */
