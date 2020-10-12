package com.qihoo.stackAndQueue.networkDelayTime;

import java.util.*;

public class NetWorkDelayTime {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}};
        int N = 3, K = 1;
        int res = solution.networkDelayTime(times, N, K);
        System.out.println(res);
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        boolean[] visited = new boolean[N + 1];
        int visitNum = 0;
        int delay = 0;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Map.Entry<Integer, Integer>>> timesMap = new HashMap<>();
        for (int[] time : times) {
            Map.Entry<Integer, Integer> tPair = Map.entry(time[1], time[2]);
            List<Map.Entry<Integer, Integer>> temp = timesMap.getOrDefault(time[0], new LinkedList<>());
            temp.add(tPair);
            timesMap.put(time[0], temp);
        }

        queue.add(K);
        visited[K] = true;
        visitNum++;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Map.Entry<Integer, Integer>> next = timesMap.get(node);
            if (next == null) continue;
            int nodeDelay = 0;
            for (Map.Entry<Integer, Integer> n : next) {
                if (!visited[n.getKey()]) {
                    queue.add(n.getKey());
                    visited[n.getKey()] = true;
                    visitNum++;
                    if (n.getValue() > nodeDelay) nodeDelay = n.getValue();
                }
            }
            delay += nodeDelay;
        }

        return visitNum == N ? delay : -1;
    }
}
