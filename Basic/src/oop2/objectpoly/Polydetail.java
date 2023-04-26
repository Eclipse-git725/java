package oop2.objectpoly;

public class Polydetail {
    public static void main(String[] args) {
        // 多态的向上转型，父类引用指向子类对象
        Animal animal = new Cat();
        // 规则：可调用父类所有成员（要遵守访问权限），不能调用子类特有成员
        // 编译阶段能调用哪些类型由编译类型来决定  animal.catchMouse()错误
        animal.eat();
        animal.sleep();
        animal.run();

        // 若要能调用catchMouse方法，需要多态的向下转型
        Cat cat = (Cat) animal;
        cat.catchMouse();
        cat.run();

        System.out.println(animal.age); // 属性的值看编译类型 10
        System.out.println(cat.age);    // 20

        // instanceOf比较操作符，判断对象的运行类型是否为xx类型或是xx类型的子类型
        Cat cat1 = new Cat();
        System.out.println(cat1 instanceof Animal); // T
        System.out.println(cat1 instanceof Cat);    // T
        System.out.println(animal instanceof Animal);   // T
        System.out.println(animal instanceof Cat);  // T

        String str = "hello";
        System.out.println(str instanceof Object);  // T
    }
}

class Animal {
    String name = "动物";
    int age = 10;
    public void sleep(){
        System.out.println("睡");
    }
    public void run(){
        System.out.println("跑");
    }
    public void eat(){
        System.out.println("吃");
    }
    public void show(){
        System.out.println("你好");
    }
}

class Cat extends Animal{
    int age = 20;
    public void eat(){
        System.out.println("猫吃鱼");
    }
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}
class Dog extends Animal{

}