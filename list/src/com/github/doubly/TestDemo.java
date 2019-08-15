package com.github.doubly;

public class TestDemo {
    public static void main(String[] args) {
        DoubleLinked doubleLinked = new DoubleLinked();
        doubleLinked.addFirst(10);
        doubleLinked.addFirst(20);
        doubleLinked.addFirst(30);
        doubleLinked.addFirst(40);
        doubleLinked.addFirst(50);
        doubleLinked.display();


        doubleLinked.addIndex(0,100);
        doubleLinked.addIndex(1,200);
        doubleLinked.addIndex(0,300);
        doubleLinked.addLast(40);
        doubleLinked.addLast(50);
        doubleLinked.display();

        doubleLinked.remove(300);
        doubleLinked.display();

        doubleLinked.removeAllKey(50);
        doubleLinked.display();
    }
}
