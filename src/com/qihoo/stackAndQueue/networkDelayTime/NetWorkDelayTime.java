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
    private Map<Integer, Integer> distMap;
    private Map<Integer, List<int[]>> timesMap;

    public int networkDelayTime(int[][] times, int N, int K) {
        timesMap = new HashMap<>();
        for (int[] edge : times) {
            timesMap.computeIfAbsent(edge[0], k -> new LinkedList<>());
            timesMap.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        for (Integer node : timesMap.keySet()) {
            timesMap.get(node).sort(Comparator.comparingInt(a -> a[0]));
        }

        distMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            distMap.put(i, Integer.MAX_VALUE);
        }
        dfs(K, 0);

        int ans = Integer.MIN_VALUE;
        for (int curr: distMap.values()) {
            if (curr == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, curr);
        }

        return ans;
    }

    private void dfs(int node, int elapse) {
        if (elapse >= distMap.get(node)) return;
        distMap.put(node, elapse);
        if (timesMap.containsKey(node))
            for (int[] edge : timesMap.get(node)) dfs(edge[0], elapse + edge[1]);
    }
}
