package com.smart.algorithms.designPatterns.esayFactory.no;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

public class Wages {

    private String type;

    public Wages(String type) {
        this.type = type;
    }
    public int getWages() {
        if (this.type.equals("boss")) {
            return 10000;
        }
        if (this.type.equals("worker")) {
            return 1000;
        }
        if (this.type.equals("family")) {
            return 80000;
        }
        return 500;
    }
}
