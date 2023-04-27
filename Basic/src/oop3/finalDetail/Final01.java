package oop3.finalDetail;

public class Final01 {
    public static void main(String[] args) {
        C c = new C();
        new E().show();
    }
}

class A{
    // final修饰的属性可以在定义时、在构造器中和在代码块中赋值
    public final int TAX_RATE1 = 10;
    public final int TAX_RATE2;
    public final int TAX_RATE3;

    public A() {
        TAX_RATE2 = 9;
    }
    {
        TAX_RATE3 = 100;
    }
}

class B{
    //若final修饰的属性是静态的，只能在定义时和在静态代码块中赋值
    public static final int TAX_RATE1 = 10;
    public static final int TAX_RATE2;
    static {
        TAX_RATE2 = 10;
    }
}

// final定义的类不能继承，但能实例化对象
final class C{}

class D{
    // final定义的方法不能被重写，但能继承到子类
    public final void show(){
        System.out.println("show方法被调用");
    }
}

class E extends D{

}