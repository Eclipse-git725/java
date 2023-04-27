package oop3;

public class SingleTon {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        GirlFriend instance1 = GirlFriend.getInstance();
        System.out.println(instance1 == instance);  // true

        Cat cat = Cat.getInstance();
        Cat cat1 = Cat.getInstance();
        System.out.println(cat == cat1);    // true
    }
}

// 饿汉式单例模式，在类加载时就创建了对象实例，不存在线程安全问题，存在资源浪费问题
class GirlFriend{
    private String name;
    private static GirlFriend gf = new GirlFriend("gxy");

    private GirlFriend(String name) {
        System.out.println("gf构造器被调用");
        this.name = name;
    }

    public static GirlFriend getInstance(){
        return gf;
    }
}

// 懒汉式存在线程安全问题，不存在浪费资源的问题
class Cat{
    private String name;
    public static int n1;
    private static Cat cat;

    private Cat(String name) {
        System.out.println("cat构造器被调用");
        this.name = name;
    }
    public static Cat getInstance(){
        if(cat == null){
            cat = new Cat("fm");
        }
        return cat;
    }
}