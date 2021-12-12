package com.gj1e.sortalgorithm;

/**
 * @Author GJ1e
 * @Create 2019/9/21
 * @Time 15:47
 *
 * “冒泡排序”
 * 冒泡排序（Bubble Sort）也是一种简单直观的排序算法。它重复地走访过要排序的数列，一次比较两个元素，
 * 如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 * 冒泡排序还有一种优化算法，就是立一个 flag，当在一趟序列遍历中元素没有发生交换，则证明该序列已经有序。
 * 但这种改进对于提升性能来说并没有什么太大作用。
 *
 * “算法步骤”
 * 1、比较相邻的两个元素，如果前者比后者大，就交换。
 * 2、对每一对相邻的元素做同样的工作，从开始的第一对，到结尾的最后一对。都执行完之后，最后一个元素是最大的。
 * 3、继续针对所有的元素重复以上的步骤，最后一个除外。
 * 4、持续每次对越来越少的元素重复以上的步骤，直到没有任何一对元素需要比较。
 */
public class BubbleSort {

    private static void sort (Comparable[] a){
        if(a==null||a.length<=1) return;
        for (int i = 0;i<a.length-1;i++){
            //设置一个flag标记
            boolean flag = true;
            for (int j = 0;j<a.length-1-i;j++){
                if (a[j].compareTo(a[j+1])>0){      //a[j]>a[j+1] 进行交换。
                    Comparable temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag = false;
                }
            }
            if (flag) break;
        }

    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 2, 9, 34, 3};
        Integer[] nums1 = new Integer[]{1, 4, 2, 9, 34, 3};
        sort(nums);
        QuickSort.sort(nums1,0,nums.length-1);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
