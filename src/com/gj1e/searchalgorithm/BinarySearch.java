package com.gj1e.searchalgorithm;

/**
 * @Author GJ1e
 * @Create 2019/9/21
 * @Time 20:04
 * “二分查找”
 */
public class BinarySearch {

    //非递归二分查找
    private static int search (int[] nums,int key){
        int low = 0;
        int high = nums.length -1;

        while (low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid]<key) {low = mid+1;}

            else if (nums[mid]>key) {high = mid-1;}

            else
                return mid;
        }


        return low;
    }

    //递归二分查找
    private static int recursion (int[] nums,int start,int end,int key){
        if(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]>key)
                return recursion(nums,start,mid-1,key);
            else if (nums[mid]<key)
                return recursion(nums,mid+1,end,key);
            else return mid;
        }
        return start;
    }
}
