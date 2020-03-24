package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/24
 * @Time 11:42
 * 面试题66：构建乘积数组
 *
 * 题目：
 *      给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 */
public class Solution66 {

    public int[] constructArr(int[] a) {
        if(a == null || a.length <= 0)
            return a;
        int[] res = new int[a.length];

        for(int i = 0, p = 1; i < a.length; i++){
            res[i] = p;
            p *= a[i];
        }
        for(int i = a.length-1, p = 1; i >= 0; i--){
            res[i] *= p;
            p *= a[i];
        }
        return res;
    }
}
