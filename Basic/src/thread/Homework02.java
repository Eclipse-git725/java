package thread;

public class Homework02 {
    public static void main(String[] args) {
        Account account = new Account(10000);
        User user1 = new User("User1", account);
        User user2 = new User("User2", account);

        user1.start();
        user2.start();
    }
}

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized boolean withdraw(int amount) {
        if (balance >= amount) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public int getBalance() {
        return balance;
    }
}

class User extends Thread {
    private final String name;
    private final Account account;

    public User(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            boolean success = account.withdraw(1000);
            if (success) {
                System.out.println(name + " 取款 1000 元，余额为 " + account.getBalance() + " 元");
            } else {
                System.out.println(name + " 取款 1000 元失败，余额不足");
            }
        }
    }
}
