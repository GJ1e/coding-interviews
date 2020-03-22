package com.gj1e.question;

import java.util.LinkedList;

/**
 * @Author GJ1e
 * @Create 2020/3/22
 * @Time 11:26
 * 面试题62：圆圈中最后剩下的数字
 *
 * 题目：
 *      0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *      例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 思路：
 *      约瑟夫环问题
 *      用一个链表来模拟即可。
 */
public class Solution62 {

    public int lastRemaining(int n, int m) {
        if (n==0 || m==0)
            return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size()>1){
            if (i != m-1){
                list.addLast(list.peekFirst());
                list.pollFirst();
                i++;
            }else {
                list.remove(0);
                i=0;
            }
        }
        return list.peekFirst();
    }
}
