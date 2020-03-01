package com.gj1e.sortalgorithm;

/**
 * @Author GJ1e
 * @Create 2019/9/21
 * @Time 11:26
 *
 * “快速排序”
 *     快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要 Ο(nlogn) 次比较。
 * 在最坏状况下则需要 Ο(n2) 次比较，但这种状况并不常见。事实上，快速排序通常明显比其他 Ο(nlogn) 算法更快，
 * 因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来。
 * 快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
 *
 */
public class QuickSort {

    public static void sort (Comparable[] a,int start,int end){
        if(start>=end) return;
        int j = partition(a,start,end);
        sort(a,start,j-1);
        sort(a,j+1,end);
    }
    private static int partition (Comparable[] a,int start,int end){
        int i = start;
        int j = end+1;
        Comparable v = a[start];    //设置切分元素

        while (true){
            while (v.compareTo(a[++i])>0) if(i==end) break;     //V > a[++i]
            while (v.compareTo(a[--j])<0) if(j==start) break;   //V < a[--j]
            if (i>=j) break;    //当指针i和j相遇时，就退出主循环。
            swap(a,i,j);    //小的放左边，大的放右边。
        }
        swap(a,start,j);    //将切分元素放入正确的位置
        return j;           //将数组切分成，a[start,j-1],a[j+1,end]。
    }

    private static void swap (Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
//    private static boolean less(Comparable v, Comparable w){
//        return v.compareTo(w) <0;
//    }
}
