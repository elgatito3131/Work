/**
 * LeetCode 347: Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Explanation: 1 appears 3 times, 2 appears 2 times, 3 appears 1 time.
 * The 2 most frequent elements are 1 and 2.
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 * - k is in the range [1, the number of unique elements in the array]
 * - It is guaranteed that the answer is unique
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        // TODO: Implement solution
        return new int[k];
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        // Test case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = solution.topKFrequent(nums1, k1);
        System.out.println("Test 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println("Expected: [1, 2] (in any order)");
        System.out.println();

        // Test case 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println("Test 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + Arrays.toString(result2));
        System.out.println("Expected: [1]");
        System.out.println();

        // Test case 3
        int[] nums3 = {4, 4, 4, 1, 1, 2};
        int k3 = 2;
        int[] result3 = solution.topKFrequent(nums3, k3);
        System.out.println("Test 3:");
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("Output: " + Arrays.toString(result3));
        System.out.println("Expected: [4, 1] (in any order)");
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(?)
 * -
 *
 * Space Complexity: O(?)
 * -
 *
 * Key Insight:
 *
 *
 * Algorithm:
 *
 *
 * Example walkthrough:
 *
 *
 * Alternative Approaches:
 * 1. Approach name:
 *
 *    Time: O(?), Space: O(?)
 *
 * 2. Another approach:
 *
 *    Time: O(?), Space: O(?)
 */
