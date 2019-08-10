package Runnable;

class MyThread implements Runnable {
    private String title;
    public MyThread(String title) {
        this.title = title;
    }

    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println(this.title+",i="+i);
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        //启动多线程
        MyThread m1 = new MyThread("Thread1");
        MyThread m2 = new MyThread("Thread2");
        MyThread m3 = new MyThread("Thread3");
        new Thread(m1).start();
        new Thread(m2).start();
        new Thread(m3).start();
    }
}
