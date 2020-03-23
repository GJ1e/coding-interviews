package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/23
 * @Time 10:36
 *
 * 面试题63：股票的最大利润
 *
 * 题目：
 *      假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *      例如一只股票在某些时间节点的价格为{9，11，8，5，7，12，16，14}.如果我们能在价格为5的时候买入，并在价格为16的时候卖出，则能收货最大的利润11.
 * 思路：
 *      遍历数组记录最低的价格，然后枚举每天的利润，然后选出一个最大值。就是最大利润。
 */
public class Solution63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0)
            return 0;
        int res = 0;    //最大利润
        for (int i = 1, minV = prices[0]; i < prices.length; i++) {
            res = Math.max(res , prices[i] - minV); //如果我今天要买股票，所得的利润大于之前的，就替换一下。
            minV = Math.min(minV , prices[i]);  //记录数组中的最低价格
        }
        return res;
    }
}
