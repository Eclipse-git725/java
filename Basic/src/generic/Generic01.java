package generic;

import java.util.ArrayList;

public class Generic01 {
    public static void main(String[] args) {
        ArrayList<Dog> arr = new ArrayList<Dog>();
        arr.add(new Dog("aa",1));
        arr.add(new Dog("bb",2));
        arr.add(new Dog("cc",3));
        for(Dog dog:arr){
            System.out.println(dog);
        }
    }
}
class Dog {
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}