package oop;

public class ex {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6}};
        MyTools a = new MyTools();
        a.print(arr);

        Person p = new Person();
        p.age = 18;
        p.name = "gxy";
        Person newp = new Person();
        newp = a.copyPerson(p);
        System.out.println(newp.name);
        System.out.println(p == newp);  // false
    }


}

class MyTools {
    public void print(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i ++ ){
            for(int j = 0; j < m; j ++ ){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Person copyPerson(Person p){
        Person newp = new Person();
        newp.age = p.age;
        newp.name = p.name;
        return newp;
    }
}