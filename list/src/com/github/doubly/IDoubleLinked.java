package com.github.doubly;

// 不带头节点单链表的实现
public interface IDoubleLinked {
    // 1.头插法
    void addFirst(int data);

    // 2.尾插法
    void addLast(int data);

    // 3.任意位置插入，第一个数据节点为0号下标
    boolean addIndex(int index, int data);

    // 4.查找是否包含关键字 key 在单链表中
    boolean contains(int key);

    // 5.删除第一次出现关键字为 key 的节点
    int remove(int key);

    // 6.删除所有值为 key 的节点
    void removeAllKey(int key);

    // 7.得到单链表的长度
    int getLength();

    // 8.打印链表
    void display();

    // 9.清空顺序表以防内存泄漏
    void clear();
}
