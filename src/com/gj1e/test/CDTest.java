package com.gj1e.test;

import java.util.PriorityQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author FenDa
 */
public class CDTest {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        ExecutorService service = Executors.newFixedThreadPool(2);
        final CountDownLatch cp = new CountDownLatch(1);
        final CountDownLatch xs = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CompletableFuture.runAsync(() -> {
                try {
                    System.out.println("选手" + Thread.currentThread().getName() + "正在等待裁判发布口令");
//                    cp.await();
                    System.out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令");
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
                    xs.countDown();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },service);
//            thread.setName("CD");
//            service.execute(thread);
        }
        try {
//            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("裁判"+Thread.currentThread().getName()+"即将发布口令");
//            cp.countDown();
            System.out.println("裁判"+Thread.currentThread().getName()+"已发送口令，正在等待所有选手到达终点");
            xs.await();
            System.out.println("所有选手都到达终点");
            System.out.println("裁判"+Thread.currentThread().getName()+"汇总成绩排名");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
