/**
 * LeetCode 238: Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 * - 2 <= nums.length <= 10^5
 * - -30 <= nums[i] <= 30
 * - The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * Follow-up: Can you solve the problem in O(1) extra space complexity?
 * (The output array does not count as extra space for space complexity analysis.)
 */

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        // Build left products
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Build right products
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Combine left and right products
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    // Alternative Solution: Optimized O(1) Space
    // public int[] productExceptSelf(int[] nums) {
    //     int n = nums.length;
    //     int[] output = new int[n];
    //     output[0] = 1;
    //
    //     // Calculate left products directly in output array
    //     for (int i = 1; i < n; i++) {
    //         output[i] = output[i - 1] * nums[i - 1];
    //     }
    //
    //     // Calculate right products on-the-fly and multiply with left products
    //     int rightProduct = 1;
    //     for (int i = n - 1; i >= 0; i--) {
    //         output[i] *= rightProduct;
    //         rightProduct *= nums[i];
    //     }
    //
    //     return output;
    // }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.print("Test 1: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(", ");
        }
        System.out.println("] // Expected: [24, 12, 8, 6]");

        // Test case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.print("Test 2: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(", ");
        }
        System.out.println("] // Expected: [0, 0, 9, 0, 0]");
    }
}

/*
 * NOTES:
 *
 * Time Complexity Analysis:
 * - Main solution (two arrays): O(n) time with 3 passes through array
 *   Pass 1: Build left array
 *   Pass 2: Build right array
 *   Pass 3: Combine into result
 *
 * - Alternative solution (optimized): O(n) time with 2 passes
 *   Pass 1: Build left products in output array
 *   Pass 2: Multiply with right products on-the-fly
 *
 * Space Complexity Analysis:
 * - Main solution: O(n) space
 *   Uses left[] and right[] arrays (output doesn't count per problem statement)
 *
 * - Alternative solution: O(1) space
 *   Only uses one variable (rightProduct) for extra space
 *   The output array doesn't count toward space complexity
 *
 * Key Insight:
 * For result[i], we need: (product of all elements left of i) × (product of all elements right of i)
 *
 * Example: nums = [1, 2, 3, 4]
 * left  = [1, 1, 2, 6]   // left[i] = product of all elements before index i
 * right = [24, 12, 4, 1] // right[i] = product of all elements after index i
 * result = [1×24, 1×12, 2×4, 6×1] = [24, 12, 8, 6]
 */
