package com.ifeve.chapter01;

/**
 *
 */
public class ConcurrencyTest2 {

    /**
     * 执行次数
     */
    private static final long count = 1000000000L;

    public static void main(String[] args) throws InterruptedException {
        //并发计算
        concurrency();
        //单线程计算
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 1;
                for (long i = 0; i < count; i++) {
                    a *= 5;
                }
                System.out.println(a);
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        // 在当前(主)线程调用thread.join()这句话的话，当前线程等待，直到thread这个线程执行完毕，当前线程继续执行。
        // 注释掉下一行与否，查看区别
//        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 1;
        for (long i = 0; i < count; i++) {
            a *= 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }

}
