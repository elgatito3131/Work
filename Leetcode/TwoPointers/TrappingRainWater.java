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
 * 
 *              |-|
 *      |-|     | |-| |-|
 * _|-|_| |-|_|-| | |-| |-|
 *
 * [0,1,0,2,1,0,1,3,2,1,2,1]
 *              |-|
 *      |-|x x x| |-|x|-|
 * _|-|x| |-|x|-| | |-| |-|
 * 0 1 2 3 4 5 6 7 8 9 10 11
 
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
 * The terrain looks like:
 *           |-|
 * |-|       | |
 * | |   |-| | |
 * | |-| | |-| |
 * | | |_| | | |
 * 
 * After raining, water (represented by ~) fills:
 *           |-|
 * |-|x x x x| |
 * | |x x|-|x| |
 * | |-|x| |-| |
 * | | |x| | | |
 * Water trapped = 9 units
 *
 * Constraints:
 * - n == height.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= height[i] <= 10^5
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        // Two Pointers Approach
        // Initialize pointers and tracking variables
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        // Main loop: process until pointers meet
        while (left <= right) {
            // Compare leftMax and rightMax to determine which side is the limiting factor
            if (leftMax <= rightMax) {
                // Left side is limiting, process from left
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
                left++;
            } else {
                // Right side is limiting, process from right
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
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

/*
 * NOTES:
 *
 * Time Complexity: O(n)
 * - Single pass through the array with two pointers
 * - Each element is visited exactly once
 *
 * Space Complexity: O(1)
 * - Only using a constant amount of extra space (pointers, variables)
 * - No additional data structures needed
 *
 * Key Insight:
 * At any position, water trapped = min(leftMax, rightMax) - height[current]
 * By comparing leftMax and rightMax, we can determine the limiting factor:
 * - If leftMax <= rightMax: leftMax is the bottleneck, so we can safely calculate water at left position
 * - If rightMax < leftMax: rightMax is the bottleneck, so we can safely calculate water at right position
 * This allows us to process one side at a time without fully exploring both sides first.
 *
 * Algorithm (Two Pointers Greedy):
 * 1. Initialize two pointers at opposite ends: left = 0, right = n-1
 * 2. Track the maximum height seen from each side: leftMax, rightMax
 * 3. While left <= right:
 *    a. If leftMax <= rightMax:
 *       - The left side is the limiting factor
 *       - Update leftMax if current bar is taller
 *       - Water trapped at left = leftMax - height[left]
 *       - Move left pointer forward (left++)
 *    b. Else (rightMax < leftMax):
 *       - The right side is the limiting factor
 *       - Update rightMax if current bar is taller
 *       - Water trapped at right = rightMax - height[right]
 *       - Move right pointer backward (right--)
 * 4. Return total water accumulated
 *
 * Example walkthrough for [0,1,0,2,1,0,1,3,2,1,2,1]:
 *
 * Initial: left=0, right=11, leftMax=0, rightMax=0, water=0
 *
 * Iteration 1: leftMax(0) <= rightMax(0)? YES, process left
 *   - leftMax = max(0, 0) = 0
 *   - water += 0 - 0 = 0
 *   - left = 1, water = 0
 *
 * Iteration 2: leftMax(0) <= rightMax(0)? YES, process left
 *   - leftMax = max(0, 1) = 1
 *   - water += 1 - 1 = 0
 *   - left = 2, water = 0
 *
 * Iteration 3: leftMax(1) <= rightMax(0)? NO, process right
 *   - rightMax = max(0, 1) = 1
 *   - water += 1 - 1 = 0
 *   - right = 10, water = 0
 *
 * Iteration 4: leftMax(1) <= rightMax(1)? YES, process left
 *   - leftMax = max(1, 0) = 1
 *   - water += 1 - 0 = 1  ← First water trapped at index 2!
 *   - left = 3, water = 1
 *
 * ... continue until left > right ...
 *
 * Final: water = 6 ✓
 *
 * Alternative Approaches:
 *
 * 1. Precomputed Arrays (Two Pass):
 *    - Create leftMax[i] = max height from 0 to i
 *    - Create rightMax[i] = max height from i to n-1
 *    - For each position: water += min(leftMax[i], rightMax[i]) - height[i]
 *    Time: O(n), Space: O(n)
 *    Advantage: Easier to understand, more intuitive
 *    Disadvantage: Uses O(n) extra space
 *
 * 2. Stack-based approach:
 *    - Use a stack to maintain indices of bars in decreasing order
 *    - When we find a taller bar, calculate water between popped bars
 *    Time: O(n), Space: O(n)
 *    Advantage: Also efficient, different algorithm
 *    Disadvantage: More complex logic, harder to follow
 *
 * 3. Brute Force:
 *    - For each bar, find max height to left and right
 *    - Water at position = min(leftMax, rightMax) - height
 *    Time: O(n²), Space: O(1)
 *    Disadvantage: Very slow for large inputs
 *
 * Why Two Pointers Works:
 * The key insight is that we don't need to know both leftMax and rightMax at every position.
 * We only need to know the SMALLER one, because that's the limiting factor.
 * By moving the pointer with the smaller max value, we guarantee we can calculate water correctly.
 * This is a greedy approach that works because of the nature of the problem.
 *
 * Gato Style Summary:
 * - One-liner: "Start from both ends, track the taller wall you've seen, move the shorter side inward"
 * - Analogy: "Like two people walking toward each other from opposite ends of a valley,
 *   always moving the person at the lower wall forward, because the lower wall determines how much water fills"
 */
