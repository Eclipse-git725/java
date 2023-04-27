package oop3.homework;

public class Homework04 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork();
    }
}

interface Cal{
    void work();
}

class CellPhone{
    void testWork(){
        Cal cal = new Cal() {
            @Override
            public void work() {
                System.out.println("test计算");
            }
        };
        cal.work();
    }


}