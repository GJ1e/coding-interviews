package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/11/1
 * @Time 16:57
 *
 * 面试题56：数组中数字出现的次数
 *
 * 题目：
 *      一个整型数组里除2个数字之外，其他数字都出现了2次。请写程序找出这两个只出现一次的数字。
 *      要求时间复杂度O（n），空间复杂度O（1）。
 *
 * 思路：
 *      一个数与本身异或等于0，一个数和0异或等于自己。
 *      把数组中的数字进行两两异或，出现两次的数字肯定都会被抵消，那么最后的异或的结果就是两个只出现一次的数字异或的结果。
 *      数字不一样，异或结果肯定不是0，也就是说在这个结果的二进制中只少有一位是数字1，然后找到第一个为1的位置，记录下来。
 *      例如这个位置是第2位，那么就把数组中的所有数组按这个规则来区分，二进制下第二位为1的分一组，不为1的分一组，这样相同的
 *      数字肯定就分在了一组，然后按组进行异或，这样就能找出来两个只出现一次的数字了。
 */
public class Solution56 {

    public void FindNumsAppearOnce(int [] array, int num1[], int num2[]) {
        if (array == null || array.length <= 0)
            return;
        int myXor = 0;
        int flag = 1;   //二进制下按第几位为1分组的标志。
        for (int i = 0; i < array.length; i++) {
            myXor ^= array[i];
        }
        while ((myXor & flag) == 0)
            flag <<= 1;

        for (int i = 0; i < array.length; i++){
            if ((flag & array[i])==0)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }
}
