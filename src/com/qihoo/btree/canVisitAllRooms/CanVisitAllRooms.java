package com.qihoo.btree.canVisitAllRooms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanVisitAllRooms {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 3}, {3, 0, 1}, {2}, {0}};
        List<List<Integer>> inputData = new ArrayList<>();
        for (int[] room : arr) {
            List<Integer> temp = new ArrayList<>();
            for (int key : room) {
                temp.add(key);
            }
            inputData.add(temp);
        }
        boolean res = solution.canVisitAllRooms(inputData);
        System.out.println(res);
    }
}

class Solution {
    private boolean[] visited;
    private int visitedNum;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomNum = rooms.size();
        visited = new boolean[roomNum];
        visitedNum = 0;
        dfs(rooms, 0);
        return visitedNum == roomNum;
    }

    private void dfs(List<List<Integer>> rooms, int x) {
        visited[x] = true;
        visitedNum++;
        for (int key : rooms.get(x)) {
            if (!visited[key]) {
                dfs(rooms, key);
            }
        }
    }

    private boolean bfs(List<List<Integer>> rooms) {
        int roomNum = rooms.size();
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[roomNum];
        visitedNum = 0;
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int room = queue.poll();
            visitedNum++;
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }

        return visitedNum == roomNum;
    }
}
