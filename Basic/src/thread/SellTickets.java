package thread;
// 用两种方法模拟三个窗口同时售票100张
public class SellTickets {
    public static void main(String[] args) {
        //测试
        // 使用继承Thread方式时，创建了三个线程对象，并启动三个线程，这三个线程会同时执行售票的任务，
        // 但由于ticketNum是静态变量，没有使用同步控制，因此可能出现超卖的情况，
        // 即ticketNum被多个线程同时修改，导致卖出的票数超过了100张。
//         SellTicket01 sellTicket01 = new SellTicket01();
//         SellTicket01 sellTicket02 = new SellTicket01();
//         SellTicket01 sellTicket03 = new SellTicket01();
//
//         //这里我们会出现超卖.. //
//         sellTicket01.start();//启动售票线程
//         sellTicket02.start();//启动售票线程
//         sellTicket03.start();//启动售票线程

//        System.out.println("===使用实现接口方式来售票=====");
        //使用实现Runnable方式时，创建了一个实现了Runnable接口的SellTicket02对象，并将该对象作为参数传给了三个Thread对象，
        // 并启动这三个线程。这三个线程会同时执行售票的任务，但由于ticketNum是实例变量，每个线程都会有一个独立的副本，
        // 因此不会出现超卖的情况。但是，如果多个线程同时访问该变量，可能会出现数据不一致的情况。因此，需要使用同步控制来保证数据的正确性。
//        SellTicket02 sellTicket02 = new SellTicket02();
//        new Thread(sellTicket02).start();//第 1 个线程-窗口
//        new Thread(sellTicket02).start();//第 2 个线程-窗
//        new Thread(sellTicket02).start();//第 3 个线程-窗

        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//第 1 个线程-窗口
        new Thread(sellTicket03).start();//第 2 个线程-窗口
        new Thread(sellTicket03).start();//第 3 个线程-窗口
    }
}
//实现接口方式, 使用 synchronized 实现线程同步
class SellTicket03 implements Runnable{
    private static int ticketNum = 100;//让多个线程共享 ticketNum
    private boolean loop = true;//控制 run 方法变量
    Object lock= new Object();
//    public synchronized void sell(){
//        // 同步方法
//        //使用synchronized修饰一个方法，可以保证同一时刻只有一个线程可以访问该方法。
//        // 当线程执行该方法时，会自动获取该方法所属对象的锁，并在方法执行完成后释放锁。
//        // 其他线程如果想要访问该方法，必须等待该方法的锁被释放后才能执行。
//        if (ticketNum <= 0) {
//            System.out.println("售票结束...");
//            loop = false;
//            return;
//        }
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" + " 剩余票数=" + (--ticketNum));//1 - 0 - -1 - -
//    }
    public void sell(){
        // 同步代码块
        //使用synchronized修饰一个代码块，可以指定某个对象作为锁，
        // 只有持有该锁的线程才能执行被synchronized修饰的代码块。
        // 当线程执行该代码块时，会自动获取指定对象的锁，并在代码块执行完成后释放锁。
        // 其他线程如果想要访问该代码块，必须等待该锁被释放后才能执行。
        synchronized (lock){
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" + " 剩余票数=" + (--ticketNum));//1 - 0 - -1 - -

        }
    }

    @Override
    public void run() {
        while (loop){
            sell();
        }
    }
}
class SellTicket01 extends Thread {
    private static int ticketNum = 100;//让多个线程共享 ticketNum
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
            //休眠 50 毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" + " 剩余票数=" + (--ticketNum));
        }
    }
}
//实现接口方式
class SellTicket02 implements Runnable {
    private int ticketNum = 100;//让多个线程共享 ticketNum
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }
//休眠 50 毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" + " 剩余票数=" + (--ticketNum));//1 - 0 - -1 - -2
        }
    }
}