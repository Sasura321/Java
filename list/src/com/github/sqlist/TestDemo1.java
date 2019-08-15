package com.github.sqlist;


public class TestDemo1 {
    public static void main(String[] args) {
        SqList mySequence = new SqList();
        //MySequenceImpl mySequence = new MySequenceImpl();

        for (int i = 0; i < 10; i++) {
            mySequence.add(i,i);
        }
        System.out.println("在最大值10的范围内插入数据：");
        mySequence.display();
        System.out.println();

        for (int i = 10; i < 20; i++) {
            mySequence.add(i,i);
        }
        System.out.println("扩容：");
        mySequence.display();
        System.out.println();

        System.out.println("随机位置插入数据：");
        mySequence.add(9,"list");
        mySequence.display();
        System.out.println();

        System.out.println("search查找一个数据："+mySequence.search("list"));
        System.out.println("contains查找一个数据："+mySequence.contains("list"));
        System.out.println();

        System.out.println("查找某一个位置对应的值："+mySequence.getPos(9));
        System.out.println();

        System.out.println("删除一个数据："+mySequence.remove(8));
        mySequence.display();
        System.out.println();

        System.out.println("得到顺序表的长度:"+mySequence.size());
    }
}
