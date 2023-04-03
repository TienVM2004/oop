// Board.java

import java.util.Arrays;

/**
 * CS108 Tetris Board.
 * Represents a Tetris board -- essentially a 2-d grid
 * of booleans. Supports tetris pieces and row clearing.
 * Has an "undo" feature that allows clients to add and remove pieces efficiently.
 * Does not do any drawing or have any idea of pixels. Instead,
 * just represents the abstract 2-d board.
 */
public class Board {
    // Some ivars are stubbed out for you:
    private int width;
    private int height;
    private boolean[][] grid;
    private boolean DEBUG = true;
    boolean committed;

    //Custom variables
    private int[] wid;
    private int[] hei;
    private boolean lastGrid[][];
    private int[] lastWid;
    private int[] lastHei;
    private int lastMaxHeight;
    private int maxHeight;



    // Here a few trivial methods are provided:

    /**
     * Creates an empty board of the given width and height
     * measured in blocks.
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new boolean[width][height];
        committed = true;

        // YOUR CODE HERE
        maxHeight = 0;
        wid = new int[height];
        hei = new int[width];
        lastHei = new int[width];
        lastWid = new int[height];
        lastGrid = new boolean[width][height];
        for(int i = 0 ; i < width; i ++) {
            hei[i] = 0;
        }
        for(int i = 0 ; i < height; i ++) {
            wid[i] = 0;
        }
        for(int i = 0 ; i < width; i ++) {
            for(int j = 0; j < height; j ++) {
                grid[i][j] = false;
            }
        }

    }

    public void saveLastBoard(){
        lastMaxHeight = maxHeight;
        System.arraycopy(wid, 0, lastWid, 0, height);
        System.arraycopy(hei, 0, lastHei, 0, width);
        for (int i = 0; i < grid.length; i ++) {
            System.arraycopy(grid[i], 0, lastGrid[i], 0, height);
        }
    }

    /**
     * Returns the width of the board in blocks.
     */
    public int getWidth() {
        return width;
    }
    public void updateWidth() {
        int temp = 0;
        //updating wid[]
        for(int i = 0; i < height; i ++) {
            temp = 0;
            for(int j = 0; j < width; j ++) {
                if(grid[j][i]) temp++;
            }
            wid[i] = temp;
        }
    }



    /**
     * Returns the height of the board in blocks.
     */
    public int getHeight() {
        return height;
    }
    public void updateHeight(){
        //updating hei[]
        for(int i = 0; i < width; i++){
            for(int j = height - 1; j >= 0; j --){
                if(grid[i][j]) {
                    hei[i] = j + 1;
                    break;
                }
            }
        }
    }
    public void updateheightAndMaxHeight() {
        maxHeight = 0;
        for (int i = 0; i < width; i++) {
            hei[i] = 0;

            for (int j = 0; j <height; j++) {
                if (grid[i][j]) {
                    hei[i] = Math.max(j + 1, hei[i]);
                }
            }
            maxHeight = Math.max(maxHeight, hei[i]);
        }
    }


    /**
     * Returns the max column height present in the board.
     * For an empty board this is 0.
     */
    public int getMaxHeight() {
        return maxHeight; // YOUR CODE HERE
    }
    public void updateMaxHeight() {
        maxHeight = 0;
        for(int i = 0; i < width; i ++) {
            if(hei[i]>maxHeight) maxHeight = hei[i];
        }
    }



    /**
     * Checks the board for internal consistency -- used
     * for debugging.
     */
    public void sanityCheck() {
        if (DEBUG) {
            // YOUR CODE HERE
            int[] wid2 = new int[height];
            int[] hei2 = new int[width];
            int maxHeight2 = 0;
            for (int i = 0; i < height; i ++) {
                wid2[i] = 0;
            }
            for (int i = 0; i < width; i ++) {
                hei2[i] = 0;
            }
            //UPDATING WIDTH IN SANITY
            int temp = 0;
            for(int i = 0; i < height; i ++) {
                temp = 0;
                for(int j = 0; j < width; j ++) {
                    if(grid[j][i]) temp++;
                }
                wid2[i] = temp;
            }
            //UPDATING HEIGHT IN SANITY
            for(int i = 0; i < width; i++){
                for(int j = height - 1; j >= 0; j --){
                    if(grid[i][j]) {
                        hei2[i] = j + 1;
                        break;
                    }
                }
            }
            //UPDATING MAX HEIGHT IN SANITY
            for(int i = 0; i < width; i ++) {
                if(hei2[i]>maxHeight2) maxHeight2 = hei2[i];
            }
            //CHECK EQUAL
            if (!Arrays.equals(wid2,wid)) {
                throw new RuntimeException("width fail");
            }
            if (!Arrays.equals(hei2,hei)) {
                throw new RuntimeException("width fail");
            }
            if (maxHeight2 != maxHeight) {
                throw new RuntimeException("maxHeight fail");
            }


        }
    }

    /**
     * Given a piece and an x, returns the y
     * value where the piece would come to rest
     * if it were dropped straight down at that x.
     *
     * <p>
     * Implementation: use the skirt and the col heights
     * to compute this fast -- O(skirt length).
     */
    public int dropHeight(Piece piece, int x) {
        int maxY = 0;
        for(int i = 0; i < piece.getSkirt().length; i ++) {
            if(hei[i + x] - piece.getSkirt()[i] > maxY) maxY = hei[i + x] - piece.getSkirt()[i];
        }
        return maxY;
    }


    /**
     * Returns the height of the given column --
     * i.e. the y value of the highest block + 1.
     * The height is 0 if the column contains no blocks.
     */
    public int getColumnHeight(int x) {
        return hei[x]; // YOUR CODE HERE
    }


    /**
     * Returns the number of filled blocks in
     * the given row.
     */
    public int getRowWidth(int y) {
        return wid[y]; // YOUR CODE HERE
    }


    /**
     * Returns true if the given block is filled in the board.
     * Blocks outside of the valid width/height area
     * always return true.
     */
    public boolean getGrid(int x, int y) {
        if (x >= width || x < 0 || y >= height || y < 0) return true;
        else return grid[x][y];
    }


    public static final int PLACE_OK = 0;
    public static final int PLACE_ROW_FILLED = 1;
    public static final int PLACE_OUT_BOUNDS = 2;
    public static final int PLACE_BAD = 3;

    /**
     * Attempts to add the body of a piece to the board.
     * Copies the piece blocks into the board grid.
     * Returns PLACE_OK for a regular placement, or PLACE_ROW_FILLED
     * for a regular placement that causes at least one row to be filled.
     *
     * <p>Error cases:
     * A placement may fail in two ways. First, if part of the piece may falls out
     * of bounds of the board, PLACE_OUT_BOUNDS is returned.
     * Or the placement may collide with existing blocks in the grid
     * in which case PLACE_BAD is returned.
     * In both error cases, the board may be left in an invalid
     * state. The client can use undo(), to recover the valid, pre-place state.
     */
    public int place(Piece piece, int x, int y) {
        // flag !committed problem
        if (!committed) throw new RuntimeException("place commit problem");

        int result = PLACE_OK;

        // YOUR CODE HERE

        saveLastBoard();
        TPoint[] points = piece.getBody();
        int newX, newY;
        for (TPoint p : points) {
            newX = p.x + x;
            newY = p.y + y;
            if (newX >= width || newY >= height || newX < 0 || newY < 0) {
                result = PLACE_OUT_BOUNDS;
                return result;
            } else if (grid[newX][newY]) {
                result = PLACE_BAD;
                return result;
            }
            //the legal place for a block is now filled by declaring true
            grid[newX][newY] = true;
            wid[newY]++;
            if (wid[newY] == width) {
                result = PLACE_ROW_FILLED;
            }
            hei[newX] = Math.max(newY + 1, hei[newX]);
            maxHeight = Math.max(maxHeight, hei[newX]);

        }
        sanityCheck();
        committed = false;
        return result;
    }


    /**
     * Deletes rows that are filled all the way across, moving
     * things above down. Returns the number of rows cleared.
     */
    public int clearRows() {
        int rowsCleared = 0;
        // YOUR CODE HERE

        if(committed) {
            saveLastBoard();
            committed =false;
        }
        boolean isRowFilled = true;
        for(int i = 0; i <= getMaxHeight(); i ++) {
            isRowFilled = true;
            for(int j = 0 ; j < width ; j ++) {
                if(!grid[j][i]) {
                    isRowFilled = false;
                    continue;
                }
            }
            if(isRowFilled) {
                rowsCleared++;
                //if row filled then move down all rows
                for (int k = i; k <= getMaxHeight(); k++){
                    for(int l = 0; l < width; l++){
                        grid[l][k] = grid[l][k+1];
                    }
                }
                updateMaxHeight();updateWidth();updateHeight();
                i--;
                /*might there be a break here or something? */
            }
        }
        sanityCheck();
        committed = false;

        sanityCheck();
        return rowsCleared;
    }


    /**
     * Reverts the board to its state before up to one place
     * and one clearRows();
     * If the conditions for undo() are not met, such as
     * calling undo() twice in a row, then the second undo() does nothing.
     * See the overview docs.
     */
    public void undo() {
        // YOUR CODE HERE
        if (!committed) {

            maxHeight = lastMaxHeight;
            System.arraycopy( lastHei,0,hei,0, width);

            System.arraycopy( lastWid,0,wid,0, height);
            for (int i = 0; i < width; i++) {
                System.arraycopy(lastGrid[i], 0, grid[i], 0, height);
            }

            committed =true;
            sanityCheck();
        }
    }


    /**
     * Puts the board in the committed state.
     */
    public void commit() {
        committed = true;
    }


    /*
     Renders the board state as a big String, suitable for printing.
     This is the sort of print-obj-state utility that can help see complex
     state change over time.
     (provided debugging utility)
     */
    public String toString() {
        StringBuilder buff = new StringBuilder();
        for (int y = height - 1; y >= 0; y--) {
            buff.append('|');
            for (int x = 0; x < width; x++) {
                if (getGrid(x, y)) buff.append('+');
                else buff.append(' ');
            }
            buff.append("|\n");
        }
        for (int x = 0; x < width + 2; x++) buff.append('-');
        return (buff.toString());
    }
}


