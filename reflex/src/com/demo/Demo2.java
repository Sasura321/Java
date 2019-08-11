package com.demo;

public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Class<?> cls = Class.forName("java.util.Date");
        Object obj = cls.newInstance();  // 实例化对象
        System.out.println(obj);
    }
}
