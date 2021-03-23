package com.ifeve.chapter04;

/**
 * 4-10
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class) {

        }
        m();
    }

    public static synchronized void m() {
    }
}
