package oop;

public class Constructor {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        System.out.println(p1.age + " " + p1.name);
        p1.info();
        Person1 p2 = new Person1("gxy", 21);
        System.out.println(p2.age + " " + p2.name);
        p2.info();
        Person1 p3 = new Person1("gxy", 21); // 判断p2和p3是否姓名年龄是否完全相同
        System.out.println(p2.compareTo(p3));
    }
}

class Person1 {
    int age;
    String name;
    Person1(){
        age = 18;
    }

    Person1(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void info(){
        System.out.println("当前对象的hashcode是：" + this.hashCode());
    }

    public boolean compareTo(Person1 p){
        return this.name.equals(p.name) && this.age == p.age;
    }
}