package com.demo;

interface IFruit1 {
    public void eat() ;
}
class Apple1 implements IFruit1 {
    @Override
    public void eat() {
        System.out.println("[Apple] 吃苹果 ");
    }
}
class Orange implements IFruit1 {
    @Override
    public void eat() {
        System.out.println("[Orange] 吃橘子 ");
    }
}
class FruitFactory1 {
    private FruitFactory1() {}
    public static IFruit1 getInstance(String className) {
        IFruit1 fruit = null ;
        try {
            fruit = (IFruit1) Class.forName(className).newInstance() ;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit ;
    }
}
public class Demo4 {
    public static void main(String[] args) {
        IFruit1 fruit = FruitFactory1.getInstance("com.demo.Orange") ;
        fruit.eat() ;
    }
}