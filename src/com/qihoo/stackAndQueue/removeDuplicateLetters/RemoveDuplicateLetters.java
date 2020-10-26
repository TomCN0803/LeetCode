package com.qihoo.stackAndQueue.removeDuplicateLetters;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "bcac";
        String ans = solution.removeDuplicateLetters(s);
        System.out.println(ans);
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] inStack = new boolean[26];
        int[] dict = new int[26];
        for (char c : s.toCharArray()) {
            dict[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dict[c - 'a']--;
            if (inStack[c - 'a']) continue;

            while (!stack.isEmpty() && stack.peek() > c) {
                if (dict[stack.peek() - 'a'] >= 1) {
                    inStack[stack.pop() - 'a'] = false;
                } else break;
            }
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
