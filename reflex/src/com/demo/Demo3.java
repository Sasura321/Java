package com.demo;

interface IFruit {
    public void eat() ;
}

class Apple implements IFruit {
    @Override
    public void eat() {
        System.out.println("[Apple] 吃苹果 ");
    }
}

class FruitFactory {
    private FruitFactory() {}
    public static IFruit getInstance(String className) {
        if ("apple".equals(className)) {
            return new Apple() ;
        }
        return null ;
    }
}

public class Demo3 {
    public static void main(String[] args) {
        IFruit fruit = FruitFactory.getInstance("apple") ;
        fruit.eat() ;
    }
}

