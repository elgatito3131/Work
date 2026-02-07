
/**
 * LeetCode #155 - Min Stack
 * Difficulty: Medium
 * Pattern: Stack
 * 
 * Problem:
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time O(1).
 * 
 * Methods:
 * - MinStack() - initializes the stack
 * - void push(int val) - pushes val onto the stack
 * - void pop() - removes the top element
 * - int top() - gets the top element
 * - int getMin() - retrieves the minimum element
 * 
 * Example:
 * push(-2), push(0), push(-3)
 * getMin() → -3
 * pop()
 * top() → 0
 * getMin() → -2
 */

import java.util.ArrayList;
import java.util.Stack;

public class MinStack {

    // TODO: Declare your data structures here
    // Hint: What if you tracked the minimum at each level of the stack?

    ArrayList<Integer> stack;
    ArrayList<Integer> minStack;

    public MinStack() {
        // TODO: Initialize your data structures
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        // TODO: Implement push
        stack.add(val);
        if (minStack.isEmpty()) {
            minStack.add(val);
        } else {
            minStack.add(Math.min(val, minStack.get(minStack.size() - 1)));
        }
    }

    public void pop() {
        // TODO: Implement pop
        stack.remove(stack.size() - 1);
        minStack.remove(minStack.size() - 1);
    }

    public int top() {
        // TODO: Implement top
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        // TODO: Implement getMin in O(1)
        return minStack.get(minStack.size() - 1);
    }

    // Test your solution
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin(): " + minStack.getMin() + " (expected: -3)");

        minStack.pop();
        System.out.println("top(): " + minStack.top() + " (expected: 0)");
        System.out.println("getMin(): " + minStack.getMin() + " (expected: -2)");

        // Additional test
        MinStack ms2 = new MinStack();
        ms2.push(1);
        ms2.push(2);
        ms2.push(0);
        System.out.println("\nTest 2 - getMin(): " + ms2.getMin() + " (expected: 0)");
        ms2.pop();
        System.out.println("Test 2 - getMin(): " + ms2.getMin() + " (expected: 1)");
    }
}
