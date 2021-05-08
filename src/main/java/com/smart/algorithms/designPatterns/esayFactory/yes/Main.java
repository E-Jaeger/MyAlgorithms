package com.smart.algorithms.designPatterns.esayFactory.yes;

public class Main {
    public static void main(String[] args) {
        System.out.println(WagesFactory.createWages("boss").getWages());
        System.out.println(WagesFactory.createWages("worker").getWages());
    }
}
