package oop2.object;

public class Finalize {
    public static void main(String[] args) {
        MyClass obj = new MyClass("test");
        obj = null;  // Set the reference to null to make the object eligible for garbage collection
        System.gc(); // Ask the garbage collector to run (not guaranteed to run immediately)
    }
}

class MyClass {
    private String name;

    public MyClass(String name) {
        this.name = name;
    }

    public void finalize() {
        System.out.println("Object with name " + name + " is being destroyed");
    }

    // Other methods and fields here
}
