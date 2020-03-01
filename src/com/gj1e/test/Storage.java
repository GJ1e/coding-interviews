package com.gj1e.test;

import java.util.LinkedList;

/**
 * @Author GJ1e
 * @Create 2019/12/7
 * @Time 19:09
 */
public class Storage {
    private final  int STORAGE_MAX = 10;

    private LinkedList<Object> list = new LinkedList<Object>();

    public void proudce(){

        synchronized(list){
            while (list.size()+1 > 10){
                System.out.println("生产者"+Thread.currentThread().getName()+"仓库已满");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("生产者"+Thread.currentThread().getName()
                    +"生产一个商品，现在库存为"+list.size());
            list.notifyAll();
        }
    }

    public void consume(){

        synchronized(this.list){

            while (list.size()==0){
                System.out.println("消费者"+Thread.currentThread().getName()+"仓库已空");

                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("消费者"+Thread.currentThread().getName()
                    +"已消费1个产品，现库存为"+list.size());
            list.notifyAll();
        }
    }
}
