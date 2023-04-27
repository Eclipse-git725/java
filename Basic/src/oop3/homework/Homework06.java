package oop3.homework;

public class Homework06 {
    public static void main(String[] args) {
        Person p = new Person("gxy");
        p.work();
        p.crossRiver();
        p.work();
    }
}
interface Vehicle{
    void work();
}
class Horse implements Vehicle{
    @Override
    public void work() {
        System.out.println("horse work");
    }
}

class Boat implements Vehicle{
    @Override
    public void work() {
        System.out.println("boat work");
    }
}
class VehiclesFactory{
    public static Vehicle getHorse() {
        return new Horse();
    }
    public static Vehicle getBoat() {
        return new Boat();
    }
}
class Person{
    private String name;
    private Vehicle vehicle;

    public Person(String name) {
        this.name = name;
        this.vehicle = VehiclesFactory.getHorse();
    }
    public void crossRiver(){
        this.vehicle = VehiclesFactory.getBoat();
    }
    public void work(){
        vehicle.work();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}