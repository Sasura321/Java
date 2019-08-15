package com.github.doubly;

public class DoubleLinked implements IDoubleLinked {

    class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;  // 头节点
    private Node last;  // 尾节点
    public DoubleLinked() {
        this.head = null;
        this.last = null;
    }

    /**
     * 1.头插法
     * @param data
     */
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    /**
     * 2.尾插法
     * @param data
     */
    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    // 查找
    private Node searchIndex(int index) {
        checkIndex(index);
        int count = 0;
        Node cur = this.head;
        while (count != index) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    // 合法性检查
    private void checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new IndexOutOfBoundsException("下标不合法！");
        }
    }

    /**
     * 3.任意位置插入，第一个数据节点为0号下标
     * @param index 插入位置
     * @param data 插入的值
     * @return true/false
     */
    @Override
    public boolean addIndex(int index, int data) {
        if (index ==0) {
            addFirst(data);
            return true;
        }

        if (index == getLength()) {
            addLast(data);
            return true;
        }

        // cur 指向index位置的节点
        Node cur = searchIndex(index);
        Node node = new Node(data);

        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;

        return true;
    }

    /**
     * 4.查找是否包含关键字 key 在单链表中
     * @param key 要查找的关键字
     * @return true/false
     */
    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 5.删除第一次出现关键字为 key 的节点
     * @param key
     * @return
     */
    @Override
    public int remove(int key) {
        Node cur = this.head;
        int oldData = 0;
        while (cur != null) {
            if (cur.data == key) {
                oldData = cur.data;
                // 头节点
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    // cur.next != null --->不是尾节点
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }

                return oldData;
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * 6.删除所有值为 key 的节点
     * @param key
     */
    @Override
    public void removeAllKey(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                // 头节点
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    // cur.next != null --->不是尾节点
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    /**
     * 7.得到单链表的长度
     * @return
     */
    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 8.打印链表
     */
    @Override
    public void display() {
        if (this.head == null) {
            return ;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }

        System.out.println();
    }

    /**
     * 9.清空顺序表以防内存泄漏
     */
    @Override
    public void clear() {
        while(this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head.prev = null;
            this.head = cur;
        }
    }
}
