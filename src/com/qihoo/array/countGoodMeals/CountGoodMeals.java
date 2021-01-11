package com.qihoo.array.countGoodMeals;

import java.util.HashMap;
import java.util.Map;

public class CountGoodMeals {
    public static void main(String[] args) {
        int[] deliciousness = {1, 3, 5, 7, 9};
        Solution solution = new Solution();
        int ans = solution.countPairs(deliciousness);
        System.out.println(ans);
    }
}

class Solution {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int mod = 1000000007;
        int answer = 0;
        for (int num : deliciousness) {
            int powerOfTwo = 1;
            // 为什么是21？ 因为数字最大为2^20, 2^20 + 2^20 = 2^21为可能的最大值，不可能再大啦！
            for (int i = 0; i <= 21; i++) {
                if (powerOfTwo >= num && map.containsKey(powerOfTwo - num)) {
                    answer += map.get(powerOfTwo - num);
                    answer %= mod;
                }
                powerOfTwo *= 2;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return answer;
    }
}
