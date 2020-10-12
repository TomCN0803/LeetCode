package com.qihoo.stackAndQueue.openTheLock;

import java.util.*;

public class OpenTheLock {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int res = solution.openLock(deadends, target);
        System.out.println(res);
    }
}

class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            int qLen = queue.size();
            for (int i = 0; i < qLen; i++) {
                String curr = queue.poll();
                assert curr != null;
                if (deads.contains(curr)) continue;
                else if (curr.equals(target)) return depth;
                else {
                    List<String> nexts = this.getNexts(curr);
                    for (String next : nexts) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            depth++;
        }

        return -1;
    }

    private List<String> getNexts(String curr) {
        List<String> nexts = new LinkedList<>();
        for (int i = 0; i < curr.length(); i++) {
            char c = (char) ((curr.charAt(i) - '0' + 1) % 10 + '0');
            nexts.add(curr.substring(0, i) + c + curr.substring(i + 1));
        }
        for (int i = 0; i < curr.length(); i++) {
            char c = (char) ((curr.charAt(i) - '0' + 9) % 10 + '0');
            nexts.add(curr.substring(0, i) + c + curr.substring(i + 1));
        }

        return nexts;
    }
}
