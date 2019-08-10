package Runnable;

public class TestDemo1 {
    public static void main(String[] args) {
        //使用匿名内壁类进行Runnable对象创建
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello world");
            }
        }).start();
    }
}
