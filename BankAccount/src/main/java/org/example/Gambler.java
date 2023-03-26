package org.example;
import java.util.Random;

public class Gambler extends BankAccount{
    double randomChance;
    Gambler(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        randomChance = Math.random();
        if(randomChance >=0.49){
            balance -= 2*amount;
        }
    }

    @Override
    public void endMonth() {
        System.out.println("Your account has " + balance +"$.");
        numWithdraws = 0;
    }
    public static void main(String[] args){
        Gambler gam = new Gambler(100);
        gam.endMonth();
    }
}
