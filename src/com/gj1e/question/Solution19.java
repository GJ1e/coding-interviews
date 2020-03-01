package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/12/1
 * @Time 19:54
 *
 * 面试题19：正则表达式匹配
 *
 * 题目：
 *      请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 *      而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 *      例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 *
 * 思路：
 *      当字符串中的字符和模式中的字符相匹配时，或者当模式中的字符为"."时，字符串和模式串同时向后移动继续匹配。
 *      当模式中的第二个字符是“*”时，一种选择是模式上向后移动两个字符。这相当于*和它前面的字符被忽略了，因为
 *      *可以匹配字符串中的0哥字符。
 *      如果模式中的第一个字符和字符串中的第一个字符相匹配，则字符串向后移动一个字符，而模式上有两种选择
 *      可以在模式上向后移动两个字符，也可以保持模式不变。
 */
public class Solution19 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchRecur(str, pattern, 0, 0);
    }

    private boolean matchRecur(char[] str, char[] pattern, int s, int p) {
        if (s == str.length && p == pattern.length) {
            return true;
        }
        // 模式串比文本串先到末尾，肯定没有匹配成功
        if (p == pattern.length && s < str.length) {
            return false;
        }
        // 第二个字符是*
        // 两种情况，1、模式和文本都没有到结尾
        // 2、或者文本到了结尾而模式还没有到结尾，此时肯定会调用else分支
        if (p < pattern.length-1 && pattern[p + 1] == '*') {
            if ((s < str.length && str[s] == pattern[p]) || (pattern[p] == '.' && s < str.length))
                return matchRecur(str, pattern, s, p + 2) ||
                        matchRecur(str, pattern, s + 1, p + 2) ||
                        matchRecur(str, pattern, s + 1, p);
            else
                return matchRecur(str, pattern, s, p + 2);
        }
        // 第二个字符不是*
        if ((s < str.length && str[s] == pattern[p]) || (pattern[p] == '.' && s < str.length)) {
            return matchRecur(str, pattern, s + 1, p + 1);
        }
        return false;
    }

}
