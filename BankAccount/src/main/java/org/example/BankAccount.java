package org.example;

public abstract class BankAccount {
    protected int numWithdraws;
    protected double balance;
    BankAccount(double initialBalance){
        balance = initialBalance;
        numWithdraws = 0;
    }
    public void deposit(double amount){
        balance += amount;

    }
    public abstract void withdraw(double amount);
    public abstract void endMonth();
}
