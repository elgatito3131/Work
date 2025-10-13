/**
 * LeetCode 347: Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [4,4,4,4,8,8,8,1,1,7], k = 2
 * Output: [4,8]
 * Explanation:
 * - 4 appears 4 times (most frequent)
 * - 8 appears 3 times (second most frequent)
 * - 1 appears 2 times
 * - 7 appears 1 time
 * So the top 2 most frequent are [4,8]
 *
 * Example 2:
 * Input: nums = [5,5,5,2,2,9], k = 1
 * Output: [5]
 * Explanation:
 * - 5 appears 3 times (most frequent)
 * - 2 appears 2 times
 * - 9 appears 1 time
 * So the top 1 most frequent is [5]
 *
 * Example 3:
 * Input: nums = [10,20,30,40], k = 2
 * Output: [10,20] (or any 2 elements - they all appear once)
 * Explanation:
 * - All elements appear exactly 1 time
 * - Any 2 elements can be returned
 *
 * Example 4:
 * Input: nums = [3,3,3,2,2,2,1], k = 2
 * Output: [3,2]
 * Explanation:
 * - 3 appears 3 times (tied for most frequent)
 * - 2 appears 3 times (tied for most frequent)
 * - 1 appears 1 time
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
        // Step 1: Build frequency map
        // Example: [4,4,4,4,8,8,8,1,1,7] -> {4:4, 8:3, 1:2, 7:1}
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            // For each number, increment its count (start at 0 if not present)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // After this loop: frequencyMap = {4=4, 8=3, 1=2, 7=1}

        // Step 2: Convert HashMap entries to a List for sorting
        // We need a List because we can't sort a HashMap directly
        // entryList = [(4,4), (8,3), (1,2), (7,1)]
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        // Step 3: Sort by frequency (descending order)
        // Lambda: (a, b) -> b.getValue() - a.getValue()
        // Compare frequencies: larger frequency comes first
        // After sort: [(4,4), (8,3), (1,2), (7,1)]
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        // Step 4: Extract the top k elements (just the keys, not frequencies)
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // Get the key (number) from the i-th entry
            // i=0: result[0] = 4
            // i=1: result[1] = 8
            result[i] = entryList.get(i).getKey();
        }
        // Final result: [4, 8]
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();

        // Test case 1
        int[] nums1 = {4, 4, 4, 4, 8, 8, 8, 1, 1, 7};
        int k1 = 2;
        int[] result1 = solution.topKFrequent(nums1, k1);
        System.out.println("Test 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + Arrays.toString(result1));
        System.out.println("Expected: [4, 8] (in any order)");
        System.out.println("Explanation: 4 appears 4 times, 8 appears 3 times");
        System.out.println();

        // Test case 2
        int[] nums2 = {5, 5, 5, 2, 2, 9};
        int k2 = 1;
        int[] result2 = solution.topKFrequent(nums2, k2);
        System.out.println("Test 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + Arrays.toString(result2));
        System.out.println("Expected: [5]");
        System.out.println("Explanation: 5 appears 3 times (most frequent)");
        System.out.println();

        // Test case 3
        int[] nums3 = {10, 20, 30, 40};
        int k3 = 2;
        int[] result3 = solution.topKFrequent(nums3, k3);
        System.out.println("Test 3:");
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("Output: " + Arrays.toString(result3));
        System.out.println("Expected: Any 2 elements (all appear once)");
        System.out.println();

        // Test case 4
        int[] nums4 = {3, 3, 3, 2, 2, 2, 1};
        int k4 = 2;
        int[] result4 = solution.topKFrequent(nums4, k4);
        System.out.println("Test 4:");
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", k = " + k4);
        System.out.println("Output: " + Arrays.toString(result4));
        System.out.println("Expected: [3, 2] (in any order)");
        System.out.println("Explanation: Both 3 and 2 appear 3 times (tied for most)");
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(n + m log m) where n = nums.length, m = number of unique elements
 * - Building frequency map: O(n) - iterate through all n elements once
 * - Converting map to list: O(m) - m unique elements
 * - Sorting the list: O(m log m) - sorting m entries
 * - Extracting top k: O(k) - but k <= m, so negligible
 * - Overall: O(n + m log m)
 * - Note: This doesn't meet the O(n) follow-up requirement, but it's a valid solution
 *
 * Space Complexity: O(m) where m = number of unique elements
 * - HashMap stores at most m unique elements: O(m)
 * - List stores m entries: O(m)
 * - Result array: O(k), but k <= m
 * - Overall: O(m)
 *
 * Key Insight:
 * We can't directly sort a HashMap, but we can convert it to a List of entries
 * and sort that list by the frequency values. This allows us to identify the
 * k most frequent elements by simply taking the first k entries after sorting.
 *
 * Algorithm:
 * 1. Build the frequency HashMap
 *    - Traverse the input array
 *    - For each element, increment its count in the map
 *    - Result: map where key = element, value = frequency
 *
 * 2. Convert the HashMap entries into a List
 *    - Create ArrayList from map.entrySet()
 *    - This gives us a sortable collection of (element, frequency) pairs
 *
 * 3. Sort the List by frequency (descending order)
 *    - Use a comparator: (a, b) -> b.getValue() - a.getValue()
 *    - This puts highest frequency elements first
 *
 * 4. Extract the top k elements from the sorted List
 *    - Loop through first k entries
 *    - Extract just the keys (elements), not frequencies
 *    - Store in result array
 *
 * Example walkthrough with [4,4,4,4,8,8,8,1,1,7], k=2:
 *
 * Step 1: Build frequency map
 *   - Process 4: {4=1}
 *   - Process 4: {4=2}
 *   - Process 4: {4=3}
 *   - Process 4: {4=4}
 *   - Process 8: {4=4, 8=1}
 *   - Process 8: {4=4, 8=2}
 *   - Process 8: {4=4, 8=3}
 *   - Process 1: {4=4, 8=3, 1=1}
 *   - Process 1: {4=4, 8=3, 1=2}
 *   - Process 7: {4=4, 8=3, 1=2, 7=1}
 *
 * Step 2: Convert to list
 *   entryList = [(4,4), (8,3), (1,2), (7,1)]
 *
 * Step 3: Sort by frequency (descending)
 *   Before: [(4,4), (8,3), (1,2), (7,1)]
 *   After:  [(4,4), (8,3), (1,2), (7,1)]  (already sorted in this case)
 *
 * Step 4: Extract top k=2 elements
 *   i=0: result[0] = entryList.get(0).getKey() = 4
 *   i=1: result[1] = entryList.get(1).getKey() = 8
 *   Final result = [4, 8]
 *
 * Alternative Approaches:
 *
 * 1. Min Heap (Priority Queue) - O(n log k) time:
 *    - Build frequency map: O(n)
 *    - Use a min heap of size k
 *    - For each unique element, add to heap (if heap size < k or current freq > min)
 *    - Keep heap size at most k by removing minimum
 *    - Result: heap contains k elements with highest frequencies
 *    Time: O(n + m log k), Space: O(m + k)
 *    Better when k is small compared to m
 *
 * 2. Bucket Sort - O(n) time (meets follow-up!):
 *    - Build frequency map: O(n)
 *    - Create buckets array where index = frequency
 *    - buckets[i] contains all elements with frequency i
 *    - Iterate from highest frequency bucket to lowest
 *    - Collect k elements
 *    Time: O(n), Space: O(n)
 *    Example: [1,1,1,2,2,3]
 *    frequencyMap = {1:3, 2:2, 3:1}
 *    buckets[1] = [3], buckets[2] = [2], buckets[3] = [1]
 *    For k=2, collect from buckets[3] and buckets[2]: [1, 2]
 *
 * 3. QuickSelect with Custom Partition - O(n) average time:
 *    - Build frequency map: O(n)
 *    - Use QuickSelect to find kth largest element by frequency
 *    - Partition around that element
 *    Time: O(n) average, O(n²) worst case, Space: O(m)
 *    More complex to implement but achieves O(n) average time
 */
