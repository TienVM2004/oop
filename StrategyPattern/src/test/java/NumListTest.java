import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumListTest {
    @Test
        public void testQuickSort() throws Exception {

            NumList numList = new NumList();
            numList.add(5);
            numList.add(7);
            numList.add(4);
            numList.add(3);
            numList.add(8);
            numList.add(9);
            numList.add(2);
            numList.add(-100);

            numList.setQuickSort();
            numList.setOrder();
            assertArrayEquals(new double[]{-100,2,3,4,5,7,8,9}, numList.getList());
        }

    @Test
    public void testQuickSort2() throws Exception {
        NumList numList = new NumList();
        numList.add(10);
        numList.add(5);
        numList.add(7);
        numList.add(2);
        numList.add(1);
        numList.add(8);
        numList.add(9);
        numList.add(3);
        numList.setQuickSort();
        numList.setOrder();
        assertArrayEquals(new double[]{1,2,3,5,7,8,9,10}, numList.getList());
    }

    @Test
    public void testBubble() throws Exception {
        NumList numList = new NumList();
        numList.add(4);
        numList.add(8);
        numList.add(1);
        numList.add(6);
        numList.add(3);
        numList.setBubbleSort();
        numList.setOrder();
        assertArrayEquals(new double[]{1,3,4,6,8}, numList.getList());
    }

    @Test
    public void testBubble2() throws Exception {
        NumList numList = new NumList();
        numList.add(1);
        numList.add(5);
        numList.add(3);
        numList.add(7);
        numList.add(2);
        numList.add(6);
        numList.add(4);
        numList.setBubbleSort();
        numList.setOrder();
        assertArrayEquals(new double[]{1,2,3,4,5,6,7}, numList.getList());
    }
}