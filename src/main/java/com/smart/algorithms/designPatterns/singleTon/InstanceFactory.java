package com.smart.algorithms.designPatterns.singleTon;

public class InstanceFactory {

    private static class InstanceHolder {
        private static final Object instance = new Object();
    }

    public static Object getInstance() {
        return InstanceHolder.instance;
    }
}
