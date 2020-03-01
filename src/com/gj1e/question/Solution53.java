package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2019/10/27
 * @Time 16:48
 */
public class Solution53 {
//    public static void main(String[] args) {
//        Sloution53 test = new Sloution53();
//        System.out.println(test.getNumbersOfK(new int[]{1,2,3,3,3,3,4,5},0));
//    }
    public int getNumbersOfK(int[] nums, int k){
        if (nums==null || nums.length<=0)
            return -1;

        int first = getFistk(nums,k);
        int last = getLastK(nums,k);
        if (first>-1 && last>-1)
           return last-first+1;

        return 0;
    }

    //获取元素在数组中第一次出现的位置。
    public int getFistk(int[] nums, int k){
        int low = 0;
        int high = nums.length-1;

        while (low<=high){
            int mid = low+(high-low)/2;
            if (nums[mid]==k){
                if ((mid>0 && nums[mid-1] != k) || mid==0)
                    return mid;
                else
                    high = mid-1;
            }else if (nums[mid] > k)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    //获取元素在数组中最后一次出现的位置。
    public int getLastK(int[] nums, int k){
        int low = 0;
        int high = nums.length-1;

        while (low<=high){
            int mid = low+(high-low)/2;
            if (nums[mid]==k){
                if ((mid<high && nums[mid+1]!=k) || mid==high)
                    return mid;
                else
                    low = mid+1;
            } else if (nums[mid]<k)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}
