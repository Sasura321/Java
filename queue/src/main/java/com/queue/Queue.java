package com.queue;

public class Queue implements IQueue {

    class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int usedSize;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.usedSize = 0;
    }

    /**
     * 1.判断这个队列是否为空
     * @return
     */
    @Override
    public boolean empty() {
        return this.usedSize == 0;
    }

    /**
     * 2.返回队首元素，但不出队列
     * @return
     */
    @Override
    public int peek() {
        if (empty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }

    /**
     * 3.返回队首元素，并且出队列
     * @return
     */
    @Override
    public int poll() {
        if (empty()) {
            throw new UnsupportedOperationException("队列为空");
        }

        int OldData = this.front.data;
        this.front = this.front.next;
        this.usedSize--;
        return OldData;
    }

    /**
     * 4.将 item 放入队列中
     * @param item
     */
    @Override
    public void add(int item) {
        Node node = new Node(item);

        if (this.front == null) {
            this.front = node;
            this.rear = node;
        } else {
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize++;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

}
