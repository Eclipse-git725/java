package generic;

public class Generic02 {
    public static void main(String[] args) {
        Person<String> person = new Person<String>("gxy");
        person.show();
        Person<Integer> person1 = new Person<Integer>(21);
        person1.show();
    }
}
class Person<E>{
    E s;

    public Person(E s) {
        this.s = s;
    }
    public void show(){
        System.out.println(s.getClass());
    }
}
