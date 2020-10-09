package com.qihoo.stackAndQueue.perfectSquares;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 7168;
        int res = solution.numSquares(n);
        System.out.println(res);
    }
}

class Solution {
    public int numSquares(int n) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        queue.offer(n);
        visited.add(n);
        while (!queue.isEmpty()) {
            result++;
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                assert !queue.isEmpty();
                int curr = queue.poll();
                for (int j = 1; j * j <= curr; j++) {
                    int temp = curr - j * j;
                    if (temp == 0) {
                        return result;
                    } else {
                        if (!visited.contains(temp)) {
                            queue.offer(temp);
                        }
                        visited.add(temp);
                    }
                }
            }
        }

        return result;
    }
}
