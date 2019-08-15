package com.github.linked.Impl;

public class TestDemo {
    public static void main(String[] args) {

        //MySingleListImpl mySingleList = new MySingleListImpl();
        SingleListed mySingleList = new SingleListed();

        mySingleList.addFirst(10);
        mySingleList.addFirst(20);
        mySingleList.addFirst(30);
        mySingleList.addFirst(40);
        mySingleList.addFirst(50);
        System.out.println("头插：");
        mySingleList.display();

        mySingleList.addLast(100);
        mySingleList.addLast(200);
        System.out.println("尾插：");
        mySingleList.display();
        System.out.println();

        System.out.print("单链表的长度：");
        System.out.println(mySingleList.getLength());
        System.out.println();

        mySingleList.addIndex(1,15);
        System.out.println("任意位置插入：");
        mySingleList.display();
        System.out.println();

        System.out.println("查找是否包含关键字 key 在单链表中：");
        System.out.println("查找关键字125："+mySingleList.contains(125));
        System.out.println("查找关键字30："+mySingleList.contains(30));
        System.out.println();

        System.out.println("删除第一次出现的关键字为 key 的节点：");
        System.out.println("删除头节点50：");
        mySingleList.remove(50); //删除头节点
        mySingleList.display();
        System.out.println("删除中间节点30：");
        mySingleList.remove(30); // 删除中间节点
        mySingleList.display();
        System.out.println("删除尾节点200：");
        mySingleList.remove(200); // 删除尾节点
        mySingleList.display();
        System.out.println();

        System.out.println("删除第一次出现的关键字为 key 的节点：");
        mySingleList.addFirst(20);
        mySingleList.display();
        mySingleList.removeAllKey(20);
        mySingleList.display();
        System.out.println();

        System.out.print("单链表的长度：");
        System.out.println(mySingleList.getLength());
        System.out.println();

        // 测试内存泄漏
        try {
            Thread.sleep(1000);
            System.out.println("睡醒了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
