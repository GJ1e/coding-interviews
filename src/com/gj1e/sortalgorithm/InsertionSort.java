package com.gj1e.sortalgorithm;

/**
 * @Author GJ1e
 * @Create 2019/9/21
 * @Time 17:44
 *
 * "插入排序"
 * 插入排序是一种最简单直观的排序算法，它的工作原理是通过构建有序序列，
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * “算法步骤”
 * 1、将第一个待排序序列的元素看作一个有序序列，把第二个到最后一个元素看作是未排序的序列。
 * 2、从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置，
 *    （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 */
public class InsertionSort {

    private static void sort (Comparable[] a){
        for (int i = 1;i<a.length;i++){     //从第二个元素开始，第一个元素默认已排序好。
            for(int j = i;j>0&&a[j].compareTo(a[j-1])<0;j--){   //a[j]<a[j-1],交换。
                Comparable temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }
}
