package com.qihoo.stackAndQueue.friendCircles;

public class FriendCircles {
    public static void main(String[] args) {
        int[][] M = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        Solution solution = new Solution();
        int ans = solution.findCircleNum(M);
        System.out.println(ans);
    }
}

class Solution {
    private int N;

    public int findCircleNum(int[][] M) {
        N = M.length;
        if (N == 0) return 0;

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (M[i][i] == 1) {
                dfs(M, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] M, int n) {
        for (int i = 0; i < N; i++) {
            if (M[n][i] == 1 && M[i][i] == 1) {
                M[i][i] = 0;
                dfs(M, i);
            }
        }
    }
}
