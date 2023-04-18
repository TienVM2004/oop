public abstract class SolveAlgo {
    public boolean isInRow(int[][] grid, int num, int row) {
        for(int i = 0; i < 9; i++) {
            if(grid[row][i] == num) return true;
        }
        return false;
    }
    public boolean isInCol(int[][] grid, int num, int col) {
        for(int i = 0; i < 9; i++) {
            if(grid[i][col] == num) return true;
        }
        return false;
    }
    public boolean isIn3x3(int[][] grid, int num, int col, int row) {
        int rowNum = row - row % 3;
        int colNum = col - col % 3;
        for(int i = rowNum; i < rowNum + 3; i++) {
            for(int j = colNum; j < colNum + 3; j++) {
                if(grid[i][j] == num) return true;
            }
        }
        return false;
    }
    public boolean valid(int[][] grid, int num, int col, int row) {
        return !isInCol(grid, num, col) && !isInRow(grid, num, row) && !isIn3x3(grid, num, col, row);
    }
    public abstract boolean solveIt(int[][] grid);


}
