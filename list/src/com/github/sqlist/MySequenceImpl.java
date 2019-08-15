package com.github.sqlist;
import java.lang.*;
import java.util.Arrays;

public class MySequenceImpl implements ISequence {

    private Object[] elem;
    // 有效数据个数
    private int usedSize;
    private static final int DEFAULT_SIZE = 10;

    public MySequenceImpl() {
        this.elem = new Object[DEFAULT_SIZE];
        this.usedSize = 0;
    }

    // 判断是否为满
    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    /**
     * 在 pos 位置插入 val
     * @param pos 要插入的位置
     * @param data 插入的值
     * @return 成功插入true,否则false
     */
    @Override
    public boolean add(int pos, Object data) {
        // 1. pos 位置的合法性进行判断
        if (pos<0 || pos>this.elem.length) {
            return false;
        }

        // 2. 判断是否为满，若已满则进行扩容
        if (isFull()) {
            // 2 倍扩容
            // 拷贝数组：System.arraycopy(); / Arrays.copyOf(); （区别：后者有返回值）
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }

        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
        return true;
    }

    // 判断是否为空
    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    /**
     * 查找关键字 key 找到返回 key 的下标，没有返回 -1
     * @param key
     * @return
     */
    @Override
    public int search(Object key) {
        // 1. 判断是否为空
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i<usedSize; i++) {
            // 判断条件不能写成：this.elem[i] == key
            if (this.elem[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找是否包含关键字 key 是否在顺序表当中（这个和search有点冲突）
     * @param key 关键字
     * @return true/false
     */
    @Override
    public boolean contains(Object key) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i<usedSize; i++) {
            // 判断条件不能写成：this.elem[i] == key
            if (this.elem[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 得到 pos 位置的值
     * @param pos 位置
     * @return true/false
     */
    @Override
    public Object getPos(int pos) {
//        // 判断线性表是否为空
//        if (isEmpty()) {
//            return null;
//        }
        // 若位置不合法
        if (pos<0 || pos >= this.usedSize) {
            return null;
        }
        return this.elem[pos];
    }

    /**
     * 删除第一次出现的关键字 key
     * @param key
     * @return
     */
    @Override
    public Object remove(Object key) {
        int index = search(key);
        // 线性表里没有这个数
        if (index == -1) {
            return -1;
        }
        Object data = this.elem[index];
        int i;
        for (i = index; i<this.usedSize; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
        this.elem[i+1] = null;
        return data;
    }

    /**
     * 得到顺序表的长度
     * @return
     */
    @Override
    public int size() {
        return this.usedSize;
    }

    /**
     * 打印顺序表
     */
    @Override
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    /**
     * 清空顺序表以防内存泄漏
     */
    @Override
    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = null;
        }
    }
}
