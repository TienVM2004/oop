import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {
    @Test
    public void TestGrid(){
        String grid1 =  "0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 \n" +
                        "0 0 0 0 0 0 0 0 0 \n";
        int[][] grid = new int[][]{
                new int[]{0,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,0,0},

        };
        Sudoku test = null;
        try {
            test = new Sudoku(grid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals( grid1, test.toString());
    }
    @Test
    public void TestSolve(){
        int[][] solution = new int[][]{
                {3,1,6,5,7,8,4,9,2},
                {5,2,9,1,3,4,7,6,8},
                {4,8,7,6,2,9,5,3,1},
                {2,6,3,4,1,5,9,7,8},
                {9,7,4,8,6,3,1,2,5},
                {8,5,1,7,9,2,6,4,3},
                {1,3,8,9,4,7,2,5,6},
                {6,9,2,3,5,1,8,7,4},
                {7,4,5,2,8,6,3,1,9}
        };
        Sudoku test = null;
        try {
            test = new Sudoku(new int[][]{
                    {0,1,6,5,0,8,0,9,0},
                    {0,2,0,0,3,4,0,6,8},
                    {4,0,7,6,0,0,5,3,1},
                    {2,6,3,4,1,0,9,7,8},
                    {9,0,4,0,6,0,1,2,0},
                    {8,0,1,7,0,2,0,4,3},
                    {1,0,8,0,4,7,0,5,6},
                    {0,9,0,3,5,1,8,7,4},
                    {7,0,5,0,8,0,3,1,0}
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Solver1 solver1 = new Solver1();
        test.setSolver(solver1);
        test.solve();
        String output = test.toString();
        System.out.println(test);
        assertTrue(Arrays.deepEquals(test.getGrid(), solution));
    }
    @Test
    public void TestText(){
        int[][] Grid = null;
        try {
            Grid = Sudoku.stringsToGrid(
                    "3 7 0 0 0 0 0 8 0",
                    "0 0 1 0 9 3 0 0 0",
                    "0 4 0 7 8 0 0 0 3",
                    "0 9 3 8 0 0 0 1 2",
                    "0 0 0 0 4 0 0 0 0",
                    "5 2 0 0 0 6 7 9 0",
                    "6 0 0 0 2 1 0 4 0",
                    "0 0 0 5 3 0 9 0 0",
                    "0 3 0 0 0 0 0 5 1");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Sudoku sudoku4;
        try {
            sudoku4 = new Sudoku(Grid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sudoku4.solve();
        System.out.println(sudoku4);
        ////////////////
        int[][] sudokuArray = {
                {3, 7, 0, 0, 0, 0, 0, 8, 0},
                {0, 0, 1, 0, 9, 3, 0, 0, 0},
                {0, 4, 0, 7, 8, 0, 0, 0, 3},
                {0, 9, 3, 8, 0, 0, 0, 1, 2},
                {0, 0, 0, 0, 4, 0, 0, 0, 0},
                {5, 2, 0, 0, 0, 6, 7, 9, 0},
                {6, 0, 0, 0, 2, 1, 0, 4, 0},
                {0, 0, 0, 5, 3, 0, 9, 0, 0},
                {0, 3, 0, 0, 0, 0, 0, 5, 1}
        };
        Sudoku sud;
        try {
            sud = new Sudoku(sudokuArray);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sud.solve();

        assertEquals(sud.toString(), sudoku4.toString());
    }

}