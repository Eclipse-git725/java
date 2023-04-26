package oop;

public class Object01 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "a";
        cat1.age = 19;
        cat1.speak();
        System.out.println(cat1.name + " " + cat1.age);
    }
}
class Cat{
    String name;
    int age;

    public void speak(){
        System.out.println("miao~");
    }
}