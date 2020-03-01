package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/28
 * @Time 20:02
 *
 * 面试题53的扩展题：数组中数值和下标相等的元素
 *
 * 题目：
 *      假设一个单调递增的的数组里的每个元素都是整数且唯一的。请编程实现一个函数，找出数组中任意一个数值等于其下标的元素。
 *      例如：在数组{-3，-1，1，3，5}中，数字3和它的下标相等。
 *
 * 思路：
 *      方法一：遍历数组中的所有数字，同时和下标进行比较，然后找出和下标相同的数字。
 *      方法二：二分查找算法，数组单调递增且数字唯一，假设数组中某一数字的值为M，下标为i。
 *      第一种情况：M==i，直接返回i
 *      第二种情况：M>i, 由于数组中的所有数字都是单调递增且唯一，所以对于任意的大于0的数字k都有 M+k>i+k，
 *                  位于i+k坐标下的数字都大于它的下标。
 *                  所以M的右半边的数字都是大于数组下标的，可以忽略掉，下次只在左半边进行查找。
 *      第三种情况：M<i，同理对于任意的大于0的数字k都有 M+k<i+k，位于i+k坐标下的数字都小于它的下标。
 *                  所以M的左半边的数字都是小于数组下标的，可以忽略掉，下次只在右半边进行查找。
 *
 */
public class Solution53_2 {
//    public static void main(String[] args) {
//        Sloution53_2 test = new Sloution53_2();
//        int[] a1 = new int[]{-3,-1,1,3,5};  //包含和数组下标相等的值，值为3
//        int[] a2 = new int[]{-3,-1,1,4,5};  //不包含和数组下标相等的值，返回值为-1
//        int[] a3 = new int[]{0,2,3,4,5};  //包含和数组下标相等的值位于数组开头，值为0
//        int[] a4 = new int[]{-3,-1,1,2,4};  //包含和数组下标相等的值位于数组结尾，值为4
//        int[] a5 = new int[]{-3};  //只有一个数字的数组且不包含和数组下标相等的值，返回值为-1
//        int[] a6 = new int[]{0};  //只有一个数字的数组且包含和数组下标相等的值，返回值为0
//        System.out.println(test.getNumberAsIndex(a1));
//        System.out.println(test.getNumberAsIndex(a2));
//        System.out.println(test.getNumberAsIndex(a3));
//        System.out.println(test.getNumberAsIndex(a4));
//        System.out.println(test.getNumberAsIndex(a5));
//        System.out.println(test.getNumberAsIndex(a6));
//
//    }
    public int getNumberAsIndex(int[] nums){
        if (nums == null||nums.length<=0)
            return -1;
        int low = 0;
        int high = nums.length-1;

        while (low <= high){
            int mid = low+(high-low)/2;

            if (nums[mid]==mid)
                return mid;
            else if (nums[mid]>mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
