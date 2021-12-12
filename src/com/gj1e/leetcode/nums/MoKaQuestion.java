package com.gj1e.leetcode.nums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FenDa
 * 一个数组[1,3,2,4,4,7,1]  输出[3，2，7]
 */
public class MoKaQuestion {
    public static List<Integer> solution(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (!(hashMap.get(nums[i]) > 1)) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,4,4,7,1};
        List<Integer> solution = solution(nums);
        solution.forEach(System.out::println);
    }
}
