package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/9/11
 * @Time 20:17
 *
 * 剑指offer
 * 面试题5：替换空格
 * 已AC
 * 问题：
 *      请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *      例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路：
 *      剑指offer的思路.就是一个空格变成了%20，也就是说每有一个空格，长度要增加2，
 *      所以首先先计算有多少个空格，这样长度就能增加多少，得到增加后的长度Length。
 *      然后new一个Length长度的字符数组，从尾到头开始复制原来的数组，如果复制过程中，
 *      如果字符不是空格，直接复制，如果字符是空格，那么需要把这个空格变成%20
 *      （这个复制过程就是把新建的数组比如现在到了 K这个位置，然后就是K，K-1，K-2这三个位置依次变成0,2，%这三个字符，
 *      因为是从后往前复制的所以是倒序），重复这个过程就行。
 *
 */
public class Solution05 {


    public String replaceSpace(StringBuffer str){

        String str1 = str.toString(); //判断非法输入
        if (str1.equals(""))
            return str1;

        char[] strArray = str1.toCharArray(); //把字符串转换成字符数组
        int i = 0;
        int lengthSpace = 0; //记录字符串数组中的空格数

        while(i<strArray.length){

            if (strArray[i] == ' ')
                lengthSpace++;
            i++;
        }

        int newStrLength = strArray.length + lengthSpace*2;
        char[] newStr = new char[newStrLength];

        int j = strArray.length-1;
        i = newStr.length-1;

        while(j>=0){

            if(strArray[j] != ' ')
            {
                newStr[i--] = strArray[j--];
            }else{
                newStr[i--] = '0';
                newStr[i--] = '2';
                newStr[i--] = '%';
                j--;
            }
        }
        return new String(newStr);


    }


}
