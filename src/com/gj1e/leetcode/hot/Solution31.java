package com.gj1e.leetcode.hot;

/**
 * @author FenDa
 * 31. 下一个排列
 */
public class Solution31 {
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int fast = nums.length - 2;
        int p1 = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            //从后向前找到第一组相邻生序的两个数
            if (nums[fast] < nums[i]) {
                for (int j = nums.length-1; j >= i; j--) {
                    //记录下升序数组靠左的位置，然后从末尾找第一个比他大的数做交换。
                    if (nums[fast] < nums[j]) {
                        int tmp = nums[j];
                        nums[j] = nums[fast];
                        nums[fast] = tmp;
                        p1 = i;
                        break;
                    }
                }
                break;
            }
            fast--;
        }
        int tail = nums.length-1;
        if (p1 != -1) {
            //有下一个最大值，上面交换完之后的结果就是：从第一个相邻生序数组靠右的数字为边界开始到末尾一定是降序排列的，所以直接翻转为升序；
            for (int i = p1; i < tail; i++) {
                int tmp = nums[i];
                nums[i] = nums[tail];
                nums[tail--] = tmp;
            }
        }else {
            //说明队列已经是降序排列，直接逆序。
            for (int i = 0; i < tail; i++) {
                int tmp = nums[i];
                nums[i] = nums[tail];
                nums[tail--] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
