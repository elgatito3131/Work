/**
 * LeetCode 271: Encode and Decode Strings
 *
 * Design an algorithm to encode a list of strings to a single string.
 * The encoded string is then decoded back to the original list of strings.
 *
 * Please implement encode and decode methods.
 *
 * Example 1:
 * Input: ["hello","world"]
 * Output: ["hello","world"]
 * Explanation:
 * One possible encode method is: "hello" + "world" (but this doesn't work because we can't tell where one string ends)
 * A better approach: Use a delimiter or length encoding
 *
 * Example 2:
 * Input: [""]
 * Output: [""]
 *
 * Example 3:
 * Input: ["a","b","c"]
 * Output: ["a","b","c"]
 *
 * Constraints:
 * - 0 <= strs.length < 200
 * - 0 <= strs[i].length < 200
 * - strs[i] contains any possible characters out of 256 valid ASCII characters
 * - The string may contain any possible characters, including delimiters
 *
 * Note: The string may contain any of the 256 legal ASCII characters, so simple delimiters won't work.
 * You need a robust encoding scheme.
 */

import java.util.*;

public class EncodeDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder mainString = new StringBuilder();

        for (String str : strs) {
            mainString.append(str.length()).append("#").append(str);
        }

        return mainString.toString();
    }

    // Decodes a single string to a list of strings.
    // WALKTHROUGH with input "5#hello5#world":
    // Initial state: s = "5#hello5#world", i = 0, result = []
    public List<String> decode(String s) {
        List<String> decodedStrings = new ArrayList<>();
        int i = 0;  // Main pointer: tracks our current position in the encoded string
        int n = s.length();

        // Process the encoded string until we've read everything
        while (i < n) {
            // === FIRST ITERATION (decoding "hello") ===
            // Current state: i = 0, s = "5#hello5#world"

            // Step 1: Find where the length number ends (look for the '#' delimiter)
            int j = i;  // j = 0
            while (j < n && s.charAt(j) != '#') {
                j++;  // j moves: 0 -> 1, then stops at position 1 because s.charAt(1) = '#'
            }
            // After loop: j = 1 (pointing at '#')

            if (j == n) break;  // Safety check: no '#' found means no more data

            // Step 2: Extract and parse the length
            int length = Integer.parseInt(s.substring(i, j));  // s.substring(0, 1) = "5", length = 5

            // Step 3: Move past the '#' delimiter
            i = j + 1;  // i = 1 + 1 = 2 (now pointing at 'h' in "hello")

            // Step 4: Extract exactly 'length' characters
            String str = s.substring(i, i + length);  // s.substring(2, 7) = "hello"
            decodedStrings.add(str);  // result = ["hello"]

            // Step 5: Move to the start of the next encoded segment
            i += length;  // i = 2 + 5 = 7 (now pointing at '5' in "5#world")

            // === SECOND ITERATION (decoding "world") ===
            // Current state: i = 7, s = "5#hello5#world", result = ["hello"]

            // Step 1: Find the next '#'
            // j = 7
            // j moves: 7 -> 8, then stops at position 8 because s.charAt(8) = '#'
            // After loop: j = 8

            // Step 2: Extract length
            // s.substring(7, 8) = "5", length = 5

            // Step 3: Move past '#'
            // i = 8 + 1 = 9 (now pointing at 'w' in "world")

            // Step 4: Extract the string
            // s.substring(9, 14) = "world"
            // result = ["hello", "world"]

            // Step 5: Move forward
            // i = 9 + 5 = 14 (i now equals n, so loop will exit)

            // === LOOP EXITS ===
            // Final result: ["hello", "world"]
        }

        return decodedStrings;
    }

    public static void main(String[] args) {
        EncodeDecodeStrings codec = new EncodeDecodeStrings();

        // Test case 1: Regular strings
        List<String> test1 = Arrays.asList("hello", "world");
        String encoded1 = codec.encode(test1);
        List<String> decoded1 = codec.decode(encoded1);
        System.out.println("Test 1: " + test1);
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + decoded1);
        System.out.println("Match: " + test1.equals(decoded1));
        System.out.println();

        // Test case 2: Empty string
        List<String> test2 = Arrays.asList("");
        String encoded2 = codec.encode(test2);
        List<String> decoded2 = codec.decode(encoded2);
        System.out.println("Test 2: " + test2);
        System.out.println("Decoded: " + decoded2);
        System.out.println("Match: " + test2.equals(decoded2));
        System.out.println();

        // Test case 3: Multiple single characters
        List<String> test3 = Arrays.asList("a", "b", "c");
        String encoded3 = codec.encode(test3);
        List<String> decoded3 = codec.decode(encoded3);
        System.out.println("Test 3: " + test3);
        System.out.println("Decoded: " + decoded3);
        System.out.println("Match: " + test3.equals(decoded3));
        System.out.println();

        // Test case 4: Strings with special characters
        List<String> test4 = Arrays.asList("a:b", "c#d", "e,f");
        String encoded4 = codec.encode(test4);
        List<String> decoded4 = codec.decode(encoded4);
        System.out.println("Test 4: " + test4);
        System.out.println("Decoded: " + decoded4);
        System.out.println("Match: " + test4.equals(decoded4));
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(n)
 * - Encode: O(n) where n is the total number of characters across all strings.
 *   We iterate through each string once and append to StringBuilder.
 * - Decode: O(n) where n is the length of the encoded string.
 *   We scan through the encoded string once, parsing lengths and extracting substrings.
 *
 * Space Complexity: O(n)
 * - Encode: O(n) for the StringBuilder that holds the encoded result
 * - Decode: O(n) for the result list containing all decoded strings
 *
 * Key Insight:
 * Use LENGTH PREFIX encoding with a delimiter. The pattern is: length + "#" + actual_string.
 * This works even when strings contain ANY characters (including the delimiter "#") because
 * we know exactly how many characters to read after the "#" - we don't search for another
 * delimiter within the string content.
 *
 * Algorithm:
 * Encode:
 * 1. For each string in the list:
 *    a. Append the length of the string
 *    b. Append the delimiter "#"
 *    c. Append the actual string content
 * 2. Return the concatenated result
 *
 * Decode:
 * 1. Use a pointer i to traverse the encoded string
 * 2. While there are characters remaining:
 *    a. Find the next "#" delimiter to extract the length
 *    b. Parse the length as an integer
 *    c. Skip past the "#"
 *    d. Read exactly 'length' characters to get the original string
 *    e. Add to result list
 *    f. Move pointer to the next encoded segment
 *
 * Example walkthrough:
 * Input: ["hello", "world"]
 *
 * Encoding:
 * - "hello" has length 5 → append "5#hello"
 * - "world" has length 5 → append "5#world"
 * - Result: "5#hello5#world"
 *
 * Decoding "5#hello5#world":
 * - i=0: Read until '#' → get "5", parse as 5
 * - Skip '#', read 5 chars: "hello" → add to result
 * - i=7: Read until '#' → get "5", parse as 5
 * - Skip '#', read 5 chars: "world" → add to result
 * - Final result: ["hello", "world"]
 *
 * Why this handles special characters:
 * Input: ["c#d"]
 * - Encoded: "3#c#d"
 * - Decoding: Read "3", skip "#", read EXACTLY 3 chars: "c#d"
 * - The "#" inside "c#d" is just data, not a delimiter, because we count characters
 *
 * Alternative Approaches:
 * 1. Escape sequences:
 *    Use a delimiter like "," but escape any occurrences in the data (e.g., "," becomes "\,")
 *    Requires escaping the escape character itself, making it more complex
 *    Time: O(n), Space: O(n)
 *    Drawback: More complex to implement correctly, especially with nested escaping
 *
 * 2. Non-ASCII delimiter:
 *    Use a non-printable character (like ASCII 257 or Unicode)
 *    Problem: Still not guaranteed to be unique, and strings can contain any character
 *    Time: O(n), Space: O(n)
 *    Drawback: Not robust for all possible inputs
 */
