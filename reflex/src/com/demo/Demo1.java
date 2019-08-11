package com.demo;

import java.util.Date;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Date date = new Date();
        // 获得了对象的来源，其实就是“反”的本质
        System.out.println(date.getClass());

        Class<?> cls = Class.forName("java.util.Date");
        System.out.println(cls.getName());
    }
}
