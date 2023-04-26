package oop2.objectpoly;

public class DynamicBinding {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.sum());    // 40
        System.out.println(a.sum1());   // 30
    }
}

class A{
    public int i = 10;
    public int getI(){
        return i;
    }
    public int sum(){
        return getI() + 10;
    }
    public int sum1(){
        return i + 10;
    }
}
class B extends A{
    public int i = 20;
    public int getI(){
        return i;
    }
    public int sum(){
        return i + 20;
    }
    public int sum1(){
        return i + 10;
    }
}