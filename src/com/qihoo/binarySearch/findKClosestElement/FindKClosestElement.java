package com.qihoo.binarySearch.findKClosestElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        Solution solution = new Solution();
        List<Integer> ans = solution.findClosestElement(arr, k, x);
        System.out.println(Arrays.toString(ans.toArray()));
    }
}

class Solution {
    public List<Integer> findClosestElement(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> a.equals(b) ? 0 : Math.abs(a - x) - Math.abs(b - x)).collect(Collectors.toList());
        ret = ret.subList(0, k);
        Collections.sort(ret);

        return ret;
    }
}
