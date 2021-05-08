package com.smart.algorithms.designPatterns.esayFactory.no;

public class Main {

    public static void main(String[] args) {

        Wages boss = new Wages("boss");
        int wages = boss.getWages();
        System.out.println(wages);

        Wages worker = new Wages("worker");
        int workerWages = worker.getWages();
        System.out.println(workerWages);

        Wages family = new Wages("family");
        int familyWages = family.getWages();
        System.out.println(familyWages);
    }
}
