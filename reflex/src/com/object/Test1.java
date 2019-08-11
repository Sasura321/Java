package com.object;

/*
* 取得父类信息
* 取得包的名称：public Package getPackage()
*/

interface IFruit {}
interface IMessage {}
class CLS implements IFruit,IMessage {}

public class Test1 {
    public static void main(String[] args) {
        Class<?> cls = CLS.class; //取得class类对象
        // 取得Package名称：com.object
        System.out.println(cls.getPackage().getName());
        // 取得父类名称：class java.lang.Object
        System.out.println(cls.getSuperclass());
        // 取得实现父接口对象
        // com.object.IFruit
        // com.object.IMessage
        Class<?>[] iClass = cls.getInterfaces();
        for (Class<?> class1 : iClass) {
            System.out.println(class1.getName());
        }
    }
}
