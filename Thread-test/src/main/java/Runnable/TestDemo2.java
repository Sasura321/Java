package Runnable;

public class TestDemo2 {
    public static void main(String[] args) {
        //使用Lamdba表达式进行Runnable表达式创建
        Runnable runnable = () -> System.out.println("Hello world!");
        new Thread(runnable).start();
    }
}
