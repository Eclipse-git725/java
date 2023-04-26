package oop2;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(10000);
        account.setName("gxy");
        account.setPwd("15645");
        account.showInfo();
    }
}

class Account{
    private String name;
    private double balance;
    private String pwd;

    public Account() {
    }

    public Account(String name, double balance, String pwd) {
        this.name = name;
        this.balance = balance;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() > 4 || name.length() < 2){
            this.name = "姓名";
        }
        else this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance <= 20)   this.balance = 21;
        else this.balance = balance;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        if(pwd.length() != 6)   this.pwd = "123456";
        else this.pwd = pwd;
    }

    public void showInfo() {
        System.out.println(this.name + " " + this.balance + " " + this.pwd);
    }
}
