/**
 * LeetCode 125: Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 * Constraints:
 * - 1 <= s.length <= 2 * 10^5
 * - s consists only of printable ASCII characters.
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Two-pointer approach: start from both ends and move inward
        // Example: "A man, a plan, a canal: Panama"
        //           i→                            ←j

        for (int i = 0, j = s.length() - 1; i < j; ) {
            char left = s.charAt(i);   // Get character at left pointer
            char right = s.charAt(j);  // Get character at right pointer

            // Skip non-alphanumeric characters from the left
            // Example: when left hits ' ' or ',', move i forward
            if (!Character.isLetterOrDigit(left)) {
                i++;
            }
            // Skip non-alphanumeric characters from the right
            // Example: when right hits ' ' or ':', move j backward
            else if (!Character.isLetterOrDigit(right)) {
                j--;
            }
            // Both pointers are at alphanumeric characters, so compare them
            else {
                // Compare in lowercase: 'A' == 'a', 'M' == 'm', etc.
                if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                    return false;  // Mismatch found, not a palindrome
                }
                // Characters match, move both pointers inward
                // Example: "A man..." -> after comparing 'A' and 'a', move to next valid chars
                i++;
                j--;
            }
        }
        // All valid characters matched, it's a palindrome
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        // Test case 1
        String test1 = "A man, a plan, a canal: Panama";
        System.out.println("Test 1: \"" + test1 + "\"");
        System.out.println("Expected: true, Got: " + solution.isPalindrome(test1));
        System.out.println();

        // Test case 2
        String test2 = "race a car";
        System.out.println("Test 2: \"" + test2 + "\"");
        System.out.println("Expected: false, Got: " + solution.isPalindrome(test2));
        System.out.println();

        // Test case 3
        String test3 = " ";
        System.out.println("Test 3: \"" + test3 + "\"");
        System.out.println("Expected: true, Got: " + solution.isPalindrome(test3));
        System.out.println();
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(n)
 * - We traverse the string once with two pointers
 * - Each character is visited at most once
 * - Character.isLetterOrDigit() and Character.toLowerCase() are O(1) operations
 *
 * Space Complexity: O(1)
 * - We only use two pointers (i and j) and two character variables (left and right)
 * - No additional data structures are created
 * - The space used does not grow with input size
 *
 * Key Insight:
 * Use two pointers to avoid creating a filtered/cleaned version of the string.
 * Instead of building a new string with only alphanumeric lowercase characters (which
 * would cost O(n) space), we navigate around non-alphanumeric characters on-the-fly
 * by skipping them with pointer movements.
 *
 * Algorithm:
 * 1. Initialize two pointers:
 *    - i starts at the beginning (index 0)
 *    - j starts at the end (index s.length() - 1)
 *
 * 2. Loop while i < j (pointers haven't crossed):
 *    a. If left character is not alphanumeric, skip it (i++)
 *    b. If right character is not alphanumeric, skip it (j--)
 *    c. If both are alphanumeric:
 *       - Compare them in lowercase
 *       - If they don't match, return false (not a palindrome)
 *       - If they match, move both pointers inward (i++, j--)
 *
 * 3. If we exit the loop without finding mismatches, return true (it's a palindrome)
 *
 * Example Walkthrough with "A man, a plan, a canal: Panama":
 *
 * Initial: i=0, j=32
 * Step 1:  left='A'(0), right='a'(32)  → compare: 'a'=='a' ✓ → i=1, j=31
 * Step 2:  left=' '(1)                 → skip left → i=2
 * Step 3:  left='m'(2), right='m'(31)  → compare: 'm'=='m' ✓ → i=3, j=30
 * Step 4:  left='a'(3), right='a'(30)  → compare: 'a'=='a' ✓ → i=4, j=29
 * Step 5:  left='n'(4), right='n'(29)  → compare: 'n'=='n' ✓ → i=5, j=28
 * Step 6:  left=','(5)                 → skip left → i=6
 * Step 7:  left=' '(6)                 → skip left → i=7
 * ... (continues comparing valid characters)
 * Final:   i and j meet in the middle, all characters matched → return true
 *
 * Example Walkthrough with "race a car":
 *
 * Initial: i=0, j=9
 * Step 1:  left='r'(0), right='r'(9)   → compare: 'r'=='r' ✓ → i=1, j=8
 * Step 2:  left='a'(1), right='a'(8)   → compare: 'a'=='a' ✓ → i=2, j=7
 * Step 3:  left='c'(2), right='c'(7)   → compare: 'c'=='c' ✓ → i=3, j=6
 * Step 4:  left='e'(3), right=' '(6)   → skip right → j=5
 * Step 5:  left='e'(3), right='a'(5)   → compare: 'e'!='a' ✗ → return false
 *
 * Alternative Approaches:
 *
 * 1. Filter and Compare (Brute Force):
 *    - Create a new string with only alphanumeric lowercase characters
 *    - Reverse it and compare with the original filtered string
 *    Time: O(n), Space: O(n) - requires extra string storage
 *    Pros: Simple and readable
 *    Cons: Uses extra memory
 *
 * 2. Recursion:
 *    - Recursively compare characters from both ends
 *    - Skip non-alphanumeric characters in recursive calls
 *    Time: O(n), Space: O(n) - due to call stack
 *    Pros: Elegant solution
 *    Cons: Stack overflow risk for very long strings, extra space for call stack
 *
 * 3. Two Pointers (Current Solution):
 *    - Compare characters from both ends while skipping invalid ones
 *    Time: O(n), Space: O(1)
 *    Pros: Optimal space complexity, single pass
 *    Cons: Slightly more complex logic with multiple conditions
 */
