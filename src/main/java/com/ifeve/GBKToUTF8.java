package com.ifeve;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 来源 https://www.cnblogs.com/suizhikuo/p/12263153.html
 */
public class GBKToUTF8 {
    // 要转换的目录--目标资源URL
    private final static String targetFileUrl = "";

    // 遍历目录，将文件从GBK转换成UTF-8
    private static void fileList(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (!f.isDirectory()) {
                    codeConvert(f);
                }
                System.out.println(f.getPath());
                fileList(f);//递归调用子文件夹下的文件
            }
        }
    }

    public static void main(String[] args) {
        File file = new File(targetFileUrl);
        GBKToUTF8.fileList(file);
    }

    private static void codeConvert(File file) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (new FileInputStream(file), Charset.forName("GBK")));
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), Charset.forName("UTF-8")));
            bw.write(sb.toString());
            bw.flush();
            bw.close();
//br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}