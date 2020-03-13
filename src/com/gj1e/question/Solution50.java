package com.gj1e.question;

import java.util.HashMap;

/**
 * @Author GJ1e
 * @Create 2020/3/13
 * @Time 10:52
 * 面试题50：字符串中第一个只出现一次的字符
 *
 * 题目：
 *      在一个字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class Solution50 {
    public int firstNotRepeatingChar(String str) {
        if(str == null || str.length()<=0)
            return -1;
        HashMap<Character,Integer> map = new HashMap<>();
        //构造hash映射关系
        for(int i=0; i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                //key存在则对应的Value+1
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }else{
                //key不存在则对应的value=1
                map.put(str.charAt(i),1);
            }
        }
        for(int i=0;i<str.length();i++){
            //找出第一个value为1的key，直接返回在字符串中的位置
            if(map.get(str.charAt(i))==1)
                return i;
        }
        //没找到就返回-1
        return -1;
    }
}
