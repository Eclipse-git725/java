package thread;

public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start(); // 开启线程，最后执行的是run方法
    }
}
class Cat extends Thread {
    int times = 0;

    @Override
    public void run() {//重写 run 方法，写上自己的业务逻辑
        while (true) {
            //该线程每隔 1 秒。在控制台输出 “喵喵, 我是小猫咪”
            System.out.println("喵喵, 我是小猫咪" + (++times) + " 线程名=" + Thread.currentThread().getName());
            //让该线程休眠 1 秒 ctrl+alt+t
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 10) {
                break;//当 times 到 80, 退出 while, 这时线程也就退出.. }
            }
        }
    }
}