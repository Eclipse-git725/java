package oop;

public class VarParameter {
    public static void main(String[] args) {
        Var a = new Var();
        a.showscore("gxy", 90, 90);
        a.showscore("fm", 80,90,10);
    }
}

class Var{
    public void showscore(String name, int... scores){
        int sum = 0;
        for(int i = 0; i < scores.length; i ++ ){
            sum += scores[i];
        }
        System.out.println(name + ":" + sum);
    }
}