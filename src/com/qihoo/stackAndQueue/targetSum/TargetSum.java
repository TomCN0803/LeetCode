package com.qihoo.stackAndQueue.targetSum;

public class TargetSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int S = 3;
        int ans = solution.findTargetSumWays(nums, S);
        System.out.println(ans);
    }
}

class Solution {
    private final int[] Mul = {-1, 1};
    private int sum;
    private int count;
    private int target;

    public int findTargetSumWays(int[] nums, int S) {
        target = S;
        sum = 0;
        count = 0;
        dfs(nums, 0);

        return count;
    }

    private void dfs(int[] nums, int n) {
        if (n >= nums.length) {
            if (sum == target) count++;
            return;
        }

        for (int mul : Mul) {
            sum += mul * nums[n];
            dfs(nums, n + 1);
            sum -= mul * nums[n];
        }
    }
}
