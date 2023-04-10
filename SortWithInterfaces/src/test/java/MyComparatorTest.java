import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyComparatorTest {
    @Test
    public void test(){
        BubbleSort sortit = new BubbleSort();

        BalanceAscending sort = new BalanceAscending();

        BankAccount[] arr = new BankAccount[]{new BankAccount(500, 4),new BankAccount(400, 5),new BankAccount(600, 3),new BankAccount(100, 1)};

        sortit.sort(arr,sort);

        BankAccount[] sorted = new BankAccount[]{new BankAccount(100, 1),new BankAccount(400, 5),new BankAccount(500, 4),new BankAccount(600, 3)};


        assertTrue(arr[0].equals(sorted[0]));
        assertTrue(arr[1].equals(sorted[1]));
        assertTrue(arr[2].equals(sorted[2]));
        assertTrue(arr[3].equals(sorted[3]));
    }

}