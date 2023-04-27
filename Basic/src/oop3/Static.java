package oop3;

public class Static {
    public static void main(String[] args) {
        // 随着类的加载而创建
        System.out.println("一共有" + Child.count + "人");
        Child child1 = new Child("gxy");
        child1.join();
        Child child2 = new Child("fm");
        child2.join();
        Child child3 = new Child("hyy");
        child3.join();
        // 类变量通过类名来访问
        System.out.println("一共有" + Child.count + "人");
    }
}

class Child{
    private String name;
    // 类变量（静态变量），能被该类的所有对象实例共享
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public void join(){
        System.out.println(name + "加入了游戏");
        count ++;
    }
}
