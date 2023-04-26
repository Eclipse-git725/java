package oop2;
// 输出：a, b, b haha, c hello, c
public class Extends {
    public static void main(String[] args) {
//        B b = new B();
        C c = new C();
    }
}

class A {
    A(){
        System.out.println("a");
    }
//    A(String name){
//        System.out.println("a name");
//    }
}

//class B extends A{
//    B(){
//        this("abc");    // 调用了另一个构造函数
//        System.out.println("b");
//    }
//    B(String name){
//        System.out.println("b name");
//    }
//}

class B extends A{
    B(){
        System.out.println("b");
    }
    B(String name){
        System.out.println("b " + name);
    }
}

class C extends B{
    C(){
        this("hello");  // this是访问同类中其他构造器
        System.out.println("c");
    }
    C(String name){
        super("haha");  // super是访问父类中的构造器
        System.out.println("c " + name);
    }
}