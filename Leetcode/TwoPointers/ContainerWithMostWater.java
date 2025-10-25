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
 * Area = 7 * 7 = 49m
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
        // Two Pointers Approach
        // Start with pointers at both ends (maximum width)
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        // Main loop: process until pointers meet
        while (left < right) {
            // Calculate current area
            // Width = distance between pointers
            // Height = minimum of the two bars (water level limited by shorter bar)
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;

            // Update maxArea if current area is larger
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer with the shorter bar inward
            // This is because moving the taller bar can only decrease area
            // (width decreases, height can't increase because it's limited by the shorter bar)
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
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

/*
 * NOTES:
 *
 * Time Complexity: O(n)
 * - Single pass through the array with two pointers
 * - Each element is visited at most once
 *
 * Space Complexity: O(1)
 * - Only using constant extra space (pointers and variables)
 * - No additional data structures needed
 *
 * Key Insight:
 * Area = width × height, where height = min(height[left], height[right])
 * Starting from both ends gives us maximum width.
 * To increase area, we must increase height (since width only decreases as we move inward).
 * The only way to potentially increase height is to move the SHORTER bar inward.
 * Moving the taller bar would only decrease area (width shrinks, height can't increase).
 *
 * Algorithm (Two Pointers Greedy):
 * 1. Start with pointers at both ends: left = 0, right = n-1
 * 2. Initialize maxArea = 0
 * 3. While left < right:
 *    a. Calculate current area = (right - left) × min(height[left], height[right])
 *    b. Update maxArea if current area is larger
 *    c. Move the pointer pointing to the shorter bar:
 *       - If height[left] < height[right]: left++
 *       - Else: right--
 * 4. Return maxArea
 *
 * Example walkthrough for [1,8,6,2,5,4,8,3,7]:
 *
 * Initial: left=0, right=8, maxArea=0
 *
 * Iteration 1:
 *   width = 8 - 0 = 8
 *   minHeight = min(1, 7) = 1
 *   currentArea = 8 × 1 = 8
 *   maxArea = max(0, 8) = 8
 *   height[0](1) < height[8](7)? YES → left = 1
 *
 * Iteration 2:
 *   width = 8 - 1 = 7
 *   minHeight = min(8, 7) = 7
 *   currentArea = 7 × 7 = 49  ← Maximum area found!
 *   maxArea = max(8, 49) = 49
 *   height[1](8) < height[8](7)? NO → right = 7
 *
 * Iteration 3:
 *   width = 7 - 1 = 6
 *   minHeight = min(8, 3) = 3
 *   currentArea = 6 × 3 = 18
 *   maxArea = max(49, 18) = 49
 *   height[1](8) < height[7](3)? NO → right = 6
 *
 * ... continue until left >= right ...
 *
 * Final: maxArea = 49 ✓
 *
 * Why Greedy Works:
 * When we're at a state with pointers at left and right:
 * - If height[left] < height[right]:
 *   Moving right inward can NEVER increase area (width decreases, height limited by left)
 *   So we must try left to potentially find a taller bar
 * - If height[right] <= height[left]:
 *   Moving left inward can NEVER increase area (width decreases, height limited by right)
 *   So we must try right to potentially find a taller bar
 *
 * This greedy choice guarantees we won't miss the maximum area.
 *
 * Alternative Approaches:
 *
 * 1. Brute Force:
 *    - Check every pair of lines
 *    - Area = (j - i) × min(height[i], height[j]) for all i, j
 *    Time: O(n²), Space: O(1)
 *    Disadvantage: Too slow for large inputs
 *
 * 2. Two Pointers (Our approach):
 *    - Start with widest container, move inward strategically
 *    Time: O(n), Space: O(1)
 *    Advantage: Optimal, simple logic
 *
 * Gato Style Summary:
 * - One-liner: "Start at both ends of the array, calculate area, move the shorter wall inward"
 * - Analogy: "Like two people standing at opposite ends of a hallway holding water containers.
 *   The shorter person limits how much water you can hold. To potentially hold more water,
 *   the shorter person walks forward, because the taller person walking would only waste space."
 */
