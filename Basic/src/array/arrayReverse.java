package array;

public class arrayReverse {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 66};
        for(int i = 0; i < 3; i ++ ){
            int t = arr[i];
            arr[i] = arr[5 - i];
            arr[5-i] = t;
        }
        for(int i = 0; i < 6; i ++ ){
            System.out.println(arr[i]);
        }
    }
}
