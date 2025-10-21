import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 15: 3Sum
 *
 * Given an integer array nums, return all the unique triplets in the array which gives
 * the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets do not matter.
 *
 * Example 2:
 * Input: nums = [0]
 * Output: []
 * Explanation: The only element is 0, so no triplet exists.
 *
 * Example 3:
 * Input: nums = [-2,0,1,1,2]
 * Output: [[-2,0,2],[-2,1,1]]
 * Explanation:
 * [-2,0,2] sums to 0.
 * [-2,1,1] sums to 0.
 *
 * Constraints:
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort to enable two-pointer technique
        Arrays.sort(nums);

        // Go through each element as our "fixed" first number
        for (int i = 0; i < nums.length - 2; i++) {
            // Stop early: if num is positive, can't make triplet sum to 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate: we already processed this number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Find two numbers that sum to -nums[i] (so triplet sums to 0)
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            // Two pointers moving toward each other
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // Found a valid triplet!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates: while we haven't crossed pointers AND next is same, skip it
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers to find more triplets
                    left++;
                    right--;
                } else if (sum < target) {
                    // Sum too small, move left pointer right for bigger numbers
                    left++;
                } else {
                    // Sum too big, move right pointer left for smaller numbers
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Test case 1
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1: nums = " + Arrays.toString(test1));
        System.out.println("Output: " + solution.threeSum(test1));
        System.out.println("Expected: [[-1,-1,2],[-1,0,1]] (order may vary)");
        System.out.println();

        // Test case 2
        int[] test2 = {0};
        System.out.println("Test 2: nums = " + Arrays.toString(test2));
        System.out.println("Output: " + solution.threeSum(test2));
        System.out.println("Expected: []");
        System.out.println();

        // Test case 3
        int[] test3 = {-2, 0, 1, 1, 2};
        System.out.println("Test 3: nums = " + Arrays.toString(test3));
        System.out.println("Output: " + solution.threeSum(test3));
        System.out.println("Expected: [[-2,0,2],[-2,1,1]] (order may vary)");
        System.out.println();
    }
}

/*
 * NOTES:
 *
 * Time Complexity: O(n²)
 * - Sorting: O(n log n)
 * - Outer loop: O(n) iterations
 * - Inner two-pointer while loop: O(n) per outer iteration
 * - Overall: O(n log n) + O(n) * O(n) = O(n²)
 *
 * Space Complexity: O(1) or O(n)
 * - O(1) if not counting result array
 * - O(n) if counting result array
 * - Sorting may use O(log n) extra space (Java's sort algorithm)
 *
 * Key Insights:
 * 1. Sorting is the key: it enables two-pointer technique
 * 2. After sorting, moving left right INCREASES sum, moving right left DECREASES sum
 * 3. Duplicate handling at three levels:
 *    a) Outer loop: skip duplicate nums[i] (prevents duplicate iterations)
 *    b) Inner loop: skip duplicate nums[left] after finding triplet (prevents duplicate pairs)
 *    c) Inner loop: skip duplicate nums[right] after finding triplet (prevents duplicate pairs)
 * 4. Early termination: if nums[i] > 0, all remaining are positive (sorted array),
 *    so no triplet can sum to 0
 *
 * Algorithm Steps:
 * 1. Sort the array to enable two-pointer technique
 * 2. For each element nums[i]:
 *    a. Skip if positive (early termination optimization)
 *    b. Skip if duplicate of previous element
 *    c. Set target = -nums[i] (what we need from remaining two numbers)
 *    d. Use two pointers (left=i+1, right=end) to find pairs summing to target
 * 3. When sum == target:
 *    - Add triplet to result
 *    - Skip all duplicates at both pointers
 *    - Move both pointers inward
 * 4. If sum < target: move left right (increase sum)
 * 5. If sum > target: move right left (decrease sum)
 *
 * Detailed Example Walkthrough with [-1, 0, 1, 2, -1, -4]:
 * After sorting: [-4, -1, -1, 0, 1, 2]
 *
 * i=0, nums[i]=-4, target=4:
 *   left=1, right=5: sum=-1+2=1 < 4, move left++
 *   left=2, right=5: sum=-1+2=1 < 4, move left++
 *   left=3, right=5: sum=0+2=2 < 4, move left++
 *   left=4, right=5: sum=1+2=3 < 4, move left++
 *   left >= right, exit while loop
 *   Result: [] (no triplets found)
 *
 * i=1, nums[i]=-1, target=1:
 *   left=2, right=5: sum=-1+2=1 == 1 ✓
 *     Add triplet [-1, -1, 2]
 *     Skip duplicates: nums[2]=-1, nums[3]=0 (no dup at left)
 *     Skip duplicates: nums[5]=2, nums[4]=1 (no dup at right)
 *     Move: left=3, right=4
 *   left=3, right=4: sum=0+1=1 == 1 ✓
 *     Add triplet [-1, 0, 1]
 *     No duplicates to skip
 *     Move: left=4, right=3
 *   left > right, exit while loop
 *   Result: [[-1, -1, 2], [-1, 0, 1]]
 *
 * i=2, nums[i]=-1: Skip (duplicate of nums[1]=-1)
 *
 * i=3, nums[i]=0, target=0:
 *   left=4, right=5: sum=1+2=3 > 0, move right--
 *   left >= right, exit while loop
 *   Result: no new triplets
 *
 * Final Result: [[-1, -1, 2], [-1, 0, 1]] ✓
 *
 * Alternative Approaches:
 * 1. HashMap approach (similar to Two Sum II):
 *    - For each pair (i,j), check if -(nums[i]+nums[j]) exists in map
 *    - Time: O(n²), Space: O(n)
 *    - Pros: Can work without sorting
 *    - Cons: More hash operations, harder duplicate handling
 *
 * 2. Brute Force (triple nested loop):
 *    - Check all possible triplets manually
 *    - Time: O(n³), Space: O(1)
 *    - Too slow for n=3000
 *
 * 3. Hash with grouping by first element:
 *    - Use HashMap to group by first number, then HashMap for remaining two
 *    - Time: O(n²), Space: O(n)
 *    - Similar to approach 1, more complex code
 *
 * Why Sorted Two-Pointer is Best:
 * - Clean O(n²) solution
 * - No extra space for hash maps
 * - Duplicate handling is intuitive
 * - Early termination optimization available
 * - Easy to understand and implement
 */
