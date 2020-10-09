package com.qihoo.stackAndQueue.decodeString;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String testInput = "3[a2[c]]";
        String result = solution.decodeString(testInput);
        System.out.println(result);
    }
}

class Solution {
    public String decodeString(String s) {
        Stack<String> resStack = new Stack<>();
        Stack<Integer> multiStack = new Stack<>();
        int multi = 0;
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                multi = 10 * multi + Integer.parseInt(c + "");
            } else if (c == '[') {
                multiStack.push(multi);
                resStack.push(res.toString());
                multi = 0;
                res.delete(0, res.length());
            } else if (c == ']') {
                res = new StringBuilder(resStack.pop() + res.toString().repeat(multiStack.pop()));
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
