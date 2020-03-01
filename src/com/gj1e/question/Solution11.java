package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/26
 * @Time 19:49
 *
 * 问题：
 *      把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *      输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *      例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 * 思路：
 *      二分查找算法的思路来解。
 *      因为数组是非递减(注意不是严格递增，会出现：2，2，2，2，1，2这样的)且排序的数组。
 *      mid = low +(high-low)/2
 *      有三种情况：
 *      第一种：array[mid] > array[high],这种类似于{3，4，5，1，2}最小的数字在mid的右边。
 *          所以：low = mid+1
 *      第二种：array[mid] < array[high],这种类似于{1,1,1,3,4}最小的数字有可能就是mid或者在mid的左边。
 *          所以：high = mid
 *      第三种：array[mid] == array[high],这种类似于{1,0,1,1,1}或{1，1，1，0，1}这时最小的数字不好判断，只能一个一个试。
 *          所以：high = high-1；
 *
 */
public class Solution11 {
    public int minNumberInRotateArray(int [] array){
        if (array==null || array.length <= 0)
            return -1;

        int low = 0;
        int high = array.length-1;

        while (low < high){
            int mid = low +(high-low)/2;
            if (array[mid] > array[high])
                low = mid+1;
            else if (array[mid] < array[high])
                high = mid;     //注意：当集合中只剩下2个元素时，例如{4，6}，mid指向的是第一个元素。
            else
                high -= 1;
        }

        return array[low];
    }
}
