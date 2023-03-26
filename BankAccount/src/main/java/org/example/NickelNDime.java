package org.example;

public class NickelNDime extends BankAccount{

    NickelNDime(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        numWithdraws++;
    }

    @Override
    public void endMonth() {
        balance -= 0.5 * numWithdraws;
        System.out.println("Your account has " + numWithdraws + " withdrawals, " + 0.5 * numWithdraws+"$ fee at end-month applied.");
        numWithdraws = 0;
    }
    public static void main(String[] args){
        NickelNDime dime = new NickelNDime(100);
        dime.endMonth();
    }
}
