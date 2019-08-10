package Thread;

class MyThread extends Thread {
    private String title;

    public MyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println(this.title+",i="+i);
        }
    }
}

public class TestDemo {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("thread1");
        MyThread m2 = new MyThread("thread2");
        MyThread m3 = new MyThread("thread3");
        m1.start();
        m2.start();
        m3.start();
    }
}
