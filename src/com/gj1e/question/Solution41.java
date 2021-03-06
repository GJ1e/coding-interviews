package com.gj1e.question;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author GJ1e
 * @Create 2020/3/8
 * @Time 11:00
 * 面试题41：数据流的中位数
 *
 * 题目：
 *      如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *      如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *      我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 思路：
 *      主要的思想是：因为要求的是中位数，那么这两个堆，大顶堆用来存较小的数，从大到小排列；
 *      小顶堆存较大的数，从小到大的顺序排序*，显然中位数就是大顶堆的根节点与小顶堆的根节点和的平均数。
 *      保证：小顶堆中的元素都大于等于大顶堆中的元素，所以每次塞值，并不是直接塞进去，而是从另一个堆中poll出一个最大（最小）的塞值
 *      当数目为偶数的时候，将这个值插入大顶堆中，再将大顶堆中根节点（即最大值）插入到小顶堆中；
 *      当数目为奇数的时候，将这个值插入小顶堆中，再讲小顶堆中根节点（即最小值）插入到大顶堆中；
 *      取中位数的时候，如果当前个数为偶数，显然是取小顶堆和大顶堆根结点的平均值；如果当前个数为奇数，显然是取小顶堆的根节点
 */
public class Solution41 {
    //小顶堆，从小到大排序
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //大顶堆，从大到小排序
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    int count =0;   //记录奇数，还是偶数。

    public void insert(Integer num){
        //偶数个，先放入大顶堆，然后将大顶堆的堆顶元素插入到小顶堆。
        if (count % 2 ==0){
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else{
        //奇数个，先放入小顶堆，然后将小顶堆的堆顶元素插入到大顶堆。
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count ++;
    }

    public Double getMedin(){
        //当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
        if(count % 2 == 0){
            return new Double(minHeap.peek() + maxHeap.peek())/2;
        }else{
            //当前为奇数个，则直接从小顶堆中取元素即可
            return new Double(minHeap.peek());
        }
    }
}
