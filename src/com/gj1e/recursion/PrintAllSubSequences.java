package com.gj1e.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author GJ1e
 * 1. 打印字符串的所有子序列
 * 2. 打印字符串的所有子序列,要求过滤掉重复的字面值的子序列
 */
public class PrintAllSubSequences {
    public List<String> solution1(String s) {
        char[] str = s.toCharArray();
        List<String> res = new ArrayList<>();
        process(str,0,res,"");
        return res;
    }

    private void process(char[] str, int index, List<String> res, String path) {
        if (index == str.length) {
            res.add(path);
            return;
        }
        process(str,index+1,res,path);
        process(str,index+1,res,path+String.valueOf(str[index]));
    }

    public List<String> solution2(String s) {
        char[] str = s.toCharArray();
        HashSet<String> res = new HashSet<>();
        process2(str,0,res,"");
        return new ArrayList<>(res);
    }

    private void process2(char[] str, int index, HashSet<String> res, String path) {
        if (index == str.length) {
            res.add(path);
            return;
        }
        process2(str, index + 1, res, path);
        process2(str,index+1,res,path+String.valueOf(str[index]));
    }
}
