/**
 * LeetCode 167: Two Sum II - Input Array Is Sorted
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Let these two numbers be
 * numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array
 * [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same
 * element twice.
 *
 * Your solution must use only constant extra space.
 *
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 *
 * Example 2:
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
 *
 * Example 3:
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 *
 * Constraints:
 * - 2 <= numbers.length <= 3 * 10^4
 * - -1000 <= numbers[i] <= 1000
 * - numbers is sorted in non-decreasing order
 * - -1000 <= target <= 1000
 * - The tests are generated such that there is exactly one solution
 */

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        // Two-pointer approach: start from both ends and move inward
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                // Sum is too small, need a bigger number
                left++;
            } else {
                // Sum is too big, need a smaller number
                right--;
            }
        }

        // Should never reach here (problem guarantees a solution exists)
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumII solution = new TwoSumII();

        // Test case 1
        int[] test1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(test1, target1);
        System.out.println("Test 1: numbers = [2,7,11,15], target = " + target1);
        System.out.println("Expected: [1,2], Got: [" + result1[0] + "," + result1[1] + "]");
        System.out.println();

        // Test case 2
        int[] test2 = {2, 3, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(test2, target2);
        System.out.println("Test 2: numbers = [2,3,4], target = " + target2);
        System.out.println("Expected: [1,3], Got: [" + result2[0] + "," + result2[1] + "]");
        System.out.println();

        // Test case 3
        int[] test3 = {-1, 0};
        int target3 = -1;
        int[] result3 = solution.twoSum(test3, target3);
        System.out.println("Test 3: numbers = [-1,0], target = " + target3);
        System.out.println("Expected: [1,2], Got: [" + result3[0] + "," + result3[1] + "]");
        System.out.println();
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(n)
 * - We traverse the array once with two pointers
 * - Each element is visited at most once
 * - In the worst case, we move left pointer from start to middle and right pointer from end to middle
 *
 * Space Complexity: O(1)
 * - We only use two pointers (left and right) and one integer (sum)
 * - No additional data structures are created
 * - The space used does not grow with input size
 *
 * Key Insight:
 * The array is SORTED, which allows us to use the two-pointer technique.
 * - If sum is too small: move LEFT pointer right (to get a bigger number from the smaller half)
 * - If sum is too big: move RIGHT pointer left (to get a smaller number from the larger half)
 * This is much more efficient than using a HashMap (which would be O(n) space).
 *
 * Why this works:
 * - Since the array is sorted, we know exactly which direction to move based on the sum
 * - Moving left right always increases the sum (next number is bigger or equal)
 * - Moving right left always decreases the sum (previous number is smaller or equal)
 *
 * Algorithm:
 * 1. Initialize two pointers:
 *    - left at the beginning (index 0)
 *    - right at the end (index n-1)
 *
 * 2. Loop while left < right (don't check the same element twice):
 *    a. Calculate sum = numbers[left] + numbers[right]
 *    b. If sum == target → return [left+1, right+1] (1-indexed)
 *    c. If sum < target → left++ (need a bigger sum)
 *    d. If sum > target → right-- (need a smaller sum)
 *
 * 3. Return empty array (should never happen per problem constraints)
 *
 * Example Walkthrough with [2,7,11,15], target = 9:
 *
 * Initial: left=0, right=3
 * Step 1:  sum = 2 + 15 = 17 (too big) → right--
 * Step 2:  left=0, right=2: sum = 2 + 11 = 13 (too big) → right--
 * Step 3:  left=0, right=1: sum = 2 + 7 = 9 (perfect!) ✓
 * Return: [1, 2] (1-indexed)
 *
 * Example Walkthrough with [2,3,4], target = 6:
 *
 * Initial: left=0, right=2
 * Step 1:  sum = 2 + 4 = 6 (perfect!) ✓
 * Return: [1, 3] (1-indexed)
 *
 * Comparison with Alternative Approaches:
 *
 * 1. HashMap Approach (Original Two Sum):
 *    - Store complements in HashMap as we iterate
 *    Time: O(n), Space: O(n)
 *    Pros: Works for unsorted arrays
 *    Cons: Uses extra memory, not optimal for sorted arrays
 *
 * 2. Brute Force:
 *    - Nested loop to check all pairs
 *    Time: O(n²), Space: O(1)
 *    Pros: No extra space
 *    Cons: Much slower, inefficient
 *
 * 3. Two Pointers (Current Solution):
 *    - Use sorted property to guide pointer movement
 *    Time: O(n), Space: O(1)
 *    Pros: Optimal time and space complexity
 *    Cons: Only works for sorted arrays
 *
 * Why Two Pointers is BEST here:
 * - The array is guaranteed to be sorted (key advantage!)
 * - O(1) space (constant extra space) - requirement of the problem
 * - O(n) time - best possible for this problem
 * - Simple and elegant logic
 */
