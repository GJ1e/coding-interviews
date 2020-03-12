package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/23
 * @Time 21:01
 */
public class Solution48 {
    public int longestSubstringWithoutDuplication(String str){
        int curLength = 0;
        int maxLength = 0;

        int[] position = new int[26];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int preIndex = position[str.charAt(i) - 'a'];

            if (preIndex < 0 || i-preIndex>curLength)
                curLength++;
            else {
                if (curLength > maxLength)
                    maxLength = curLength;
                curLength = i-preIndex;
            }
            position[str.charAt(i) - 'a'] = i;
        }
        if (curLength > maxLength)
            maxLength = curLength;
        return maxLength;
    }
}
