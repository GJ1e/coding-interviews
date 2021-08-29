package com.gj1e.leetcode.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FenDa
 * 3. 无重复字符的最长子串
 * tip:滑动窗口
 */
public class Solution03 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int n = s.length(),ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char a = s.charAt(end);
            if (map.containsKey(a)) {
                start = Math.max(map.get(a), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(a, end + 1);
        }
        return ans;
    }

}
