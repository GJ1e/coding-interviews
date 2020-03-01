package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/11/19
 * @Time 20:44
 *
 * 面试题17：打印从1到最大的N位数
 *
 * 题目：
 *      输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印1，2，3一直到最大的3位数999.
 *
 * 思路：
 *      大数问题，注意溢出，用字符串来描述数字。
 *      把问题转换成数字排列的解法，n位所有十进制数，其实就是n个从0到9的全排列。
 *      也就是说，我们把数字的每一位都从0到9排列一趟，就得到了所有十进制数。
 *      注意，最后打印时，要把排在数字前面的0过滤掉。
 */
public class Solution17 {

    public void print1ToMaxOfNDigits(int n){
        if (n<=0)
            return;
        char[] numbers = new char[n+1];
        numbers[n] = '\0';
        for (int i = 0; i < 10; i++) {
            numbers[0] = (char)(i+'0');
            print1ToMaxOfNDigitsRecursively(numbers,n,0);   //调用递归函数进行数字每一位的全排列
        }
    }

    private void print1ToMaxOfNDigitsRecursively(char[] numbers, int length, int index){
        if (length-1 == index){     //递归结束的条件，就是设置了数字的最后一位。
             printNumber(numbers);  //调用打印函数
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index+1] = (char)(i+'0');
            print1ToMaxOfNDigitsRecursively(numbers, length, index+1);
        }
    }

    private static void printNumber(char[] numbers){
        boolean isBegin0 = true;
        for (int i = 0; i < numbers.length; i++) {
            if (isBegin0 && numbers[i] != '0')     //过滤掉排在数字前面的0
                isBegin0 = false;

            if (!isBegin0)
                System.out.print(numbers[i]);
        }
    }
}
