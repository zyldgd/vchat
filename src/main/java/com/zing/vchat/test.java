package com.zing.vchat;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class test {

    volatile static String message;
    static Object lock = new Object();


    public static void main(String[] args){
        new test();
        System.out.println("qwe".substring(0, 2));
    }


    public static void main2(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        // 收线程
        executorService.submit(() -> {
            while (true) {
                System.out.println("接收就绪:");
                synchronized (lock) {
                    try {
                        if (message.length() == 0) {

                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("我收到了:" + message);
                    message = "";
                    lock.notifyAll();
                }
            }
        });
        executorService.submit(() -> {
            while (true) {
                synchronized (lock) {
                    if (message.length() != 0) {
                        lock.wait();
                    }
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入要发送的消息:");
                    message = scanner.next();
                    lock.notifyAll();
                }
            }
        });
    }
}
