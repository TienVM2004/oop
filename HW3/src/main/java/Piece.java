// Piece.java

import java.util.*;

/**
 * An immutable representation of a tetris piece in a particular rotation.
 * Each piece is defined by the blocks that make up its body.
 * <p>
 * Typical client code looks like...
 * <pre>
 * Piece pyra = new Piece(PYRAMID_STR);		// Create piece from string
 * int width = pyra.getWidth();			// 3
 * Piece pyra2 = pyramid.computeNextRotation(); // get rotation, slow way
 *
 * Piece[] pieces = Piece.getPieces();	// the array of root pieces
 * Piece stick = pieces[STICK];
 * int width = stick.getWidth();		// get its width
 * Piece stick2 = stick.fastRotation();	// get the next rotation, fast way
 * </pre>
 */
public class Piece {
    // Starter code specs out a few basic things, leaving
    // the algorithms to be done.
    private TPoint[] body;
    private int[] skirt;
    private int width;
    private int height;
    private Piece next; // "next" rotation

    static private Piece[] pieces;    // singleton static array of first rotations

    /**
     * Defines a new piece given a TPoint[] array of its body.
     * Makes its own copy of the array and the TPoints inside it.
     */
    public Piece(TPoint[] points) {
        contruct(points);
        // YOUR CODE HERE
    }

/** this "contruct" function is used both for string and TPoint[] constructor to
assign the width, height and the skirt.
amazing, i know right
 **/
    public void contruct(TPoint[] points){
        this.body = points; // BODY DEFINDEDDDDD
        int wid = 0;
        int hei = 0;
        //this is to predefine width and height, since we cant allocate an int[] without width
        for(TPoint t: points){
            if(t.x > wid) {
                wid = t.x;
            }
            if(t.y > hei) {
                hei = t.y;
            }
        }
        this.width = wid + 1; //wid starts from 0, so we must +1 WIDTH DEFINDEDDDDD
        this.height = hei + 1; // so is height HEIGHT DEFINDEDDDDDDD
        //finally making the skirt
        int[] skrt = new int[width];
        //make it big so we can find the min value in points
        for(int i = 0; i < width; i++){
            skrt[i] = 100; //big boi
        }
        //creating the final skirt
        for(TPoint t : points){
            if(t.y < skrt[t.x]) {
                skrt[t.x] = t.y;
            }
        }
        this.skirt = skrt; // SKIRT DEFINDEDDDDDDDDD
//done!
    }

    /**
     * Alternate constructor, takes a String with the x,y body points
     * all separated by spaces, such as "0 0  1 0  2 0	1 1".
     * (provided)
     */
    public Piece(String points) {
        TPoint[] mamamia = parsePoints(points);
        //this(parsePoints(points));
        contruct(mamamia);
    }

    /**
     * Returns the width of the piece measured in blocks.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the piece measured in blocks.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns a pointer to the piece's body. The caller
     * should not modify this array.
     */
    public TPoint[] getBody() {
        return body;
    }

    /**
     * Returns a pointer to the piece's skirt. For each x value
     * across the piece, the skirt gives the lowest y value in the body.
     * This is useful for computing where the piece will land.
     * The caller should not modify this array.
     */
    public int[] getSkirt() {
        return skirt;
    }


    /**
     * Returns a new piece that is 90 degrees counter-clockwise
     * rotated from the receiver.
     */
    public Piece computeNextRotation() {
        TPoint[] nextRotate = new TPoint[4];
        for (int i = 0; i < 4; i++) {
            nextRotate[i] = new TPoint(body[i].x, body[i].y);
        }

        //offSet is used for the cases where the shape of tetris fall out of bound, like -1 -2 -3 ...
        int offSetX = 0;
        int offSetY = 0;
        int temp;
        //algorithm for rotating: (x,y) ---> (-y,x)
        for(TPoint t : nextRotate) {
            temp = t.x;
            t.x = t.y;
            t.y = temp;
            t.x = -t.x;
            //calculating the maximum offset so that every block can be added into bound aferwards
            if(t.x < 0 && t.x < offSetX) offSetX = t.x;
            if(t.y < 0 && t.y < offSetY) offSetY = t.y;
        }
        //adding blocks to bound again;
        if(offSetY < 0 || offSetX < 0) {
            for (TPoint t : nextRotate) {
                t.x -= offSetX;
                t.y -= offSetY;
            }
        }
        Piece next = new Piece(nextRotate);
        // YOUR CODE HERE
        return next; // YOUR CODE HERE
    }

    /**
     * Returns a pre-computed piece that is 90 degrees counter-clockwise
     * rotated from the receiver.	 Fast because the piece is pre-computed.
     * This only works on pieces set up by makeFastRotations(), and otherwise
     * just returns null.
     */
    public Piece fastRotation() {
        return next;
    }


    /**
     * Returns true if two pieces are the same --
     * their bodies contain the same points.
     * Interestingly, this is not the same as having exactly the
     * same body arrays, since the points may not be
     * in the same order in the bodies. Used internally to detect
     * if two rotations are effectively the same.
     */
    public boolean equals(Object obj) {
        // standard equals() technique 1
        if (obj == this) return true;

        // standard equals() technique 2
        // (null will be false)
        if (!(obj instanceof Piece)) return false;
        //Piece other = (Piece) obj;

        // YOUR CODE HERE
        // i don't even know what im doing at this point
        TPoint[] OG = this.getBody(); //an array for the original
        TPoint[] ob = ((Piece) obj).getBody(); //and 1 for the copycat
        int find = 0;
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j ++){

                if(OG[i].equals(ob[j])){
                    find++;
                }
            }
        }

        if(find==4) return true;
        else return false;
    }


    // String constants for the standard 7 tetris pieces
    public static final String STICK_STR = "0 0	0 1	 0 2  0 3";
    public static final String L1_STR = "0 0	0 1	 0 2  1 0";
    public static final String L2_STR = "0 0	1 0 1 1	 1 2";
    public static final String S1_STR = "0 0	1 0	 1 1  2 1";
    public static final String S2_STR = "0 1	1 1  1 0  2 0";
    public static final String SQUARE_STR = "0 0  0 1  1 0  1 1";
    public static final String PYRAMID_STR = "0 0  1 0  1 1  2 0";

    // Indexes for the standard 7 pieces in the pieces array
    public static final int STICK = 0;
    public static final int L1 = 1;
    public static final int L2 = 2;
    public static final int S1 = 3;
    public static final int S2 = 4;
    public static final int SQUARE = 5;
    public static final int PYRAMID = 6;

    /**
     * Returns an array containing the first rotation of
     * each of the 7 standard tetris pieces in the order
     * STICK, L1, L2, S1, S2, SQUARE, PYRAMID.
     * The next (counterclockwise) rotation can be obtained
     * from each piece with the {@link #fastRotation()} message.
     * In this way, the client can iterate through all the rotations
     * until eventually getting back to the first rotation.
     * (provided code)
     */
    public static Piece[] getPieces() {
        // lazy evaluation -- create static array if needed
        if (Piece.pieces == null) {
            // use makeFastRotations() to compute all the rotations for each piece
            Piece.pieces = new Piece[]{
                    makeFastRotations(new Piece(STICK_STR)),
                    makeFastRotations(new Piece(L1_STR)),
                    makeFastRotations(new Piece(L2_STR)),
                    makeFastRotations(new Piece(S1_STR)),
                    makeFastRotations(new Piece(S2_STR)),
                    makeFastRotations(new Piece(SQUARE_STR)),
                    makeFastRotations(new Piece(PYRAMID_STR)),
            };
        }

        return Piece.pieces;
    }


    /**
     * Given the "first" root rotation of a piece, computes all
     * the other rotations and links them all together
     * in a circular list. The list loops back to the root as soon
     * as possible. Returns the root piece. fastRotation() relies on the
     * pointer structure setup here.
     */
	/*
	 Implementation: uses computeNextRotation()
	 and Piece.equals() to detect when the rotations have gotten us back
	 to the first piece.
	*/
    private static Piece makeFastRotations(Piece root) {
        Piece rootCopy = root;
        Piece nextRot = null;
        //this is like a goddamn linked list.
        //i loath linked lists.
        while(true) {
            nextRot = root.computeNextRotation();
            root.next = nextRot;
            root = root.next;
            if(root.computeNextRotation().equals(rootCopy)){
                root.next = rootCopy;
                break;
            }
        }


        // YOUR CODE HERE
        return rootCopy; // YOUR CODE HERE
    }


    /**
     * Given a string of x,y pairs ("0 0	0 1 0 2 1 0"), parses
     * the points into a TPoint[] array.
     * (Provided code)
     */
    private static TPoint[] parsePoints(String string) {
        List<TPoint> points = new ArrayList<>();
        StringTokenizer tok = new StringTokenizer(string);
        try {
            while (tok.hasMoreTokens()) {
                int x = Integer.parseInt(tok.nextToken());
                int y = Integer.parseInt(tok.nextToken());

                points.add(new TPoint(x, y));
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Could not parse x,y string:" + string);
        }

        // Make an array out of the collection
        TPoint[] array = points.toArray(new TPoint[0]);
        return array;
    }


}
