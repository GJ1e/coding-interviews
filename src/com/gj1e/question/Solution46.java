package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/12
 * @Time 15:33
 * 面试题46：把数字翻译成字符串
 *
 * 题目：
 *      给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻译成"b"，……，11翻译成"l"，……，25翻译成"z"。
 *      一个数字可能有多个翻译。例如12258有5种不同的翻译，它们分别"bccfi", "bwfi", "bczi", "mcfi" 和"mzi" 。
 *      请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 *
 * 思路：
 *      看到题目，很容易想到使用递归：用f(i)来表示从第i位开始的不同翻译数目，可以得到有：f(i)=f(i+1)+g(i,i+1)*f(i+2)。
 *      i和i+1位数字拼起来在10~25范围内时g(i,i+1)的值为1，否则为0。但是存在重复的子问题，所以递归并非最佳方法，
 *      我们从数字的末尾开始计算f(i)，自下而上解决问题，就可以消除重复的子问题了。
 *      先算f(len-1)，f(len-2)，再根据公式f(i)=f(i+1)+g(i,i+1)*f(i+2)往前逐步推导到f(0)，这就是最终要求的结果
 */
public class Solution46 {

    public int getTranslationCount(int number) {
        if (number < 0)
            return 0;
        String sNumber = String.valueOf(number);
        int[] count = new int[sNumber.length()];

        for (int i = sNumber.length()-1; i >= 0; i--) {
            if (i==sNumber.length()-1){
                count[i] = 1;
            }else {
                count[i] = count[i+1];
                if (canBeTrans(sNumber,i)){
                    if (i == sNumber.length()-2)
                        count[i] = count[i] + 1;
                    else
                        count[i] = count[i] + count[i+2];
                }
            }
        }
        return count[0];
    }

    private boolean canBeTrans(String sNumber, int i) {
        int a=sNumber.charAt(i)-'0';
        int b=sNumber.charAt(i+1)-'0';
        int convert=a*10+b;
        if(convert>=10 && convert<=25)
            return true;
        return false;
    }
}
