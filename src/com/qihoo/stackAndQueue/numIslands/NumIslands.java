package com.qihoo.stackAndQueue.numIslands;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int res = solution.numIslands(grid);
        System.out.println(res);
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        final int rows = grid.length;
        final int cols = rows == 0 ? 0 : grid[0].length;
        int result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    result++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(r * cols + c);
                    while (!queue.isEmpty()) {
                        int index = queue.poll();
                        int row = index / cols, col = index % cols;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            queue.offer((row - 1) * cols + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < rows && grid[row + 1][col] == '1') {
                            queue.offer((row + 1) * cols + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            queue.offer(row * cols + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < cols && grid[row][col + 1] == '1') {
                            queue.offer(row * cols + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return result;
    }
}
