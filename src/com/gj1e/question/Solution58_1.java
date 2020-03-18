package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/18
 * @Time 11:11
 * 面试题58-1：左旋字符串
 *
 * 题目：
 *      第58题的变形，字符串左旋操作就是把字符串前面若干个字符移到字符串的尾部，请定义一个函数实现字符串左旋操作的功能。
 *      例如：输入字符串“abcdefg”和数字2，该函数的返回结果为：“cdefgab”
 */
public class Solution58_1 {
    public String reverseSentence(String str, int num) {
        String subStr = str.substring(0,num);
        StringBuilder sBuilder = new StringBuilder(str.substring(num));
        sBuilder.append(subStr);
        return sBuilder.toString();
    }

}
