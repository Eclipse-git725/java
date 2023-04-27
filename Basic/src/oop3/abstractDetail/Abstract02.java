package oop3.abstractDetail;

public class Abstract02 {
    // 有多个类，执行不同的job，计算时间，使用设计模式
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.calTime();
        b.calTime();
    }
}

abstract class Template{
    abstract public void job();
    public void calTime(){
        long start = System.currentTimeMillis();
        job();  // 动态绑定机制
        long end = System.currentTimeMillis();
        System.out.println("任务执行时间：" + (end - start));
    }
}

class A extends Template{
    @Override
    public void job() {
        for(int i = 0; i < 100000000; i++ ){}
    }
}

class B extends Template{
    @Override
    public void job() {
        for(int i = 0; i < 200000000; i++ ){}
    }
}