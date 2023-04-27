package oop3;

public class StaticMethod {
}


class Test{
    private int n1 = 100;
    private static int n2 = 200;
    public void say(){

    }
    public static void hi(){
        // 类方法不能使用和对象有关的关键字，如this和super
    }
    public static void hello(){
        // 静态方法只能访问静态变量和静态方法
        System.out.println(n2);
        System.out.println(Test.n2);
        hi();
        // say(); 不能访问
    }
}