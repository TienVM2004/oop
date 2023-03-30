import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class BoardTest {
    Board b;
    Piece pyr1, pyr2, pyr3, pyr4, pyr5, s, sRotated;

    // This shows how to build things in setUp() to re-use across tests.

    // In this case, setUp() makes shapes, and also a 3X6 board, with pyr placed at the bottom,
    // ready to be used by tests.

    @Before
    public void setUp() {
        b = new Board(3, 6);

        pyr1 = new Piece(Piece.PYRAMID_STR);
        pyr5 = pyr1;
        pyr2 = pyr1.computeNextRotation();
        pyr3 = pyr2.computeNextRotation();
        pyr4 = pyr3.computeNextRotation();

        s = new Piece(Piece.S1_STR);
        sRotated = s.computeNextRotation();

        b.place(pyr1, 0, 0);
        //int[] wid = b.getWid();
        //int[] hei = b.getHei();
    }

    // Check the basic width/height/max after the one placement
    @Test
    public void testSample1() {
        //int[] wid = b.getWid();
        assertEquals(false, pyr2.equals(pyr5));
        //assertArrayEquals(new boolean[]{true,true,true,false,false,false}, b.getBoard()[0]);
        //assertArrayEquals(new boolean[]{false,true,false,false,false,false}, b.getBoard()[1]);
        //assertArrayEquals(new boolean[]{false,false,false,false,false,false}, b.getBoard()[2]);
        assertEquals(1, b.getColumnHeight(0));
        assertEquals(2, b.getColumnHeight(1));
        assertEquals(2, b.getMaxHeight());
        assertEquals(3, b.getRowWidth(0));
        assertEquals(1, b.getRowWidth(1));
        assertEquals(0, b.getRowWidth(2));
    }

    // Place sRotated into the board, then check some measures
    @Test
    public void testSample2() {
        b.commit();
        int result = b.place(sRotated, 1, 1);
        //assertEquals(Board.PLACE_OK, result);
        assertEquals(4, b.getColumnHeight(1));
        assertEquals(3, b.getColumnHeight(2));
        assertEquals(4, b.getMaxHeight());
    }

    // Make  more tests, by putting together longer series of
    // place, clearRows, undo, place ... checking a few col/row/max
    // numbers that the board looks right after the operations.


}
