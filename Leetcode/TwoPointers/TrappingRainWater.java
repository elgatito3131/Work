import java.util.Arrays;

/**
 * LeetCode 11: Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * Visualization:
 * The bars represent terrain heights. Water fills in the valleys.
 *
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation:
 * The terrain looks like:
 *       |
 *     | | |
 *   | | | |
 * | | | | | | | | |
 * After raining, water (represented by ~) fills:
 *       |
 *     |~|~|
 *   |~| |~|
 * | | | | | | | | |
 * Water trapped = 6 units
 *
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * Explanation:
 *     |
 *     |     |
 *   | |~~~~ |
 *   | |~~~ ||
 *   | | ~||
 * | || |||
 * Water trapped = 9 units
 *
 * Constraints:
 * - n == height.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= height[i] <= 10^5
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        // TODO: Implement solution
        return 0;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Test case 1
        int[] test1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Test 1: height = " + Arrays.toString(test1));
        System.out.println("Output: " + solution.trap(test1));
        System.out.println("Expected: 6");
        System.out.println();

        // Test case 2
        int[] test2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Test 2: height = " + Arrays.toString(test2));
        System.out.println("Output: " + solution.trap(test2));
        System.out.println("Expected: 9");
        System.out.println();

        // Test case 3
        int[] test3 = {2, 0, 2};
        System.out.println("Test 3: height = " + Arrays.toString(test3));
        System.out.println("Output: " + solution.trap(test3));
        System.out.println("Expected: 2");
        System.out.println();
    }
}
