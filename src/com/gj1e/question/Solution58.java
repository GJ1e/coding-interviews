package com.gj1e.question;


/**
 * @Author GJ1e
 * @Create 2020/3/18
 * @Time 10:28
 * 面试题58：反转字符串
 *
 * 题目：
 *      输入一个英文句子，反转句子中单词的顺序，但单词内字符的顺序不变。标点符号和普通字母一样处理。
 */
public class Solution58 {

    public String reverseSentence(String str) {
        if(str == null){ return null;}
        if(str.trim().equals("")){
            return str;
        }
        String string = str;
        String[] strings = string.split(" ");
        StringBuilder sBuilder = new StringBuilder();
        for (int i = strings.length-1 ; i>=0;i--) {
            if(i == 0){ //最后一个单词末尾就不加空格了
                sBuilder.append(strings[i]);
            }else {
                sBuilder.append(strings[i]);
                sBuilder.append(" ");
            }
        }

        String string2 = sBuilder.toString();
        return string2;
    }

}
