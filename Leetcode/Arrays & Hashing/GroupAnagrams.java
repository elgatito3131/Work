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
 * - "eat", "tea", "ate" are anagrams (same letters: e, a, t)
 * - "tan", "nat" are anagrams (same letters: t, a, n)
 * - "bat" is alone
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Example 4:
 * Input: strs = ["abc","bca","cab","xyz","zyx","dog"]
 * Output: [["abc","bca","cab"],["xyz","zyx"],["dog"]]
 * Explanation:
 * - "abc", "bca", "cab" are all anagrams
 * - "xyz", "zyx" are anagrams
 * - "dog" is alone
 *
 * Constraints:
 * - 1 <= strs.length <= 10^4
 * - 0 <= strs[i].length <= 100
 * - strs[i] consists of lowercase English letters
 */

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // Step 1: Create a HashMap to group anagrams
        // Key = sorted string (anagram signature)
        // Value = list of original strings with that signature
        HashMap<String, List<String>> map = new HashMap<>();

        // Step 2: Process each string in the input array
        for (String s : strs) {
            // Example: s = "eat"

            // Convert string to char array for sorting
            char[] charArray = s.toCharArray();
            // charArray = ['e', 'a', 't']

            // Sort the characters alphabetically
            Arrays.sort(charArray);
            // After sort: ['a', 'e', 't']

            // Convert sorted char array back to string (this is our key)
            String sorted = new String(charArray);
            // sorted = "aet" (this will be the same for "eat", "tea", "ate")

            // Check if this anagram group exists in the map
            if (!map.containsKey(sorted)) {
                // If not, create a new list for this anagram group
                map.put(sorted, new ArrayList<>());
            }
            // map = {"aet": []}

            // Add the original string to its anagram group
            map.get(sorted).add(s);
            // map = {"aet": ["eat"]}
        }
        // After all strings processed:
        // map = {"aet": ["eat", "tea", "ate"], "abt": ["bat"], "ant": ["tan", "nat"]}

        // Step 3: Return all the grouped lists (the values from the map)
        return new ArrayList<>(map.values());
        // Returns: [["eat", "tea", "ate"], ["bat"], ["tan", "nat"]]
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
        System.out.println();

        // Test case 4
        String[] strs4 = {"abc", "bca", "cab", "xyz", "zyx", "dog"};
        List<List<String>> result4 = solution.groupAnagrams(strs4);
        System.out.println("Test 4:");
        System.out.println("Input: " + Arrays.toString(strs4));
        System.out.println("Output: " + result4);
        System.out.println("Expected: [[\"abc\",\"bca\",\"cab\"],[\"xyz\",\"zyx\"],[\"dog\"]] (in any order)");
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(n * k log k) where n = number of strings, k = max length of a string
 * - We iterate through all n strings: O(n)
 * - For each string, we sort it which takes O(k log k) where k is the length of the string
 * - Overall: O(n * k log k)
 *
 * Space Complexity: O(n * k)
 * - HashMap stores all n strings as values: O(n * k)
 * - Each key (sorted string) is at most k characters: O(n * k)
 * - Result list contains all n strings: O(n * k)
 * - Overall: O(n * k)
 *
 * Key Insight:
 * Anagrams have the same characters in the same frequencies. If we sort the characters
 * of two anagrams, they will produce identical sorted strings. We can use this sorted
 * string as a unique "signature" or key to group all anagrams together in a HashMap.
 *
 * Algorithm:
 * 1. Create a HashMap where:
 *    - Key = sorted version of the string (anagram signature)
 *    - Value = list of all original strings that have this signature
 *
 * 2. Traverse through the input array of strings:
 *    - For each string, convert it to a char array and sort it
 *    - Use the sorted string as the key in the HashMap
 *    - Check if the key exists in the map:
 *      - If it doesn't exist: create a new ArrayList for this key
 *      - If it does exist: get the existing list
 *    - Add the original (unsorted) string to the list
 *
 * 3. Return all values from the HashMap:
 *    - The values are lists of strings grouped by anagram
 *    - Convert map.values() to ArrayList and return
 *
 * Example walkthrough with ["eat","tea","tan","ate","nat","bat"]:
 *
 * Initial state: map = {}
 *
 * Process "eat":
 *   - charArray = ['e','a','t']
 *   - After sort: ['a','e','t']
 *   - sorted = "aet"
 *   - map doesn't contain "aet", so create new list
 *   - Add "eat" to list
 *   - map = {"aet": ["eat"]}
 *
 * Process "tea":
 *   - charArray = ['t','e','a']
 *   - After sort: ['a','e','t']
 *   - sorted = "aet"
 *   - map contains "aet", get existing list
 *   - Add "tea" to list
 *   - map = {"aet": ["eat", "tea"]}
 *
 * Process "tan":
 *   - charArray = ['t','a','n']
 *   - After sort: ['a','n','t']
 *   - sorted = "ant"
 *   - map doesn't contain "ant", create new list
 *   - Add "tan" to list
 *   - map = {"aet": ["eat", "tea"], "ant": ["tan"]}
 *
 * Process "ate":
 *   - charArray = ['a','t','e']
 *   - After sort: ['a','e','t']
 *   - sorted = "aet"
 *   - map contains "aet", get existing list
 *   - Add "ate" to list
 *   - map = {"aet": ["eat", "tea", "ate"], "ant": ["tan"]}
 *
 * Process "nat":
 *   - charArray = ['n','a','t']
 *   - After sort: ['a','n','t']
 *   - sorted = "ant"
 *   - map contains "ant", get existing list
 *   - Add "nat" to list
 *   - map = {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"]}
 *
 * Process "bat":
 *   - charArray = ['b','a','t']
 *   - After sort: ['a','b','t']
 *   - sorted = "abt"
 *   - map doesn't contain "abt", create new list
 *   - Add "bat" to list
 *   - map = {"aet": ["eat", "tea", "ate"], "ant": ["tan", "nat"], "abt": ["bat"]}
 *
 * Return map.values():
 *   - Returns: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
 *
 * Alternative Approaches:
 *
 * 1. Character Frequency Array as Key - O(n * k) time:
 *    - Instead of sorting, count character frequencies
 *    - Create a frequency array of size 26 (for 'a'-'z')
 *    - Convert frequency array to string for use as HashMap key
 *    - Example: "eat" → [1,0,0,0,1,0,...,1] → "1#0#0#0#1#0...#1"
 *    - No sorting needed, so time is O(n * k)
 *    Time: O(n * k), Space: O(n * k)
 *    Better time complexity, but more space for keys
 *
 * 2. Prime Number Multiplication - O(n * k) time:
 *    - Assign each character a unique prime number
 *    - 'a' = 2, 'b' = 3, 'c' = 5, etc.
 *    - Multiply the prime values for all characters in the string
 *    - Anagrams will have the same product (commutative property)
 *    - Use product as key in HashMap
 *    Time: O(n * k), Space: O(n * k)
 *    Risk: Large products may cause overflow for long strings
 */
