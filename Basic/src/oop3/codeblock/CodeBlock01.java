package oop3.codeblock;

public class CodeBlock01 {
    public static void main(String[] args) {
        // 静态代码块在类加载时执行，只执行一次，普通代码块每创建一个对象就执行一次
//        A a1 = new A();
        // 创建子类对象时，父类对象也会加载，并且父类对象先加载
        B b1 = new B();
        // 使用类的静态成员时会加载
        System.out.println(D.n1);
        C c1 = new C();
        C c2 = new C();

        // 继承时，父类和子类静态代码块、普通代码块、静态属性初始化、普通属性初始化、构造函数的调用顺序
        Son son = new Son();
    }
}

class A{
    static {
        System.out.println("A的静态代码块被执行");
    }
}

class B extends A{
    static {
        System.out.println("B的静态代码块被执行");
    }
}

class C{
    static {
        System.out.println("C的静态代码块被执行");
    }
    {
        System.out.println("C的普通代码块被执行");
    }
}

class D{
    static int n1;
    static {
        System.out.println("C的静态代码块被执行");
    }
}

class Father{

    private static int getNum() {
        System.out.println("father静态属性初始化");
        return 10;
    }
    static {
        System.out.println("father的静态代码块被执行");
    }
    private static int n1 = getNum();
    {
        System.out.println("father的普通代码块被执行");
    }
    public Father() {
        System.out.println("father的构造被执行");
    }
}

class Son extends Father{
    private static int n1 = getNum();

    private static int getNum() {
        System.out.println("son静态属性初始化");
        return 10;
    }

    static {
        System.out.println("son的静态代码块被执行");
    }
    {
        System.out.println("son的普通代码块被执行");
    }
    public Son() {
        System.out.println("son的构造被执行");
    }

}