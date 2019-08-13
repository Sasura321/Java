package com.stack;

public class Stack implements IStack{

    private int[] elem; // 存放数据元素的数组
    private int top;    // 当前可以存放数据的下标
    private int usedSize;

    public Stack(int size) {
        this.elem = new int[size];
        this.top = 0;
        this.usedSize = 0;
    }

    // 判断是否为满
    private boolean isFull() {
        return this.top == this.elem.length;
    }

    /**
     * 1.将 item 压入栈中
     * @param item
     */
    @Override
    public void push(int item) {
        // 判断是否为满
        if (isFull()) {
            throw new UnsupportedOperationException("栈为满");
        }

        this.elem[this.top++] = item;
        this.usedSize++;
    }

    /**
     * 2.返回栈顶元素，并且出栈
     * @return
     */
    @Override
    public int pop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("栈空");
        }
        this.top--;
        this.usedSize--;
        return this.elem[this.top];
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("栈空");
        }
        return this.elem[this.top-1];
    }

    @Override
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    @Override
    public int size() {
        return this.usedSize;
    }
}
