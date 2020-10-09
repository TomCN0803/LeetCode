package com.qihoo.stackAndQueue.findMinHeightTrees;

import java.util.*;

public class FindMinHeightTrees {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[][] edges = new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        List<Integer> res = solution.findMinHeightTrees(n, edges);
        System.out.println(res);
    }
}


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new LinkedList<>();
            res.add(0);
            return res;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> degree = new ArrayList<>();
        List<Integer> res = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new LinkedList<>());
            degree.add(0);
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            degree.set(edge[0], degree.get(edge[0]) + 1);
            degree.set(edge[1], degree.get(edge[1]) + 1);
        }

        for (int i = 0; i < degree.size(); i++) {
            if (degree.get(i) == 1) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int qLen = queue.size();
            res = new LinkedList<>();
            for (int i = 0; i < qLen; i++) {
                assert !queue.isEmpty();
                int node = queue.poll();
                res.add(node);
                for (Integer adj : adjList.get(node)) {
                    degree.set(adj, degree.get(adj) - 1);
                    if (degree.get(adj) == 1) queue.offer(adj);
                }
            }
        }
        return res;
    }
}
