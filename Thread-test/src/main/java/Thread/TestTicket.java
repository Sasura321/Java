package Thread;

class MyThread1 extends Thread {
    private int ticket = 10; //一共有10张票可以出售
    private String sale;
    public MyThread1(String sale) {
        this.sale = sale;
    }

    @Override
    public void run() {
        while(this.ticket>0) {
            System.out.println(this.sale+"->剩余票数："+this.ticket--);
        }
    }
}

public class TestTicket {
    public static void main(String[] args) {
        //有三个售票员在共同出售这10张票
//        new MyThread1().start();
//        new MyThread1().start();
//        new MyThread1().start();
        MyThread1 m1 = new MyThread1("A");
        MyThread1 m2 = new MyThread1("B");
        MyThread1 m3 = new MyThread1("C");
        m1.start();
        m2.start();
        m3.start();

    }
}
