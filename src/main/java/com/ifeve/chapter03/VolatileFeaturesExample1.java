package com.ifeve.chapter03;

/**
 * 语义同 VolatileFeaturesExample
 */
class VolatileFeaturesExample1 {
    long vl = 0L; // 64位的long型普通变量

    public synchronized void set(long l) {//对单个的普通变量的写用同一个锁同步
        vl = l;
    }

    public void getAndIncrement() { //普通方法调用
        long temp = get(); //调用已同步的读方法，此时读的结果是最新的

        // 但此时另一个线程修改了v1的值(如+1)

        temp += 1L; //普通写操作
        set(temp); //调用已同步的写方法，此时写回去1，但结果应该为2，所以没有保证原子性(volatile)
    }

    public synchronized long get() { //对单个的普通变量的读用同一个锁同步
        return vl;
    }
}
