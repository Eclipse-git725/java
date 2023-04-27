package Exception;

public class Exception01 {
    public static void main(String[] args) {
        int n1 = 9;
        int n2 = 0;
        try{
            int res = n1 / n2;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

