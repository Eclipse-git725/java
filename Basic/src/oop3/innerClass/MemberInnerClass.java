package oop3.innerClass;

public class MemberInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.t1();

        // 外部其他类使用成员内部类的方法
        // 1,
        Outer04.Inner04 inner04 = outer04.new Inner04();
        inner04.say();
        // 2,
        Outer04.Inner04 getInnerInstance = outer04.getInner04Instance();
        getInnerInstance.say();
    }
}

class Outer04{
    private int n1 = 100;
    public String name = "gxy";

    private void hi(){
        System.out.println("hi");
    }
    public class Inner04{
        private int n1 = 99;
        public void say(){
            System.out.println("n1 = " + n1 + " name = " + name + " 外部类的 n1=" + Outer04.this.n1);
            hi();
        }
    }
    public Inner04 getInner04Instance(){
        return new Inner04();
    }
    public void t1(){
        Inner04 inner04 = new Inner04();
        inner04.say();
    }
}

