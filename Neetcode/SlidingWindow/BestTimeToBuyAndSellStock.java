/**
 * LeetCode #121 - Best Time to Buy and Sell Stock
 * Difficulty: Easy
 * Pattern: Sliding Window
 * 
 * Problem:
 * You are given an array prices where prices[i] is the price of a stock on day
 * i.
 * Maximize profit by choosing a single day to buy and a different day in the
 * future to sell.
 * Return the maximum profit, or 0 if no profit is possible.
 * 
 * Examples:
 * Input: [7, 1, 5, 3, 6, 4] → Output: 5 (buy at 1, sell at 6)
 * Input: [7, 6, 4, 3, 1] → Output: 0 (prices only decrease)
 */

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        // TODO: Implement your solution here
        // Hint: Track minSoFar and maxProfit as you iterate

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > profit) {
                profit = prices[i] - min;
            }
        }

        return profit;
    }

    // Test your solution
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        // Test Case 1: Expected output = 5
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Test 1: " + solution.maxProfit(prices1) + " (expected: 5)");

        // Test Case 2: Expected output = 0
        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println("Test 2: " + solution.maxProfit(prices2) + " (expected: 0)");

        // Test Case 3: Expected output = 1
        int[] prices3 = { 1, 2 };
        System.out.println("Test 3: " + solution.maxProfit(prices3) + " (expected: 1)");

        // Test Case 4: Single element - Expected output = 0
        int[] prices4 = { 5 };
        System.out.println("Test 4: " + solution.maxProfit(prices4) + " (expected: 0)");
    }
}
