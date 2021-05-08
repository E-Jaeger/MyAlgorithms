package com.smart.algorithms.designPatterns.esayFactory.yes;

public class WagesFactory {

    public static Wages createWages(String type) {
        Wages wages = null;
        switch (type) {
            case "boss":
                wages = new BossWages();
                break;
            case "worker":
                wages = new WorkerWages();
                break;
        }
        return wages;
    }
}
