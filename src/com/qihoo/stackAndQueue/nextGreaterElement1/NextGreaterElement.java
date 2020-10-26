package com.qihoo.stackAndQueue.nextGreaterElement1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums2 = {1, 3, 4, 2};
        int[] nums1 = {4, 1, 2};
        int[] ans = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nextMap = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int prev = stack.pop();
                nextMap.put(nums2[prev], nums2[i]);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int prev = stack.pop();
            nextMap.put(nums2[prev], -1);
        }

        int[] ansArr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ansArr[i] = nextMap.get(nums1[i]);
        }

        return ansArr;
    }
}
