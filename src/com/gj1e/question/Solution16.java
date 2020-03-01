package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/11/9
 * @Time 21:34
 *
 * 面试题16：数值的整数次方
 *
 * 题目：
 *      实现函数double Power(double base， int exponent)，求base的exponent次方。不得使用库函数，不需要考虑大数问题。
 *
 * 思路：
 *      当指数为负数的时候，先对指数求绝对值，算出次方的结果之后再取倒数。
 *
 *      当base为0，且指数为负数时，返回0.
 */
public class Solution16 {

    public double power(double base, int exponent){
        Double base1 = base;
        if (base1.compareTo(0.0)==0 && exponent<0){
            return 0.0;
        }
        int absExponent = exponent;
        if (exponent < 0)   //指数为负数时，先求指数的绝对值
            absExponent = -exponent;
        double result = powerCore(base, absExponent);   //调用函数，计算次方的结果
        if (exponent < 0)   //指数为负数，对次方结果取倒数
            result = 1.0/result;

        return result;
    }


    private double powerCore(double base, int exponent){
        double result = 1.0;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }
}
