package com.gj1e.test;

/**
 * @Author GJ1e
 * @Create 2019/12/7
 * @Time 19:26
 */
public class Producer implements Runnable {
    private  Storage storage;

    public Producer() {
    }

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                storage.proudce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
