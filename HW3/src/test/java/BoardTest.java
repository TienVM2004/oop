import static org.junit.Assert.*;

import org.junit.*;

public class BoardTest {
    Board b;
    Board a;
    Piece pyr1, pyr2, pyr3, pyr4, s, sRotated,stick,square;
    Piece square1, square2, square3, square4;
    Piece stick1, stick2, stick3, stick4;
    Piece LL1, LL2, LL3, LL4;
    Piece LR1, LR2, LR3, LR4;
    Piece SL1, SL2, SL3, SL4;
    Piece SR1, SR2, SR3, SR4;
    public void copy(){
        for (int i = 0; i < 3; i++) {
            System.arraycopy(a.getBoard()[i], 0, b.getBoard()[i], 0, 6);
        }
    }

    @Before
    public void setUp() throws Exception {
        b = new Board(3, 6);
        Board a = new Board(3,6);

        pyr1 = new Piece(Piece.PYRAMID_STR);
        pyr2 = pyr1.computeNextRotation();
        pyr3 = pyr2.computeNextRotation();
        pyr4 = pyr3.computeNextRotation();


        ///////////////////////////////////
        stick1 = new Piece(Piece.STICK_STR);
        stick2 = stick1.computeNextRotation();
        stick3 = stick2.computeNextRotation();
        stick4 = stick3.computeNextRotation();

        square1 = new Piece(Piece.SQUARE_STR);
        square2 = square1.computeNextRotation();
        square3 = square2.computeNextRotation();
        square4 = square3.computeNextRotation();

        LL1 = new Piece(Piece.L2_STR);
        LL2 = LL1.computeNextRotation();
        LL3 = LL2.computeNextRotation();
        LL4 = LL3.computeNextRotation();

        LR1 = new Piece(Piece.L1_STR);
        LR2 = LR1.computeNextRotation();
        LR3 = LR2.computeNextRotation();
        LR4 = LR3.computeNextRotation();

        SL1 = new Piece(Piece.S2_STR);
        SL2 = SL1.computeNextRotation();
        SL3 = SL2.computeNextRotation();
        SL4 = SL3.computeNextRotation();

        SR1 = new Piece(Piece.S1_STR);
        SR2 = SR1.computeNextRotation();
        SR3 = SR2.computeNextRotation();
        SR4 = SR3.computeNextRotation();
///////////////////////////////////////


        s = new Piece(Piece.S1_STR);
        sRotated = s.computeNextRotation();

        stick = new Piece(Piece.STICK_STR);
        square = new Piece(Piece.SQUARE_STR);

        b.place(pyr1, 0, 0);
    }

    // Check the basic width/height/max after the one placement
    @Test
    public void testSample1() {
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
        assertEquals(Board.PLACE_OK, result);
        assertEquals(1, b.getColumnHeight(0));
        assertEquals(4, b.getColumnHeight(1));
        assertEquals(3, b.getColumnHeight(2));
        assertEquals(4, b.getMaxHeight());
    }

    // Make  more tests, by putting together longer series of
    // place, clearRows, undo, place ... checking a few col/row/max
    // numbers that the board looks right after the operations.

    // clearing out 3 rows
    @Test
    public void testSample3(){
        b.commit();
        int result = b.place(stick, 0, 1);
        assertEquals(Board.PLACE_OK, result);

        b.commit();
        result = b.place(sRotated, 1, 1);

        assertEquals(Board.PLACE_ROW_FILLED, result);
        assertEquals(5, b.getMaxHeight());
        assertEquals(4,b.getColumnHeight(1));
        assertEquals(3,b.getColumnHeight(2));
        assertEquals(2,b.getRowWidth(3));

        int numRowsCleared = b.clearRows();
        assertEquals(3,numRowsCleared);
        assertEquals(1,b.getRowWidth(1));

        b.undo();

        assertEquals(5, b.getMaxHeight());
        assertEquals(2,b.getColumnHeight(1));
        assertEquals(1,b.getColumnHeight(2));
        assertEquals(1,b.getRowWidth(4));

        //checking board width and height
        assertEquals(3, b.getWidth());
        assertEquals(6, b.getHeight());

    }

    // clearing out 4 rows
    @Test
    public void testSample4(){
        assertTrue(b.getGrid(1, 1));
        int result;
        b.undo();


        result = b.place(stick, 2, 0);
        b.commit();

        assertEquals(Board.PLACE_OK, result);
        assertEquals(4, b.getMaxHeight());

        int numRowsCleared = b.clearRows();

        assertEquals(0,numRowsCleared);
        assertEquals(4, b.getMaxHeight());
        assertEquals(0,b.getColumnHeight(1));
        assertEquals(4,b.getColumnHeight(2));
        assertEquals(1,b.getRowWidth(1));

        assertTrue(b.getGrid(78, 56));

        b.commit();
        result = b.place(square, 0, 0);
        b.commit();

        assertEquals(Board.PLACE_ROW_FILLED, result);

        result = b.place(square, 0, 2);
        b.commit();

        assertEquals(Board.PLACE_ROW_FILLED, result);

        result = b.place(square, 0, 4);
        b.commit();

        assertEquals(Board.PLACE_OK, result);

    }

    // clearing rows with gaps in between
    // verifying dropHeights

    @Test
    public void testSample5(){
        assertEquals(3,b.getRowWidth(0));
        assertEquals(1,b.clearRows());

        b.commit();

        assertEquals(1,b.getRowWidth(0));

        int result = b.place(SR1, 0, 0);
        int rowsCleared = b.clearRows();
        b.commit();

        assertEquals(Board.PLACE_BAD, result);
        assertEquals(0,rowsCleared);
        assertEquals(1,b.getMaxHeight());

        result = b.place(sRotated, 1, 1);
        assertEquals(4,b.getMaxHeight());
        rowsCleared = b.clearRows();
        b.commit();

        assertEquals(Board.PLACE_OK, result);
        assertEquals(0,rowsCleared);
        assertEquals(4,b.getMaxHeight());

        result = b.place(sRotated, 1, 1);
        rowsCleared = b.clearRows();

        assertEquals(Board.PLACE_BAD, result);
        assertEquals(0,rowsCleared);
        assertEquals(4,b.dropHeight(square, 1));


        assertTrue(!b.getGrid(0, 1));
        assertTrue(b.getGrid(1, 3));


        assertEquals(3,b.dropHeight(sRotated, 1));
        assertEquals(2,b.getRowWidth(0));
        assertEquals(1,b.getRowWidth(3));
        assertEquals(4,b.getColumnHeight(1));
    }
    @Test
    public void testSample6(){
        assertEquals(3, b.getWidth());
        assertEquals(6, b.getHeight());
        b.commit();



        int result = b.place(square, 0, 1);

        assertEquals(Board.PLACE_BAD, result);
        assertEquals(1,b.dropHeight(sRotated, 1));
        assertEquals(1,b.getRowWidth(2));
        assertEquals(3,b.dropHeight(square, 0));
        assertEquals(2,b.dropHeight(square.computeNextRotation(), 1));
        b.undo();

        assertEquals(2,b.getMaxHeight());

        result = b.place(square.computeNextRotation().computeNextRotation(), 0, 2);

        assertEquals(Board.PLACE_OK, result);

        b.commit();
        result = b.place(square.computeNextRotation().computeNextRotation(), 0, 4);

        assertEquals(Board.PLACE_OK, result);
        assertEquals(1,b.clearRows());

    }


}
