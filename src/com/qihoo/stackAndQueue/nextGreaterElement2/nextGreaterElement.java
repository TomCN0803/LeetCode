package com.qihoo.stackAndQueue.nextGreaterElement2;

import java.util.Arrays;
import java.util.Stack;

public class nextGreaterElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 4, 3, 2, 1};
        int[] res = solution.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ansArr = new int[nums.length];
        Arrays.fill(ansArr, -1);

        for (int i = 0; i < 2 * nums.length; i++) {
            int n = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[n]) {
                int prev = stack.pop();
                ansArr[prev] = nums[n];
            }
            stack.push(n);
        }

        return ansArr;
    }
}
