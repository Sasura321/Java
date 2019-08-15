package com.github.linked.Interview;

import com.github.linked.Impl.MySingleListImpl;

public interface ILinkedInterview {
    // 头插法
    void addFirst(int data);

    // 尾插法
    void addLast(int data);

    // 任意位置插入，第一数据节点为0号下标
    boolean addIndex(int index, int data);

    // 查找是否包含关键字 key 在单链表中
    boolean contains(int key);

    // 删除第一次出现的关键字为 key 的节点
    int remove(int key);

    // 删除所有值为 key 的节点
    void removeAllKey(int key);

    // 得到单链表的长度
    int getLength();

    // 打印单链表
    void display();

    //
    public void show(LinkedInterview.Node cur);

    // 清空单链表以防内存泄漏
    void clear();
}
