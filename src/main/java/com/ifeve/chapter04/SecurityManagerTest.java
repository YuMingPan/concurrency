package com.ifeve.chapter04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SecurityManagerTest {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("SecurityManager: " + System.getSecurityManager());

        FileInputStream fis = new FileInputStream("d:\\test.txt");

        System.out.println(System.getProperty("file.encoding"));

    }
}
