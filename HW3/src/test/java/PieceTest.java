import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

/*
  Unit test for Piece class -- starter shell.
 */
public class PieceTest {
    // You can create data to be used in the your test cases like this.
    // For each run of a test method, a new PieceTest object is created
    // and setUp() is called automatically by JUnit.
    // For example, the code below sets up some pyramid and s pieces
    // in instance variables that can be used in tests.

    private Piece stick1, stick2, stick3, stick4;
    private Piece LR1, LR2, LR3, LR4;
    private Piece LL1, LL2, LL3, LL4;
    private Piece SR1, SR2, SR3, SR4;
    private Piece SL1, SL2, SL3, SL4;
    private Piece sq1, sq2, sq3, sq4;
    private Piece pyr1, pyr2, pyr3, pyr4;
    private Piece s, sRotated;

    private Piece stickString2 = new Piece("0 0  2 0  3 0  1 0");
    private Piece SLString2 = new Piece("1 1  0 0  0 1  1 2");
    private Piece stick = new Piece("0 0  0 1  0 2  0 3");

    @Before
    public void setUp() {
        stick1 = new Piece(Piece.STICK_STR);
        stick2 = stick1.computeNextRotation();
        stick3 = stick2.computeNextRotation();
        stick4 = stick3.computeNextRotation();

        LR1 = new Piece(Piece.L1_STR);
        LR2 = LR1.computeNextRotation();
        LR3 = LR2.computeNextRotation();
        LR4 = LR3.computeNextRotation();

        LL1 = new Piece(Piece.L2_STR);
        LL2 = LL1.computeNextRotation();
        LL3 = LL2.computeNextRotation();
        LL4 = LL3.computeNextRotation();

        SR1 = new Piece(Piece.S1_STR);
        SR2 = SR1.computeNextRotation();
        SR3 = SR2.computeNextRotation();
        SR4 = SR3.computeNextRotation();

        SL1 = new Piece(Piece.S2_STR);
        SL2 = SL1.computeNextRotation();
        SL3 = SL2.computeNextRotation();
        SL4 = SL3.computeNextRotation();

        sq1 = new Piece(Piece.SQUARE_STR);
        sq2 = sq1.computeNextRotation();
        sq3 = sq2.computeNextRotation();
        sq4 = sq3.computeNextRotation();


        pyr1 = new Piece(Piece.PYRAMID_STR);
        pyr2 = pyr1.computeNextRotation();
        pyr3 = pyr2.computeNextRotation();
        pyr4 = pyr3.computeNextRotation();


        s = new Piece(Piece.S1_STR);
        sRotated = s.computeNextRotation();
    }

    // Here are some sample tests to get you started
    @Test
    public void testSampleSize() {
        assertEquals(true, stick.equals(new Piece("0 1  0 3  0 0  0 2")));
        assertEquals(false, stick.equals(stick.computeNextRotation()));
        // Check size of pyr piece
        assertEquals(1, stick1.getWidth());
        assertEquals(4, stick1.getHeight());

        assertEquals(2, LR1.getWidth());
        assertEquals(3, LR1.getHeight());

        assertEquals(2, LL1.getWidth());
        assertEquals(3, LL1.getHeight());

        assertEquals(3, SR1.getWidth());
        assertEquals(2, SR1.getHeight());

        assertEquals(3, SL1.getWidth());
        assertEquals(2, SL1.getHeight());

        assertEquals(2, sq1.getWidth());
        assertEquals(2, sq1.getHeight());

        assertEquals(3, pyr1.getWidth());
        assertEquals(2, pyr1.getHeight());

        // Now try after rotation
        // Effectively we're testing size and rotation code here
        assertEquals(2, pyr2.getWidth());
        assertEquals(3, pyr2.getHeight());

        // Now try with some other piece, made a different way
        Piece l = new Piece(Piece.STICK_STR);
        assertEquals(1, l.getWidth());
        assertEquals(4, l.getHeight());
    }


    // Test the skirt returned by a few pieces
    @Test
    public void testSampleSkirt() {
        // Note must use assertTrue(Arrays.equals(... as plain .equals does not work
        // right for arrays.
        assertArrayEquals(new int[]{1, 0}, pyr2.getSkirt());
        assertArrayEquals(new int[]{1, 0, 1}, pyr3.getSkirt());
        assertEquals(false, pyr2.equals(pyr1));
        assertTrue(Arrays.equals(new int[]{0,0,0,0}, stick4.getSkirt()));
        assertTrue(Arrays.equals(new int[]{0}, stick1.getSkirt()));
        assertTrue(Arrays.equals(new int[]{0, 0}, LR1.getSkirt()));
        assertTrue(Arrays.equals(new int[]{0, 0}, LL1.getSkirt()));
        assertArrayEquals(new int[]{1,1,0}, LL2.getSkirt());
        assertArrayEquals(new int[]{0,2}, LL3.getSkirt());
        assertArrayEquals(new int[]{0,0}, LL1.getSkirt());
        assertTrue(Arrays.equals(new int[]{0, 0, 1}, SR1.getSkirt()));
        assertTrue(Arrays.equals(new int[]{0, 1}, SL2.getSkirt()));
        assertTrue(Arrays.equals(new int[]{0, 0}, sq1.getSkirt()));

        assertTrue(Arrays.equals(new int[]{0, 0, 0}, pyr1.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0, 1}, pyr3.getSkirt()));

        assertTrue(Arrays.equals(new int[]{0, 0, 1}, s.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0}, sRotated.getSkirt()));
    }

    @Test
    public void testEquals() {
        assertEquals( true, stick2.equals(stickString2));
        assertEquals( true, SL2.equals(SLString2));
    }
}
