import java.util.Stack;

/**
 * LeetCode 20: Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * A string is valid if:
 * 1. Open brackets must be closed by the same type of closing bracket
 * 2. Open brackets must be closed in the correct order
 * 3. Every close bracket has a corresponding open bracket of the same type
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "([)]"
 * Output: false
 * Explanation: [] closes before ()
 *
 * Example 4:
 * Input: s = "{[]}"
 * Output: true
 *
 * Example 5:
 * Input: s = ""
 * Output: true
 *
 * Constraints:
 * - 0 ≤ s.length ≤ 10^4
 * - s consists of parentheses only: '(', ')', '{', '}', '[', ']'
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        // Empty string is valid
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Check if it's an opening bracket
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Handle closing brackets
            else {
                // Check if stack is empty (no matching opening bracket)
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the opening bracket from stack
                char top = stack.pop();
                // Verify that the closing bracket matches the opening bracket
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Stack should be empty at the end (all brackets matched)
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        // Test case 1
        String test1 = "()";
        System.out.println("Test 1: s = \"" + test1 + "\"");
        System.out.println("Output: " + solution.isValid(test1));
        System.out.println("Expected: true");
        System.out.println();

        // Test case 2
        String test2 = "()[]{}";;
        System.out.println("Test 2: s = \"" + test2 + "\"");
        System.out.println("Output: " + solution.isValid(test2));
        System.out.println("Expected: true");
        System.out.println();

        // Test case 3
        String test3 = "([)]";
        System.out.println("Test 3: s = \"" + test3 + "\"");
        System.out.println("Output: " + solution.isValid(test3));
        System.out.println("Expected: false");
        System.out.println();

        // Test case 4
        String test4 = "{[]}";
        System.out.println("Test 4: s = \"" + test4 + "\"");
        System.out.println("Output: " + solution.isValid(test4));
        System.out.println("Expected: true");
        System.out.println();

        // Test case 5
        String test5 = "";
        System.out.println("Test 5: s = \"" + test5 + "\"");
        System.out.println("Output: " + solution.isValid(test5));
        System.out.println("Expected: true");
        System.out.println();

        // Test case 6: Only opening brackets
        String test6 = "(((";
        System.out.println("Test 6: s = \"" + test6 + "\"");
        System.out.println("Output: " + solution.isValid(test6));
        System.out.println("Expected: false");
        System.out.println();

        // Test case 7: Only closing brackets
        String test7 = ")))";
        System.out.println("Test 7: s = \"" + test7 + "\"");
        System.out.println("Output: " + solution.isValid(test7));
        System.out.println("Expected: false");
        System.out.println();

        // Test case 8: Single opening bracket
        String test8 = "(";
        System.out.println("Test 8: s = \"" + test8 + "\"");
        System.out.println("Output: " + solution.isValid(test8));
        System.out.println("Expected: false");
        System.out.println();

        // Test case 9: Single closing bracket
        String test9 = ")";
        System.out.println("Test 9: s = \"" + test9 + "\"");
        System.out.println("Output: " + solution.isValid(test9));
        System.out.println("Expected: false");
        System.out.println();

        // Test case 10: Mixed nested brackets
        String test10 = "([{}])";
        System.out.println("Test 10: s = \"" + test10 + "\"");
        System.out.println("Output: " + solution.isValid(test10));
        System.out.println("Expected: true");
        System.out.println();

        // Test case 11: Wrong closing bracket
        String test11 = "(]";
        System.out.println("Test 11: s = \"" + test11 + "\"");
        System.out.println("Output: " + solution.isValid(test11));
        System.out.println("Expected: false");
        System.out.println();

        // Test case 12: Reversed brackets
        String test12 = ")(";
        System.out.println("Test 12: s = \"" + test12 + "\"");
        System.out.println("Output: " + solution.isValid(test12));
        System.out.println("Expected: false");
        System.out.println();

        // Test case 13: Complex valid case
        String test13 = "{[()]}";
        System.out.println("Test 13: s = \"" + test13 + "\"");
        System.out.println("Output: " + solution.isValid(test13));
        System.out.println("Expected: true");
        System.out.println();

        // Test case 14: Closing before opening
        String test14 = "{(})";
        System.out.println("Test 14: s = \"" + test14 + "\"");
        System.out.println("Output: " + solution.isValid(test14));
        System.out.println("Expected: false");
        System.out.println();
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(n)
 * - We iterate through each character in the string once
 * - Each push and pop operation on the stack is O(1)
 *
 * Space Complexity: O(n)
 * - In the worst case, all characters are opening brackets, so the stack stores all of them
 * - Maximum stack size is n/2 (half the string length)
 *
 * Key Insight:
 * Parentheses/brackets must close in LIFO (Last In First Out) order.
 * A stack naturally enforces this ordering.
 * We use the stack to track opening brackets and verify they match with closing brackets.
 *
 * Algorithm:
 * 1. Handle empty string edge case (return true)
 * 2. Create a stack to store opening brackets
 * 3. For each character in the string:
 *    a. If it's an opening bracket (( [ {):
 *       - Push it onto the stack
 *    b. If it's a closing bracket () } ]):
 *       - Check if stack is empty → return false (unmatched closing bracket)
 *       - Pop from stack and verify it matches the closing bracket
 *       - If it doesn't match → return false (wrong bracket type)
 * 4. After processing all characters:
 *    - Return true if stack is empty (all brackets matched)
 *    - Return false if stack is not empty (unmatched opening brackets)
 *
 * Example walkthrough for "([)]":
 *
 * Step 1: c = '(' → Opening bracket. Push '('. Stack: [
 * Step 2: c = '[' → Opening bracket. Push '['. Stack: [(,[
 * Step 3: c = ')' → Closing bracket.
 *         - Stack not empty ✓
 *         - Pop '[' from stack
 *         - Check: ')' matches '['? NO
 *         - Return false ✗
 *
 * Example walkthrough for "({[]})":
 *
 * Step 1: c = '(' → Push '('. Stack: [(
 * Step 2: c = '{' → Push '{'. Stack: [(,{
 * Step 3: c = '[' → Push '['. Stack: [(,{,[
 * Step 4: c = ']' → Pop '['. Check: ']' matches '['? YES ✓. Stack: [(,{
 * Step 5: c = '}' → Pop '{'. Check: '}' matches '{'? YES ✓. Stack: [(
 * Step 6: c = ')' → Pop '('. Check: ')' matches '('? YES ✓. Stack: []
 * Return stack.isEmpty() = true ✓
 *
 * Why This Works:
 * - We process brackets left to right
 * - Opening brackets are pushed (stored for later matching)
 * - Closing brackets are matched immediately with the most recent opening bracket
 * - This ensures correct nesting (LIFO order)
 * - Stack empty at end means all brackets were properly matched
 *
 * Edge Cases Handled:
 * 1. Empty string → return true (no unmatched brackets)
 * 2. Only opening brackets → stack not empty at end → return false
 * 3. Only closing brackets → stack empty when trying to pop → return false
 * 4. Wrong bracket type → mismatch detected → return false
 * 5. Wrong order like "([)]" → detected when popping → return false
 *
 * Alternative Approaches:
 *
 * 1. Using HashMap (Our approach with if-else is simpler):
 *    - Create a map: ')' → '(', '}' → '{', ']' → '['
 *    - Still use stack, but lookup matching bracket from map
 *    Time: O(n), Space: O(n) + O(3) = O(n)
 *
 * 2. Recursive approach:
 *    - Recursively find and remove matching bracket pairs
 *    - Keep reducing string until empty or no pairs found
 *    Time: O(n²) worst case, Space: O(n) recursion stack
 *    Disadvantage: Slower and less intuitive
 *
 * 3. Two pass with counting:
 *    - First pass: count opening brackets
 *    - Second pass: count closing brackets, ensure they match
 *    Time: O(n), Space: O(1)
 *    Disadvantage: Doesn't catch order/type mismatch (like "([)]")
 *
 * Gato Style Summary:
 * - One-liner: "Push opening brackets, pop and verify when you see closing brackets"
 * - Analogy: "Like a perfectly nested set of boxes. When you open a box, you must close
 *   the most recently opened one before closing earlier ones. A stack naturally tracks this."
 */
