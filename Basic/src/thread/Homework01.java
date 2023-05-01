package thread;

import java.util.Random;
import java.util.Scanner;

public class Homework01 {
    private static boolean stopFlag = false;
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            Random random = new Random();
            while (!stopFlag) {
                int num = random.nextInt(100);
                System.out.println("Thread 1: " + num);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String input = scanner.nextLine();
                if ("Q".equals(input)) {
                    stopFlag = true;
                    break;
                }
            }
        });

        t1.start();
        t2.start();
    }
}
