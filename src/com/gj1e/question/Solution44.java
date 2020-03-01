package com.gj1e.question;


/**
 * @Author GJ1e
 * @Create 2019/10/14
 * @Time 21:23
 *
 * 剑指offer
 * 面试题44：数字序列中某一位的数字
 *
 * 问题：
 *      数字以0123456789101112131415···的格式序列化到一个字符序列中。
 *      在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 *      请写一个函数，求任意第N位对应的数字。
 *
 * 思路：
 *      根据规律可以得出，序列化的前10位是0~9这10个只有1位的数字。
 *      接下来的10~99这90个两位数，总共180位。后面的100~999这900个三位数，总共2700位。
 *      下面依次类推。。。
 *      例如，我们要查找第99位数字。首先99>10,肯定不在前10位中，所以从后面紧跟着的序列中
 *      寻找第89位(99-10=89)。接下来的两位数总共有180位，所以第89位肯定是某个两位数中的一位。
 *      由于89=44*2+1。这也就意味着第89位是从10开始的第44个数字即54的第一位，也就是4。
 *
 */
public class Solution44 {

    public int digitAtIndex (int n){
        if (n<0) return -1;

        int digits = 1;

        while (true){
            int numbers = countOfIntegers(digits);
            if (n<(numbers*digits))
                return digitAtIndex(n,digits);
            n -= digits*numbers;
            digits++;
        }

    }

    //这个函数用来得到M位的数字有多少个，输入2则返回两位数(10~99)的个数90；输入3，则返回三位数（100~999)的个数900。
    private int countOfIntegers(int m){
        if(m==1)
            return 10;
        return 9*(int)Math.pow(10,m-1);
    }

    //这个用来求M位数字的第一个数字。比如，第一个一位数是0，第一个两位数是10，第一个三位数是100
    private int beginNumber(int digits){
        if (digits == 1)
            return 0;
        return (int)Math.pow(10,digits-1);
    }

    //用来找出位于M位数之中的呢一位数字。
    private int digitAtIndex(int index,int digits){

        int number = beginNumber(digits) + index/digits;
        int indexFromRight = digits - index%digits;

        for (int i = 1; i < indexFromRight; i++) {
            number /=10;
        }
        return number%10;
    }
}
