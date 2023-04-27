package oop3.homework;

public class Homework05 {
    public static void main(String[] args) {
        A a = new A();
        a.test();
    }
}
class A{
    private String name = "gxy";
    void test(){
        class B {
            private final String name = "fm";
            void show(){
                System.out.println("B name:" + name);
                System.out.println("A name:" + A.this.name);
            }
        }
        B b = new B();
        b.show();
    }
}
