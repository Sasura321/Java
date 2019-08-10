package Runnable;

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println(Thread.currentThread().getName()+": i="+i);
        }
    }
}

public class GetName {
    public static void main(String[] args) {
        MyThread2 thread = new MyThread2();
        new Thread(thread).start(); //没有设置名字
        new Thread(thread).start();
        new Thread(thread,"线程1").start(); //设置了名字
        new Thread(thread,"线程2").start();
    }
}
