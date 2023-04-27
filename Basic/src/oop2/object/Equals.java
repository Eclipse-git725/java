package oop2.object;

public class Equals {
    public static void main(String[] args) {
        Person a = new Person("gxy", 21, '女');
        Person b = new Person("gxy", 21, '女');
        System.out.println(a.equals(b));
    }
}


class Person{
    private String name;
    private int age;
    private char gender;
    // 重写equals方法
    public boolean equals(Object obj){
        // 若是相同的对象，直接返回
        if(this == obj) return true;
        else if(obj instanceof Person){
            // 相同类型
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
        }
        return false;
    }
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}