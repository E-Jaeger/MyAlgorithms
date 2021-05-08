package com.smart.algorithms.java.concurrent;

public class VolatileVisibilitySample {

    private boolean initFlag = false;

    public void save() {
        this.initFlag = true;
        String threadname = Thread.currentThread().getName();
        System.out.println("线程:" + threadname + ":修改共享变量initFlag");
    }

    public void load() {
        String threadname = Thread.currentThread().getName();
        while (!initFlag) {
            System.out.println("--------------");
        }
        System.out.println("线程:" + threadname + "当前线程嗅探到initFlag的状态的改变");
    }

    public static void main(String[] args) {
        VolatileVisibilitySample sample = new VolatileVisibilitySample();
        Thread threadA = new Thread(sample::save, "ThreadA");
        Thread threadB = new Thread(sample::load, "ThreadB");
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.start();
    }
}
