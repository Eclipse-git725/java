package oop3.innerClass;

public class AnnoyInnerClass {
    // 匿名内部类既是一个类的定义，同时也是一个对象
    public static void main(String[] args) {
        Outer03 outer03 = new Outer03();
        outer03.method();

        // 匿名内部类当作实参直接传递
        f1(new IL(){
            public void show(){
                System.out.println("这是一副名画xx");
            }
        });

        // 练习
        CellPhone phone = new CellPhone();
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("起床");
            }
        });
        phone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("上课");
            }
        });
    }
    public static void f1(IL il){
        il.show();
    }
}
class Outer03{
    private int n1 = 100;
    public void method(){
        // 基于接口匿名内部类
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("tiger cry");
            }
        };
        System.out.println("tiger 的运行类型=" + tiger.getClass());
        tiger.cry();
        tiger.cry();
        tiger.cry();

        // 基于类的匿名内部类
        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        System.out.println("father 对象的运行类型=" + father.getClass());//Outer03$2
        father.test();

        // 基于抽象类的匿名内部类
        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("dog eat");
            }
        };
        System.out.println("animal 对象的运行类型=" + animal.getClass());//Outer03$3
        animal.eat();
    }
}
interface IA{
    public void cry();
}
class Father{
    public Father(String name) {
        System.out.println("father: " + name);
    }
    public void test(){

    }
}

abstract class Animal{
    abstract void eat();
}

// 匿名内部类做参数
interface IL{
    void show();
}
class Picture implements IL{
    @Override
    public void show() {
        System.out.println("这是一副名画xx");
    }
}

// 练习
interface Bell{
    void ring();
}

class CellPhone{
    public void alarmClock(Bell bell){
        System.out.println("bell 对象的运行类型=" + bell.getClass());
        bell.ring();
    }
}