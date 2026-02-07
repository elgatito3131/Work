import java.util.*;

/**
 * LeetCode 36: Valid Sudoku
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated
 * according to the following rules:
 *
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * - Only the filled cells need to be validated according to the mentioned rules.
 *
 * Example 1:
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 *
 * Example 2:
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * Constraints:
 * - board.length == 9
 * - board[i].length == 9
 * - board[i][j] is a digit 1-9 or '.'
 */

public class ValidSudoku {

    // ========== APPROACH 1: Single HashSet with String Keys ==========
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];

                // Skip empty cells
                if (num == '.') continue;

                // Calculate which 3x3 box this cell belongs to
                int boxIndex = (row / 3) * 3 + (col / 3);

                // Create unique keys for row, column, and box
                String rowKey = num + " in row " + row;
                String colKey = num + " in col " + col;
                String boxKey = num + " in box " + boxIndex;

                // If any key already exists, we found a duplicate
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }

    // ========== APPROACH 2: Array of HashSets ==========
    public boolean isValidSudokuV2(char[][] board) {
        // Create 9 sets for rows, 9 for columns, 9 for boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize all sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];

                // Skip empty cells
                if (num == '.') continue;

                // Calculate which 3x3 box this cell belongs to
                int boxIndex = (row / 3) * 3 + (col / 3);

                // Check if num already exists in current row, column, or box
                if (rows[row].contains(num) ||
                    cols[col].contains(num) ||
                    boxes[boxIndex].contains(num)) {
                    return false;
                }

                // Add to all three sets
                rows[row].add(num);
                cols[col].add(num);
                boxes[boxIndex].add(num);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();

        // Test case 1: Valid board
        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Test 1 (Valid): " + solution.isValidSudoku(board1)); // Expected: true

        // Test case 2: Invalid board (duplicate 8 in top-left 3x3 box)
        char[][] board2 = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Test 2 (Invalid): " + solution.isValidSudoku(board2)); // Expected: false

        // Test case 3: Empty board (all dots)
        char[][] board3 = {
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'}
        };
        System.out.println("Test 3 (Empty): " + solution.isValidSudoku(board3)); // Expected: true

        // Test case 4: Invalid board (duplicate 8 in row 0 at positions 1 and 7)
        char[][] board4 = {
            {'.','8','.','.','.','.','.','8','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'}
        };
        System.out.println("Test 4 (Duplicate 8 in row 0): " + solution.isValidSudoku(board4)); // Expected: false
    }
}

/*
 * NOTES:
 *
 * ==================== APPROACH 1: Single HashSet with String Keys ====================
 *
 * Time Complexity: O(1) or O(81) = O(1)
 * - We always iterate through exactly 9x9 = 81 cells (constant, not dependent on input size)
 * - HashSet.add() is O(1) average case
 * - We do 3 add operations per cell: O(81 * 3) = O(243) = O(1)
 *
 * Space Complexity: O(1) or O(81) = O(1)
 * - In the worst case (board completely filled), we store:
 *   - 9 rows * 9 digits = 81 row entries
 *   - 9 cols * 9 digits = 81 col entries
 *   - 9 boxes * 9 digits = 81 box entries
 *   - Total: 243 strings maximum (constant, not dependent on input size)
 *
 * Key Insight:
 * Use string encoding to create unique identifiers for each constraint:
 * - "5 in row 0" means digit 5 appears in row 0
 * - "5 in col 3" means digit 5 appears in column 3
 * - "5 in box 1" means digit 5 appears in box 1
 *
 * The clever part: HashSet.add() returns false if element already exists!
 * So if any add() returns false, we found a duplicate.
 *
 * ==================== APPROACH 2: Array of HashSets ====================
 *
 * Time Complexity: O(1) or O(81) = O(1)
 * - Same as Approach 1: always 81 cells to check
 * - Contains check: O(1) average
 * - Add operation: O(1) average
 *
 * Space Complexity: O(1) or O(81) = O(1)
 * - 27 HashSets total (9 rows + 9 cols + 9 boxes)
 * - Each set stores at most 9 characters
 * - Total storage: 27 * 9 = 243 characters maximum (constant)
 *
 * Key Insight:
 * More explicit structure using separate data structures for tracking:
 * - rows[i] = HashSet containing all digits seen in row i
 * - cols[j] = HashSet containing all digits seen in column j
 * - boxes[k] = HashSet containing all digits seen in box k
 *
 * This approach is slightly more memory efficient (stores chars instead of strings)
 * and conceptually clearer.
 *
 * ==================== Box Index Formula Explained ====================
 *
 * Formula: boxIndex = (row / 3) * 3 + (col / 3)
 *
 * Box numbering (0-8):
 * ┌─────┬─────┬─────┐
 * │  0  │  1  │  2  │   rows 0-2
 * ├─────┼─────┼─────┤
 * │  3  │  4  │  5  │   rows 3-5
 * ├─────┼─────┼─────┤
 * │  6  │  7  │  8  │   rows 6-8
 * └─────┴─────┴─────┘
 *  cols  cols  cols
 *  0-2   3-5   6-8
 *
 * Why it works:
 * - row / 3 gives you the "box row" (0, 1, or 2)
 * - Multiply by 3 to get the starting box index for that row (0, 3, or 6)
 * - col / 3 gives you the "box column" offset (0, 1, or 2)
 * - Add them together to get the final box index
 *
 * Examples:
 * - Cell (0,0): (0/3)*3 + (0/3) = 0*3 + 0 = 0 ✓
 * - Cell (2,5): (2/3)*3 + (5/3) = 0*3 + 1 = 1 ✓
 * - Cell (4,7): (4/3)*3 + (7/3) = 1*3 + 2 = 5 ✓
 * - Cell (8,8): (8/3)*3 + (8/3) = 2*3 + 2 = 8 ✓
 *
 * ==================== Example Walkthrough ====================
 *
 * Board (simplified 3x3 view of top-left box):
 * 5 3 .
 * 6 . .
 * . 9 8
 *
 * Iteration for Approach 1:
 * Cell (0,0) = '5', box = (0/3)*3 + (0/3) = 0
 *   Add: "5 in row 0", "5 in col 0", "5 in box 0"
 *
 * Cell (0,1) = '3', box = (0/3)*3 + (1/3) = 0
 *   Add: "3 in row 0", "3 in col 1", "3 in box 0"
 *
 * Cell (0,2) = '.', skip
 *
 * Cell (1,0) = '6', box = (1/3)*3 + (0/3) = 0
 *   Add: "6 in row 1", "6 in col 0", "6 in box 0"
 *
 * If we encountered another '5' in row 0, "5 in row 0" would already exist,
 * add() would return false, and we'd immediately return false.
 *
 * ==================== Comparison ====================
 *
 * Approach 1 (Single HashSet):
 * ✅ Pros:
 *   - More concise (one data structure)
 *   - Easier to understand at first glance
 *   - Flexible (easy to add more constraints)
 *
 * ❌ Cons:
 *   - String concatenation overhead
 *   - More memory per entry (strings vs chars)
 *
 * Approach 2 (Array of HashSets):
 * ✅ Pros:
 *   - More efficient (no string creation)
 *   - Explicit structure (clear what each array represents)
 *   - Common competitive programming pattern
 *
 * ❌ Cons:
 *   - More boilerplate (initialize 27 sets)
 *   - Slightly more code to manage
 *
 * Both are O(1) time and space, so pick based on personal preference!
 * In interviews, either approach is perfectly valid.
 */
