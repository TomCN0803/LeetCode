package com.qihoo.stackAndQueue.validParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "[{]";
        boolean res = solution.isValid(s);
        System.out.println(res);
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('(', ')');
        parenthesesMap.put('[', ']');
        parenthesesMap.put('{', '}');

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(', '[', '{' -> stack.push(c);
                case ')', ']', '}' -> {
                    if (stack.isEmpty()) return false;
                    char temp = stack.pop();
                    if (parenthesesMap.get(temp) != c) return false;
                }
                default -> {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
