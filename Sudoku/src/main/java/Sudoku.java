public class Sudoku {
    private static final int size = 9;
    private int[][] grid;
    private SolveAlgo solver;
    private boolean[][] steps;

    Sudoku(int[][] grid) {
        this.grid = grid;
        steps = new boolean[size][size];
        for(int i = 0; i < 9; i++) {
            for( int j = 0; j < 9; j++) {
                if(grid[i][j] == 0) steps[i][j] = false;
                else steps[i][j] = true;
            }
        }
    }

    public void setSolver(SolveAlgo solveAlgo) {
        solver = solveAlgo;
    }
    public int[][] getGrid(){
        return grid;
    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0; j < 9; j ++) {
                str.append(grid[i][j] + " ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    public boolean solve(){
        return solver.solveIt(grid);

    }
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof int[][])) {
            return false;
        }
        int[][] other = (int[][]) obj;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(grid[i][j] != other[i][j]) return false;
            }
        }
        return true;
    }

    public void printSteps() {
        int n = 0;
        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j ++) {
                if(steps[i][j] == false) {
                    n++;
                    steps[i][j] = true;
                    StringBuilder str = new StringBuilder();
                    for(int k = 0 ; k < 9 ; k++) {
                        for(int l = 0; l < 9; l ++) {
                            if(steps[k][l] == false) str.append("0 ");
                            else str.append(grid[k][l] + " ");
                        }
                        str.append("\n");
                    }
                    System.out.println("Step number " + n + " at location " + i + " " + j + " from 0 to " + grid[i][j]);
                    System.out.println(str);
                }
            }
        }

    }
}
