package com.smart.algorithms.designPatterns;

import com.smart.algorithms.designPatterns.singleTon.InstanceFactory;

import java.util.Arrays;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        int oldCapacity = 10;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacity);
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString((oldCapacity >> 1)));
        System.out.println(Integer.toBinaryString((oldCapacity >> 2)));

        char[]a= {'a','b','c','d','e','f'},
                b= {'1','2','3','4','5','6'};
        int []c= {1,2,3,4,5,6},
                d= {10,20,30,40,50,60};
        System.arraycopy(a, 0, b, 0, a.length);
        System.arraycopy(c, 2, d, 2, c.length-3);
        System.out.println("数组a的各个元素中的值："+ Arrays.toString(a));
        System.out.println("数组b的各个元素中的值：");
        System.out.println(Arrays.toString(b));
        System.out.println("数组c的各个元素中的值：");
        System.out.println(Arrays.toString(c));
        System.out.println("数组d的各个元素中的值：");
        System.out.println(Arrays.toString(d));

        System.out.println(InstanceFactory.getInstance());
        System.out.println(InstanceFactory.getInstance());
    }
}
