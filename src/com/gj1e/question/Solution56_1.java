package com.gj1e.question;

import java.util.HashMap;

/**
 * @Author GJ1e
 * @Create 2020/3/19
 * @Time 16:42
 *
 * 面试题56扩展题：数组中唯一只出现一次的数字
 *
 * 题目：
 *      在一个数组中除一个数字只出现一次之外，其它数字都出现了3次，请找出哪个只出现了一次的数字。
 *
 * 思路：
 *      可以继续用56题的异或思路，也可以换一种思路，呢就是构造哈希映射，然后找出出现次数为1的数字。
 */
public class Solution56_1 {

    public int FindNumsAppearOnce(int [] array) {
        if (array == null || array.length<=0)
            throw new RuntimeException("非法数组");
        HashMap<Integer,Integer> map = new HashMap<>(array.length);
        for (int i=0; i<array.length; i++){
            if (map.containsKey(array[i]))
                map.put(array[i],map.get(array[i]) + 1);
            else
                map.put(array[i],1);
        }

        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i])==1)
                return array[i];
        }
        throw new RuntimeException("没找到");
    }
}
