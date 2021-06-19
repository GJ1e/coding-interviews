package com.gj1e.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GJ1e
 * 1. 打印一个字符串的全排列
 * 2. 打印一个字符串的全排列，并过滤掉重复的排列
 */
public class PrintAllPermutations {
    public List<String> solution1(String s) {
        char[] str = s.toCharArray();
        List<String> res = new ArrayList<>();
        process1(str,0,res);
        return res;
    }

    private void process1(char[] str, int index, List<String> res) {
        if (index == str.length) {
            res.add(String.valueOf(str));
            return;
        }
        for (int i = index; i < str.length; i++) {
            swap(str,index,i);
            process1(str, index+1, res);
            //恢复现场，不然回不到起点，无法进行下一个分支的递归。
            swap(str,index,i);
        }
    }

    public List<String> solution2(String s) {
        char[] str = s.toCharArray();
        List<String> res = new ArrayList<>();
        process2(str, 0, res);
        return res;
    }

    private void process2(char[] str, int index, List<String> res) {
        if (index == str.length) {
            res.add(String.valueOf(str));
            return;
        }
        //分支限界，布尔数组，将字符所在位置相同的递归提前中断。
        //若是，数组不能完全表示，就用哈希表代替。
        boolean[] flag = new boolean[26];
        for (int i = index; i < str.length; i++) {
            if (!flag[str[i] - 'a']) {
                flag[str[i] - 'a'] = true;
                swap(str,index,i);
                process2(str, index+1, res);
                //恢复现场，不然回不到起点，无法进行下一个分支的递归。
                swap(str,index,i);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
