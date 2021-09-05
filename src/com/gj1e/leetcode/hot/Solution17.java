package com.gj1e.leetcode.hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author FenDa
 * 17. 电话号码的字母组合
 */
public class Solution17 {
    private final Map<Integer, String> hashMap = new HashMap<Integer, String>() {{
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() <= 0) {
            return new ArrayList<>();
        }
        process(digits, new StringBuilder(), 0);
        return res;

    }

    List<String> res = new ArrayList<>();
    private void process(String digits, StringBuilder sb, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String mapValue = hashMap.get(digits.charAt(index) - '0');
        for (int i = 0; i < mapValue.length(); i++) {
            sb.append(mapValue.charAt(i));
            process(digits, sb, index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
