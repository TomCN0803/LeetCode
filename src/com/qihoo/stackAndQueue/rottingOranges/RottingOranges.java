package com.qihoo.stackAndQueue.rottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int res = solution.orangesRotting(grid);
        System.out.println(res);
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        final int ROW = grid.length;
        final int COL = grid[0].length;
        final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> queue = new LinkedList<>();
        int fresh = 0;
        int step = -1;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                int cell = i * COL + j;
                switch (grid[i][j]) {
                    case 1:
                        fresh++;
                        break;
                    case 2:
                        queue.offer(cell);
                        break;
                    default:
                }
            }
        }

        while (!queue.isEmpty()) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                assert queue.peek() != null;
                int curr = queue.poll();
                int row = curr / COL, col = curr % COL;
                for (int[] dir : DIR) {
                    if (((row + dir[0]) >= 0) && ((row + dir[0]) < ROW)
                            && ((col + dir[1]) >= 0) && ((col + dir[1]) < COL)
                            && (grid[row + dir[0]][col + dir[1]] == 1)) {
                        grid[row + dir[0]][col + dir[1]] = 2;
                        queue.offer((row + dir[0]) * COL + col + dir[1]);
                        fresh--;
                    }
                }
            }
            step++;
        }

        return fresh == 0 ? (step == -1 ? 0 : step) : -1;
    }
}
