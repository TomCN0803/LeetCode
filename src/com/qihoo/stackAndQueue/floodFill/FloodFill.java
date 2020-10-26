package com.qihoo.stackAndQueue.floodFill;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};
        int sr = 1, sc = 1;
        int newColor = 2;

        int[][] ans = solution.floodFill(image, sr, sc, newColor);
        System.out.println(Arrays.deepToString(ans));
    }
}

class Solution {
    private final int[][] Dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private int newColor, targetColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) {
            return image;
        }

        this.newColor = newColor;
        this.targetColor = image[sr][sc];
        dfs(image, sr, sc);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc) {
        final int R = image.length;
        final int C = image[0].length;

        if (image[sr][sc] == targetColor) image[sr][sc] = newColor;
        else return;

        for (int[] dir : Dirs) {
            int dr = dir[0], dc = dir[1];
            if (sr + dr >= 0 && sr + dr < R && sc + dc >= 0 && sc + dc < C
                    && image[sr + dr][sc + dc] != newColor) {
                dfs(image, sr + dr, sc + dc);
            }
        }
    }
}
