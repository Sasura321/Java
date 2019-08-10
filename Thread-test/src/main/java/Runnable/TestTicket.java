package Runnable;

class MyThread1 implements Runnable {
    private int ticket = 10; //一共有10张票可以出售

    @Override
    public void run() {
        while(ticket>0) {
            System.out.println("剩余票数："+this.ticket--);
        }
    }
}

public class TestTicket {
    public static void main(String[] args) {
        MyThread1 m1 = new MyThread1();
        new Thread(m1).start();
        new Thread(m1).start();
        new Thread(m1).start();
    }
}
