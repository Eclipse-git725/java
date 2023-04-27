package oop3.homework;

public class Homework07 {
    public static void main(String[] args) {
        Car car1 = new Car(-1);
        Car car2 = new Car(41);
        Car car3 = new Car(30);
        car1.work();
        car2.work();
        car3.work();
    }
}
class Car{
    private int temperature;

    public Car(int temperature) {
        this.temperature = temperature;
    }

    class Air{
        void flow(){
            if(temperature<0)
                System.out.println("吹暖风");
            else if(temperature > 40)
                System.out.println("吹冷风");
            else System.out.println("关机");
        }
    }
    void work(){
        Air a = new Air();
        a.flow();
    }
}
