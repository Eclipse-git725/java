package thread;

// 通过接口runnable开发线程
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();

        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}
class Animal{

}
class Tiger extends Animal implements Runnable{
    int count = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("tiger" + (++count) + Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(count == 10) {
                break;
            }
        }
    }
}
//线程代理类 , 模拟了一个极简的 Thread 类
class ThreadProxy implements Runnable {//你可以把 Proxy 类当做 ThreadProxy
    private Runnable target = null;//属性，类型是 Runnable
    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定（运行类型 Tiger）
        }
    }
    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    public void start() {
        start0();//这个方法时真正实现多线程方法
    }
    public void start0() {
        run();
    }
}
class Dog implements Runnable{
    int count = 0;

    @Override
    public void run() {
        while(true){
            System.out.println("小狗汪汪叫..hi" + (++count) + Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if(count == 10) {
                break;
            }
        }
    }
}