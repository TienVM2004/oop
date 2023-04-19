public class Solver1 extends SolveAlgo{
    private static final int size = 9;
    @Override
    public boolean solveIt(int[][] grid) {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(grid[i][j] == 0) {
                    for(int k = 1; k <= size; k++) {
                        if(valid(grid, k, j, i)){
                            grid[i][j] = k;
                            if(solveIt(grid)){
                                return true;
                            }
                            else {
                                grid[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        //////////
        return true;
    }
}
