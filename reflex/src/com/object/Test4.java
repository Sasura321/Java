package com.object;

import java.lang.reflect.Method;

class Person2 {
    private String name;
    private int age;
    public Person2() {}
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" +age +"]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Test4 {
    public static void main(String[] args) throws Exception {
//        Class<?> cls = Person.class;
//        Method[] methods = cls.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

        Class<?> cls = Class.forName("com.object.Person2");
        Object obj = cls.newInstance();
        Method setMethod = cls.getMethod("setName",String.class);
        setMethod.invoke(obj, "yuisame");
        Method getMethod = cls.getMethod("getName");
        Object result = getMethod.invoke(obj);
        System.out.println(result);
    }
}
