package oop;

public class RecursionExercise {
    public static void main(String[] args) {
        int day = 1;
        T t1 = new T();
        int peachNum = t1.peach(day);
        System.out.println(peachNum);
    }
}

class T {
    int n = 1;
    public int peach(int day){
        if(day == 10) {
            return 1;
        }
        else if(day >= 1 && day <= 9){
            return (peach(day + 1) + 1) * 2;
        }
        return -1;
    }
}