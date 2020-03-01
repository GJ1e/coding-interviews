package com.gj1e.sortalgorithm;

/**
 * @Author GJ1e
 * @Create 2019/9/21
 * @Time 16:30
 *
 * "选择排序"
 * 选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。
 * 所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧
 *
 * “算法步骤”
 * 1、首先在未排序的序列中找到最小（大）元素，然后将它放在序列的最前（后）面。
 * 2、再从剩下的元素中寻找最小（大）元素，然后将它放在已排序序列的前（后）面。
 * 3、重复第二步，直到所有元素排序完毕。
 */
public class SelectionSort {
    private static void sort (Comparable[] a){
        for(int i = 0;i<a.length-1;i++){    //循环N轮
            int min = i;    //记录最小元素的下标
            for (int j = i+1; j < a.length; j++) {  //每轮比较N-i次
                if(a[min].compareTo(a[j])>0)    //a[min]>a[j],更新最小值的下标
                    min = j;

            }
            if (i!= min) {      //最小元素的下标值和原来不一样就更新。
                Comparable temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }
}
