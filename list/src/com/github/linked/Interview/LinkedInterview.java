package com.github.linked.Interview;

public class LinkedInterview implements ILinkedInterview {

    // 节点类
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node head;

    public LinkedInterview() {
        this.head = null;
    }

    public Node getHead() {
        return head;
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
     * @return
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
     * @return
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
     * 打印单链表
     */
    @Override
    public void show(Node cur) {
        cur = head;
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


    /**
     * 在一个排序的链表中，存在重复的节点，请删除该链表中重复的结点，重复的节点不保留，返回链表的头指针
     * @return 头节点
     */
    //todo
    public Node deleteDuplication() {
        Node node = new Node(-1);
        Node cur = this.head;
        Node tmpHead = node;

        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                // 两个以上的节点重复
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                // cur指向的这个节点，和前面的节点不同
                // 确定当前的下一个是谁
                tmpHead.next = cur;
            } else {
                // 确定不为重复的节点，把它们串起来
                tmpHead.next = cur;
                tmpHead = cur;
                cur = cur.next;
            }
        }
        // node 时虚拟节点，真正的头结点节点是 node.next
        return node.next;
    }

    /**
     * 判断链表的回文结构 123321
     * @return true/false
     */
    public boolean chkPalindrome() {
        Node fast = this.head;
        Node slow = this.head;

        // 用快慢指针的方法找中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow 指向的位置就是中间节点
        Node p = slow.next;
        Node pNext = p.next;
        while (p != null) {
            p.next = slow;
            slow = p;
            p = pNext;
            if (p != null) {
                pNext = p.next;
            }
        }
        // 后半部分已经进行反转
        // 此时 slow  fast都指向最后一个元素上

        // 前半部分
        while (this.head != slow) {
            if (this.head.data != slow.data) {
                return false;
            }

            // 偶数个节点的情况
            if (this.head.next == slow) {
                return true;
            }

            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    /**
     * 输入两个链表，找出它们的第一个公共节点
     * @param headA 链表 1
     * @param headB 链表 2
     * @return 公共节点
     */
    public static Node getIntersectionNode(Node headA, Node headB) {
        Node pL = headA;
        Node pS = headB;

        int lenA = 0;
        while (pL != null) {
            lenA++;
            pL = pL.getNext();
        }

        int lenB = 0;
        while (pS != null) {
            lenB++;
            pS = pS.getNext();
        }

        pL = headA;
        pS = headB;

        // 长度差
        int len = lenA-lenB;
        if (len < 0) {
            pL = headB; // B单链表是长的
            pS = headA;
            len = lenB-lenA;
        }
        // 最长的单链表永远是pL，并且差值len是一个正数

        // pL 和 pS 在同一个起跑线上
        for (int i = 0; i < len; i++) {
            pL = pL.getNext();
        }

        // 找交点
        while (pL != null && pS != null && pL != pS) {
            pL = pL.getNext();
            pS = pS.getNext();
        }

        if (pL == pS && pL != null && pS != null) {
            return pL;
        }

        return null;
    }

    // 合并两个有序链表
    public Node mergeTowLists(Node headA, Node headB) {
        Node newHead = new Node(-1); // 虚拟节点
        Node tmpHead = newHead;
        while(headA != null && headB != null) {
            if (headA.getData() >= headB.getData()) {
                tmpHead.next = headA;
                tmpHead = tmpHead.next;
                headA = headA.next;
            } else {
                tmpHead.next = headB;
                tmpHead = tmpHead.next;
                headB = headB.next;
            }
        }

        if (headA != null) {
            tmpHead.next = headA;
        }

        if (headB != null) {
            tmpHead.next = headB;
        }

        return newHead.next;
    }

}
