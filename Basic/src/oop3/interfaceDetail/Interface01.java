package oop3.interfaceDetail;

public class Interface01 {
    public static void main(String[] args) {

    }
}

interface IA{
    int n1 = 10; //  等价于 public static final int n1 = 10;
    void hi();
}

interface IB{
    void say();
}
// 接口能继承多个接口
interface IC extends IA,IB{

}

// 一个类同时实现多个接口
class A implements IA,IB{
    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}