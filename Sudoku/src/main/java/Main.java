public class Main {
    public static void main(String[] args) {
        int[][] easyGrid = new int[][]{
                {1, 6, 4, 0, 0, 0, 0, 0, 2},
                {2, 0, 0, 4, 0, 3, 9, 1, 0},
                {0, 0, 5, 0, 8, 0, 4, 0, 7},
                {0, 9, 0, 0, 0, 6, 5, 0, 0},
                {5, 0, 0, 1, 0, 2, 0, 0, 8},
                {0, 0, 8, 9, 0, 0, 0, 3, 0},
                {8, 0, 9, 0, 4, 0, 2, 0, 0},
                {0, 7, 3, 5, 0, 9, 0, 0, 1},
                {4, 0, 0, 0, 0, 0, 6, 7, 9}
        };
        Sudoku sudoku = null;
        try {
            sudoku = new Sudoku(easyGrid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sudoku.setSolver(new Solver1());
        sudoku.solve();
        sudoku.printSteps();
        System.out.println("Final result: ");
        System.out.println(sudoku.toString());

        ////////////////////

        int[][] grid = new int[][]{
                {0,0,0,2,6,0,7,0,1},
                {6,8,0,0,7,0,0,9,0},
                {1,9,0,0,0,4,5,0,0},
                {8,2,0,1,0,0,0,4,0},
                {0,0,4,6,0,2,9,0,0},
                {0,5,0,0,0,3,0,2,8},
                {0,0,9,3,0,0,0,7,4},
                {0,4,0,0,5,0,0,3,6},
                {7,0,3,0,1,8,0,0,0}
        };
        Sudoku sudoku2 = null;
        try {
            sudoku2 = new Sudoku(grid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sudoku2.setSolver(new Solver1());
        sudoku2.solve();
        sudoku2.printSteps();
        System.out.println("Final result: ");
        System.out.println(sudoku2.toString());
        ////////////////////

        int[][] grid2 = new int[][]{
                {0,2,0,0,0,0,0,0,0},
                {0,0,0,6,0,0,0,0,3},
                {0,7,4,0,8,0,0,0,0},
                {0,0,0,0,0,3,0,0,2},
                {0,8,0,0,4,0,0,1,0},
                {6,0,0,5,0,0,0,0,0},
                {0,0,0,0,1,0,7,8,0},
                {5,0,0,0,0,9,0,0,0},
                {0,0,0,0,0,0,0,4,0}
        };
        Sudoku sudoku3 = null;
        try {
            sudoku3 = new Sudoku(grid2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sudoku3.setSolver(new Solver1());
        sudoku3.solve();
        sudoku3.printSteps();
        System.out.println("Final result: ");
        System.out.println(sudoku3.toString());

    }
}
