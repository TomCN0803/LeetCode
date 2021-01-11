package com.qihoo.array.findTheDuplicateNumber;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        Solution solution = new Solution();
        int ans = solution.findDuplicate(nums);
        System.out.println(ans);
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int num : nums) {
            if (visited.get(num) != null) return num;
            visited.put(num, true);
        }
        return -1;
    }
}
