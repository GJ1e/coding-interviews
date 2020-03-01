package com.gj1e.question;


/**
 * @Author GJ1e
 * @Create 2019/10/28
 * @Time 20:01
 *
 * 面试题53的扩展：0~n-1中缺失的数字
 *
 * 题目：
 *      一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。
 *      在范围0~n-1的内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 思路：
 *              递增排序，数字有范围且唯一。所以开始时，数字和下标都是对应的，
 *              例如数组{0，1，2，3，5，6，7}，数组长度为7，n为8，数字范围0~7，
 *              0对应下标0，1对应下标1···数字4不在数组中，所以5对应了下标4，6对应了下标5···
 *              也就是如果M没在数组中，那么M+1对应下标M，M+2对应下标M+1···以此类推。
 *
 *              可以用二分查找算法，如果中间下标的元素和下标值相等，那么下一轮查找只需要查找右半边。
 *
 *              如果中间元素的值和下标不等，并且它前面的一个元素和它的下标值相等，
 *              那么中间这个元素就是数组中第一个和下标值不一样的元素，它的下标就是不存在数组中的数字。
 *
 *              如果中间元素的值和下标不等，并且它前面的一个元素和它的下标值也不相等，
 *              那么下一轮查找的范围就是左半边。
 */
public class Solution53_1 {
//    public static void main(String[] args) {
//        Sloution53_1 test = new Sloution53_1();
//        int[] a1 = new int[]{1,2,3,4,5,6,7}; //缺失的数字在开头，缺失数字为0
//        int[] a2 = new int[]{0,1,2,3,5,6,7}; //缺失的数字在中间，缺失数字为4
//        int[] a3 = new int[]{0,1,2,3,4,5,7}; //缺失的数字在末尾，缺失数字为6
//        int[] a4 = new int[]{0,1,2,3,4,5,6}; //不缺数字，返回值为-1
//        int[] a5 = new int[]{0}; //数组只有一个数字0，不缺数字，返回值为-1
//        System.out.println(test.getMissingNumber(a1));
//        System.out.println(test.getMissingNumber(a2));
//        System.out.println(test.getMissingNumber(a3));
//        System.out.println(test.getMissingNumber(a4));
//        System.out.println(test.getMissingNumber(a5));
//    }

    //二分查找的方法
    //-1代表数组中不缺数字，-2代表非法数组。
    public int getMissingNumber(int[] nums){
        if (nums==null || nums.length<=0)
            return -2;

        int low = 0;
        int high = nums.length-1;

        while (low<=high){
            int mid = low+(high-low)/2;

            if (nums[mid] != mid){
                if (mid==0 || nums[mid-1] == mid-1)
                    return mid;
                else
                    high = mid - 1;

            }else
                low = mid + 1;
        }

        return -1;
    }
}
