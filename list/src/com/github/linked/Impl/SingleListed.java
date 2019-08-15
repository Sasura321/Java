package com.github.linked.Impl;

public class SingleListed implements ILinked {

    // 节点类
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head; //头节点
    public SingleListed() {
        this.head = head;
    }

    /**
     * 头插法
     * @param data 要插入的数据
     */
    @Override
    public void addFirst(int data) {
        // 1. 拿到一个实体
        Node node = new Node(data);

        // 2. 插入
        // 如果是第一次插入，直接到头节点
        if (this.head == null) {
            this.head = node;
        } else { //不是第一次插入
            node.next = this.head; // 插入的节点指向头节点
            this.head = node;      // 更新头节点
        }
    }

    /**
     * 尾插法
     * @param data 要插入的数据
     */
    @Override
    public void addLast(int data) {
        // 1. 拿到一个实体
        Node node = new Node(data);
        Node cur = this.head;

        // 2. 插入
        // 如果是第一次插入，直接到头节点
        if (this.head == null) {
            this.head = node;
        } else {
            // 找尾巴
            while (cur.next != null) {
                cur = cur.next;
            }
            // 退出上面的循环，cur所执行的位置就是尾节点
            cur.next = node;
        }
    }

    // 检测 index 该下标是否合法
    private void checkIndex(int index) {
        if (index < 0 || index > getLength())
            throw new IndexOutOfBoundsException("下标不合法！");
    }

    // 找到下标为 index-1 位置的节点
    private Node searchIndex(int index) {
        checkIndex(index);
        if (index == 0)
            return null;
        int count = 0; // 记录行走的步数
        Node cur = this.head;

        while (cur.next != null && count < index-1) {
            cur = cur.next;
            count++;
        }

        return cur;
    }

    /**
     * 任意位置插入，第一数据节点为 0号下标
     * @param index 插入的下标
     * @param data 要插入的数据
     * @return true
     */
    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        Node cur = searchIndex(index);

        // 如果链表为空，直接插入到头节点
        if (cur == null) {
            node.next = this.head;
            this.head = node;
        } else { // 链表不为空，插入到 cur 的位置处
            node.next = cur.next;  // 将node链接到cur的下一个节点
            cur.next = node;       // 再将cur链接到node
        }

        return true;
    }

    /**
     * 查找是否包含关键字 key 在单链表中
     * @param key 要查找的关键字
     * @return 找到key返回true，否则返回false
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
     * @param key 要删除的关键字
     * @return oldData
     */
    @Override
    public int remove(int key) {
        int oldData = 0;
        Node pre = searchPre(key);

        // 1. 若没有找到
        if (pre == null) {
            // return -1;
            throw new UnsupportedOperationException("没有key的前驱");
        }

        // 2. 找到了，并且在第一个节点
        if (pre == this.head && pre.data == key){
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }

        // 3. 找到了，并且不在第一个节点
        Node delNode = pre.next; // 确定要删除的节点的位置
        pre.next = delNode.next; // 让要删除的节点的前驱指向要删除的节点的后一个节点，进而删除该节点

        return 0;
    }

    /**
     * 删除所有值为 key 的节点
     * @param key 要删除的节点的值
     */
    @Override
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;

        // 遍历一遍链表
        while (cur != null) {
            // 若找到了关键字，进行删除
            if (cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            } else { // 若不是关键字，继续查看链表的下一个
                pre = cur;
                cur = cur.next;
            }
            if (this.head.data == key) {
                this.head = this.head.next;
            }
        }
    }

    /**
     * 得到单链表的长度
     * @return 单链表长度
     */
    @Override
    public int getLength() {
        Node cur = this.head;
        int count = 0;  // 节点的个数
        while (cur != null) {
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
