package com.gj1e.question;

import java.util.ArrayList;

/**
 * @Author GJ1e
 * @Create 2020/3/12
 * @Time 11:48
 * 面试题49：丑数
 *
 * 题目：
 *      把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 *      习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 思路：
 *      https://www.nowcoder.com/profile/835689/codeBookDetail?submissionId=1522621
 */
public class Solution49 {
    public int getUglyNumber(int index) {
        if (index<7)
            return index;
        //p2，p3，p5分别为三个队列的位置标记
        int p2 = 0, p3 = 0, p5 = 0;
        //result是从队列头选出来的最小数
        int result = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(result);
        while (list.size()<index){
            //选出三个队列头最小的数
            result = Math.min(list.get(p2)*2, Math.min(list.get(p3)*3, list.get(p5)*5));
            //这三个if有可能进入一个或者多个，进入多个是三个队列头最小的数有多个的情况
            if (list.get(p2)*2 == result) p2++;
            if (list.get(p3)*3 == result) p3++;
            if (list.get(p5)*5 == result) p5++;
            list.add(result);
        }
        return result;

    }
}
