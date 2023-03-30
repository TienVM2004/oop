// Board.java

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

    // my own vars
    private int[] wid;
    private int[] hei;
    private boolean lastGrid[][];


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
        wid = new int[height];
        hei = new int[width];
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


    /**
     * Returns the width of the board in blocks.
     */
    public int getWidth() {
        return width;
    }


    /**
     * Returns the height of the board in blocks.
     */
    public int getHeight() {
        return height;
    }


    /**
     * Returns the max column height present in the board.
     * For an empty board this is 0.
     */
    public int getMaxHeight() {
        int maxHei = 0;
        for(int i = 0; i < width; i ++) {
            if(hei[i]>maxHei) maxHei = hei[i];
        }
        return maxHei; // YOUR CODE HERE
    }


    /**
     * Checks the board for internal consistency -- used
     * for debugging.
     */
    public void sanityCheck() {
        if (DEBUG) {
            // YOUR CODE HERE
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
        return 0; // YOUR CODE HERE
    }


    /**
     * Returns the height of the given column --
     * i.e. the y value of the highest block + 1.
     * The height is 0 if the column contains no blocks.
     */
    public int getColumnHeight(int x) {
        //updateHei();
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
        if(x >= width || x < 0 || y >= height || y < 0) return true;
        else return grid[x][y]; // YOUR CODE HERE
    }

    //my own methods
    public boolean[][] getBoard(){
        return grid;
    }
    public void updateWid() {
        int temp = 0;
        //updating wid[]
        for(int i = 0; i < height; i ++) {
            temp = 0;
            for(int j = 0; j < width; j ++) {
                if(grid[j][i]) temp++;
            }
            //change result if a row is filled
            wid[i] = temp;
        }
    }
    public void updateHei(){
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
    public int[] getWid(){
        return wid;
    }
    public int[] getHei(){
        return hei;
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
        //copy the last grid to be able to undo
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, lastGrid[i], 0, grid[i].length);
        }
        //taking the points out of the piece
        TPoint[] points = piece.getBody();
        int newX, newY, minX = 1000, maxX = 0, minY = 1000, maxY = 0;
        for(TPoint p: points){
            newX = p.x + x;
            if(newX < minX) minX = newX;
            if(newX > maxX) maxX = newX;
            newY = p.y + y;
            if(newY < minY) minY = newY;
            if(newY > maxY) maxY = newY;
            if(newX >= width || newY >= height || newX < 0 || newY < 0) {
                result = PLACE_OUT_BOUNDS;
                return result;
            }
            else if(grid[newX][newY]) {
                result = PLACE_BAD;
                return result;
            }
            else {
                committed = false;
                //the legal place for a block is now filled by declaring true
                grid[newX][newY] = true;
                //update wid[] and hei[], but cant write it's own function
                //since if theres a row filled, we'll have no way to alert this function
                int temp = 0;
                //updating hei[]
                for(int i = minX; i <= maxX; i++){
                    for(int j = height - 1; j >= 0; j --){
                        if(grid[i][j]) {
                            hei[i] = j + 1;
                            break;
                        }
                    }
                }
                //updating wid[]
                for(int i = minY; i <= maxY; i ++) {
                    temp = 0;
                    for(int j = 0; j < width; j ++) {
                        if(grid[j][i]) temp++;
                    }
                    //change result if a row is filled
                    if(temp == width) result = PLACE_ROW_FILLED;
                    wid[i] = temp;
                }
            }

        }

        return result;
    }


    /**
     * Deletes rows that are filled all the way across, moving
     * things above down. Returns the number of rows cleared.
     */
    public int clearRows() {
        int rowsCleared = 0;
        // YOUR CODE HERE
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


