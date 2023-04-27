package oop3.abstractDetail;

public class Abstract {
    public static void main(String[] args) {
        Manager manager = new Manager("gxy", 15425, 54574.0, 424);
        CommonEmployee worker = new CommonEmployee("gxy", 15425, 54574.0);
        manager.work();
        worker.work();
    }
}

abstract class Employee{
    private String name;
    private int id;
    private double salary;

    abstract public void work();
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee{
    private double bonus;
    public void work(){
        System.out.println("经理"+ getName() + "工作中...");
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

class CommonEmployee extends Employee{
    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("员工"+ getName() + "工作中...");
    }
}