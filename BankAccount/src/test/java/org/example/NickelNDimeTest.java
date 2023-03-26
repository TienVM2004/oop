package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NickelNDimeTest  {
    @Test
    public void NickleTest() {
        NickelNDime dime = new NickelNDime(100);
        dime.deposit(100);
        dime.deposit(100);
        dime.deposit(100);
        dime.deposit(100);
        dime.withdraw(100);
        dime.withdraw(100);
        dime.withdraw(100);
        dime.withdraw(100);
        assertEquals(4, dime.numWithdraws);
        assertEquals(100, dime.balance);
    }


}