package com.ifeve.chapter02;

/**
 * 使用偏向锁的场景
 */
public class BiasedLocking {
    /**
     * 单线程通过循环不断地进入同步块
     */
    public void testWhile(){
        while (true){
            synchronized (this){
                System.out.println("..........");
            }
        }
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        // 单线程使用线程安全的对象（尤其是在Java早期）（例如，Vector，Hashtable，StringBuffer）
        stringBuffer.append("a").append("b").append("c");
    }
}
