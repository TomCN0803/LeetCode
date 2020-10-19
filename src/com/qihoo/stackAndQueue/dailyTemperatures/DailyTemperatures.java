package com.qihoo.stackAndQueue.dailyTemperatures;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solution.dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
}

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }

        return res;
    }
}
