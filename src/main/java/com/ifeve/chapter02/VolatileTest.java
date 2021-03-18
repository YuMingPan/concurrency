package com.ifeve.chapter02;

/**
 * <p>
 * 正确使用的场景举例：
 * 变量本身标识是一种状态，或者引用变量的某些属性状态，在代码中需要确保这些状态的可见性，这时就可使用volatile。
 * 来源：https://zhuanlan.zhihu.com/p/112742540
 * <p>
 * Java中的同步机制有四种：① ThreadLocal ②synchronized( ) ③ wait() 与 notify() ④ volatile
 * 目的：都是为了解决多线程中的对同一变量的访问冲突
 * <p>
 * synchronized 修饰方法使用锁是当前this锁。
 * synchronized 修饰静态方法使用锁是当前类的字节码对象！
 * <p>
 * volatile并不能保证原子性
 */
public class VolatileTest {
    private static boolean stop = false;// 任务是否停止,普通变量
//    private static volatile boolean stop = false;

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
            while (!stop) { // stop=false，不满足停止条件，继续执行
                //do someting
            }
            System.out.println("stop=true，满足停止条件。" +
                    "停止时间：" + System.currentTimeMillis());
        });
        thread1.start();

        Thread.sleep(100);// 保证主线程修改stop=true，在子线程启动后执行。
        stop = true; // true
        System.out.println("主线程设置停止标识 stop=true。" +
                "设置时间：" + System.currentTimeMillis());
    }
}
