package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeeTest  {
    @Test
    public void testWithdraw() {
        Fee fee = new Fee(100);
        fee.withdraw(50);
        assertEquals(50, fee.balance, 0.001);
        assertEquals(1, fee.numWithdraws);
    }

}