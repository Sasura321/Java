package com.github.sqlist;

public interface ISequence {
    // 在 pos 位置插入 val
    boolean add(int pos, Object data);

    // 查找关键字 key 找到返回 key 的下表，没有返回 -1
    int search(Object key);

    // 查找是否包含关键字 key 是否在顺序表当中（这个和search有点冲突）
    boolean contains(Object key);

    // 得到 pos 位置的值
    Object getPos(int pos);

    // 删除第一次出现的关键字 key
    Object remove(Object key);

    // 得到顺序表的长度
    int size();

    // 打印顺序表
    void display();

    // 清空顺序表以防内存泄漏
    void clear();
}

