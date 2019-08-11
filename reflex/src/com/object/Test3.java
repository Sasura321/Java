package com.object;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Person1 {
    private String name ;
    private int age ;
    public Person1(String name,int age) {
        this.name = name ;
        this.age = age ;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

public class Test3 {
    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, NoSuchMethodException, SecurityException,
            IllegalArgumentException, InvocationTargetException {

        Class<?> cls = Person1.class;
        // 取得指定参数类型的构造方法对象
        Constructor<?> cons = cls.getConstructor(String.class, int.class) ;
        System.out.println(cons.newInstance("yuisama",29));
    }
}


