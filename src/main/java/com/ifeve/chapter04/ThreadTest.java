package com.ifeve.chapter04;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Runner r = new Runner();
        Thread t = new Thread(r,"thread-not-start");
        t.setDaemon(true);
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        Thread.sleep(1000000000);
    }
}

class Runner implements  Runnable{

    @Override
    public void run() {
        try {
            this.wait(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
