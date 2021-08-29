package com.gj1e.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author FenDa
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    public static final int MAX_ENTRIES = 3;

    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > MAX_ENTRIES;
    }

    LRUCache() {
        super(MAX_ENTRIES,0.75f,true);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        System.out.println(cache.keySet());
        cache.get(1);
        cache.put(4, "d");
//        cache.get(3);
        System.out.println(cache.keySet());

        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });
        Thread thread = new Thread(task);
        thread.start();
        Thread otherThread = new Thread(() -> {
            System.out.println("otherThread task is running...");
        });
        otherThread.start();
        System.out.println(task.get());
    }
}
