package com.smart.algorithms.java;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class HashMapInfiniteLoop {

    private static HashMap<Integer, String> map = new HashMap<Integer, String>(2, 0.75f);
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {
        map.put(5, "C");
        new Thread("Thread1") {  
            public void run() {  
                map.put(7, "B");  
                System.out.println(map);  
            };  
        }.start();  
        new Thread("Thread2") {  
            public void run() {
                map.put(3, "A");
                System.out.println(map);  
            };  
        }.start();
    }
}