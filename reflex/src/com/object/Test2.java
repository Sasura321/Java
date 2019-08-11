package com.object;

import java.lang.reflect.Constructor;

class Person {
    public Person() {}
    public Person(String name) {}
    public Person(String name,int age) {}
}

public class Test2 {
    public static void main(String[] args) {
        Class<?> cls = Person.class;
        // 取得类中的全部构造
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
