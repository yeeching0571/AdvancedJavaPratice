package com.JavaSenior.Thread.excerise;

/**
 * @author yeeching
 * @version 1.0
 * @description: 有两个储户分别向同一个账户存3000元，每次存 1000，存 3 次。每次存完打印账户余额
 * @date 2023/7/19 15:16
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
class Account{
    private double balance;
    Account(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public synchronized void deposit(double money) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance += money;
        System.out.println(Thread.currentThread().getName() + "：存入" + money + "元。账户余额为：" + balance);
    }
}

class Customer extends Thread{
    Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}
