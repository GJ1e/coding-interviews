package com.gj1e.question;

import java.util.ArrayList;

/**
 * @Author GJ1e
 * @Create 2019/11/1
 * @Time 16:57
 *
 * 面试题57：和为S的数字
 *
 * 题目：
 *      输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得它们的和正好是S。如果有多对数字的和等于S，
 *      则输出任意一对即可。
 *
 * 思路：
 *      用二分查找的思路来解。
 *      定义两个指针，一个指向数组开头，一个指向数组末尾，然后将这两个指针指向的数字进行求和，然后和数字S进行比较。
 *      情况一：两数之和 == S。直接返回两个指针分别指向的数字。
 *      情况二：两数之和 > S。由于题目给出的数组是递增排序的，所以可以把末尾的指针向前移动指向较小的数字，
 *              然后在求和，进行比较。
 *      情况三：两数之和 < S。由于题目给出的数组是递增排序的，所以可以把开头的指针向后移动指向较大的数字，
 *              然后在求和，进行比较。
 *
 *
 */
public class Solution57 {

    public ArrayList<Integer> findNumbersWithSum(int[] nums , int s){
        if (nums == null)
            return null;

        ArrayList<Integer> arrayList = new ArrayList<>();
        int low = 0;
        int high = nums.length-1;

        while (low<=high){
            if (nums[low]+nums[high] == s){
                arrayList.add(nums[low]);
                arrayList.add(nums[high]);
                return arrayList;
            }else if (nums[low]+nums[high] > s)
                high -= 1;
            else
                low += 1;

        }
        return null;
    }
}
