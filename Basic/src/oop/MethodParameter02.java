package oop;

public class MethodParameter02 {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "gxy";
        p.age = 20;

        B b = new B();
        b.test200(p);
        System.out.println(p.age);
    }
}

class Person {
    String name;
    int age;
}

class B{
    public void test200(Person p){
        //p.age = 100;
        p = null;
    }
}