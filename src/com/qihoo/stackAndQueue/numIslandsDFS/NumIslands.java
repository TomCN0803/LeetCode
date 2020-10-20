package com.qihoo.stackAndQueue.numIslandsDFS;

import java.util.HashMap;
import java.util.Map;

public class NumIslands {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int ans = solution.numIslands(grid);
        System.out.println(ans);
    }
}

class Solution {
    private final int[][] Dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private Map<Map.Entry<Integer, Integer>, Boolean> visited;
    private int R, C;

    public int numIslands(char[][] grid) {
        R = grid.length;
        if (R == 0) return 0;
        C = grid[0].length;
        if (C == 0) return 0;
        int num = 0;
        visited = new HashMap<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                visited.put(Map.entry(r, c), false);
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                char curr = grid[r][c];
                if (curr == '1' && !visited.get(Map.entry(r, c))) {
                    dfs(grid, r, c);
                    num++;
                }
            }
        }

        return num;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (grid[r][c] == '0') return;

        for (int[] dir : Dirs) {
            int dr = dir[0], dc = dir[1];
            if (r + dr >= 0 && r + dr < R && c + dc >= 0 && c + dc < C
                    && !visited.get(Map.entry(r + dr, c + dc))) {
                visited.put(Map.entry(r + dr, c + dc), true);
                dfs(grid, r + dr, c + dc);
            }
        }
    }
}
