package com.gj1e.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author GJ1e
 * @Create 2020/3/6
 * @Time 10:29
 * 面试题38：字符串的排列
 *
 * 题目：
 *      输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 *      则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路：
 *      http://www.cnblogs.com/cxjchen/p/3932949.html  (感谢该文作者！)
 */
public class Solution38 {
    public ArrayList<String> permutation(String str){
        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            permutationCore(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;

    }

    private void permutationCore(char[] chars, int i, ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    permutationCore(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }

    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
