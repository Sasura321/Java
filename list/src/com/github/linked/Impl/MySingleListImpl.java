package com.github.linked.Impl;

public class MySingleListImpl implements ILinked {

    // 节点类
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

    public MySingleListImpl() {
        this.head = head;
    }

    /**
     * 头插法
     * @param data
     */
    @Override
    public void addFirst(int data) {
        // 拿到一个实体
        Node node = new Node(data);

        // 第一次插入
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    /**
     * 尾插法
     * @param data
     */
    @Override
    public void addLast(int data) {
        // 拿到一个实体
        Node node = new Node(data);
        Node cur = this.head;

        // 如果是第一次插入
        if (this.head == null) {
            this.head = node;
        } else {
            // 1. 找尾巴
            while (cur.next != null) {
                cur = cur.next;
            }
            // 退出上面的循环，cur所执行的位置就是尾节点
            cur.next = node;
        }

    }

    // 找到 index-1 位置的节点
    private Node searchIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            return null;
        }
        int count = 0; //记录走的步数
        Node cur = this.head;
        while (cur.next != null && count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new IndexOutOfBoundsException("下标不合法！");
        }
    }

    /**
     * 任意位置插入，第一数据节点为 0号下标
     * @param index 插入的下标
     * @param data
     * @return true
     */
    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if (cur == null) {
            node.next = this.head;
            this.head = node;
        } else {
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }

    /**
     * 查找是否包含关键字 key 在单链表中
     * @param key
     * @return
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

    // 找第一次出现的关键字为 key 的节点的前驱
    private Node searchPre(int key) {
        // 1. 是不是第一个节点 if(head,data == key)
        Node pre = this.head;
        if (pre.data == key) {
            // 或者 return null;
            return this.head;
        }

        // 2. if(cur.next.data == key)
        while (pre.next != null) {
            if (pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }

        return null;
    }

    /**
     * 删除第一次出现的关键字为 key 的节点
     * @param key
     * @return oldData
     */
    @Override
    public int remove(int key) {
        int oldData = 0;
        Node pre = searchPre(key);

        // 若没有找到
        if (pre == null) {
            // return -1;
            throw new UnsupportedOperationException("没有key的前驱");
        }

        // 删除第一个节点
        if (pre == this.head && pre.data == key) {
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }

        Node delNode = pre.next;
        pre.next = delNode.next;

        return oldData;
    }

    /**
     * 删除所有值为 key 的节点
     * @param key
     */
    @Override
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;

        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    /**
     * 得到单链表的长度
     * @return 单链表长度
     */
    @Override
    public int getLength() {
        // 节点的个数
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 打印单链表
     */
    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 清空单链表以防内存泄漏
     */
    @Override
    public void clear() {
        while (this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
    }

}
