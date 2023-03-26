package org.example;

public class Fee extends BankAccount {

    Fee(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        numWithdraws++;
    }

    @Override
    public void endMonth() {
        balance -= 5;
        System.out.println("Your account has " + numWithdraws + " withdrawals, 5$ fee at end-month applied.");
        numWithdraws = 0;
    }
}
