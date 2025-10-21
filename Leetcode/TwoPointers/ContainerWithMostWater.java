import java.util.Arrays;

/**
 * LeetCode 11: Container With Most Water
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains
 * the most water.
 *
 * Return the maximum area of water the container can store.
 *
 * Notice: You may not slant the container.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The vertical lines are at indices 1 and 8.
 * Width = 8 - 1 = 7
 * Height = min(8, 7) = 7
 * Area = 7 * 7 = 49
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * Constraints:
 * - n == height.length
 * - 2 <= n <= 10^5
 * - 0 <= height[i] <= 10^4
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // TODO: Implement solution
        return 0;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Test case 1
        int[] test1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Test 1: height = " + Arrays.toString(test1));
        System.out.println("Output: " + solution.maxArea(test1));
        System.out.println("Expected: 49");
        System.out.println();

        // Test case 2
        int[] test2 = {1, 1};
        System.out.println("Test 2: height = " + Arrays.toString(test2));
        System.out.println("Output: " + solution.maxArea(test2));
        System.out.println("Expected: 1");
        System.out.println();
    }
}
