package array;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        double scores[];
        scores = new double[5];
        Scanner myScanner = new Scanner(System.in);
        /*for(int i = 0; i < scores.length; i ++ ){
            System.out.println("请输入第"+ (i + 1) + "个元素的值");
            scores[i] = myScanner.nextDouble();
        }

        System.out.println("=== 数组的值如下： ==");
        for(int i = 0; i < scores.length; i ++ ){
            System.out.println("数组第"+ (i + 1) + "个元素值为：" + scores[i]);
        }*/
        // 数组赋值
        /*int arr1[] = {1, 2, 3};
        int arr2[] = arr1;
        for(int i = 0; i < arr1.length; i ++ ){
            System.out.println(arr2[i] + " ");
        }
        arr2[0] = 10;
        for(int i = 0; i < arr1.length; i ++ ){
            System.out.println(arr1[i] + " ");
        }*/

        // 冒泡排序
        /*int arr3[] = {9,3,4,10,5,8,7};
        int t = 0;
        for(int i = 0; i < arr3.length - 1; i ++ ){
            boolean flag = false;
            for(int j = i + 1; j < arr3.length; j ++ ){
                if(arr3[i] > arr3[j]){
                    flag = true;
                    t = arr3[i];
                    arr3[i] = arr3[j];
                    arr3[j] = t;
                }
                if(flag) break;
            }
        }
        System.out.println("排序后的数组为：");
        for(int i = 0; i < arr3.length; i ++ ){
            System.out.println(arr3[i]);
        }*/

        //二维数组
        int arr[][];
        arr = new int[2][3];
        arr[1][1] = 8;
        for(int i = 0; i < arr.length; i ++ ){
            for(int j = 0; j < arr[0].length; j ++ ){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
