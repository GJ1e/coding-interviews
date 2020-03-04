package com.gj1e.question;

/**
 * @Author GJ1e
 * @Create 2020/3/4
 * @Time 11:43
 * 面试题35：复杂链表复制
 *
 * 题目：
 *      输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *      返回结果为复制后复杂链表的head。
 * 思路：
 *      第一步：复制链表，将任意节点N`链接在节点N的后面
 *      第二步：第二步，设置N`节点的random指针
 *      第三步：拆分链表，奇数位置上的为原始链表，偶数位置上的为复制链表
 */
public class Solution35 {
    //复杂链表节点定义
    class RandomListNode{
        int value;
        RandomListNode next = null;
        RandomListNode random = null;

        public RandomListNode(int value){
            this.value = value;
        }
    }

    public RandomListNode clone(RandomListNode pHead){
        if (pHead == null)
            return null;

        //第一步，复制链表，将任意节点N`链接在节点N的后面
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode pCloneNode = new RandomListNode(pNode.value);
            pCloneNode.next = pNode.next;
            pCloneNode.random = null;//链表改造还没完成，所以节点的随机指向先设置为null

            pNode.next = pCloneNode;
            pNode = pCloneNode.next;
        }

        //第二步，设置N`节点的random指针
        pNode = pHead;
        while (pNode != null){
            RandomListNode pCloneNode = pNode.next;
            if (pNode.random != null)
                pCloneNode.random = pNode.random.next;

            pNode = pCloneNode.next;
        }

        //第三步，拆分链表，奇数位置上的为原始链表，偶数位置上的为复制链表
        pNode = pHead;
        RandomListNode pCloneHead = null;
        RandomListNode pCloneNode = null;
        if (pNode != null){
            pCloneHead = pCloneNode = pNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        while (pNode != null){
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }

        return pCloneHead;  //返回复制链表的头节点
    }
}
