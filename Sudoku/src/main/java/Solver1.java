public class Solver1 extends SolveAlgo{
    private static int num = 0;
    @Override
    public boolean solveIt(int[][] grid) {
//        num++;
//        System.out.println("Initiating solve "+ num);

        /////////
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(grid[i][j] == 0) {
                    for(int k = 1; k <= 9; k++) {
                        if(valid(grid, k, j, i)){
                            grid[i][j] = k;
//                            //////////
//                            StringBuilder str = new StringBuilder();
//                            for(int l = 0 ; l < 9 ; l++) {
//                                for(int o = 0; o < 9; o ++) {
//                                    str.append(grid[l][o] + " ");
//                                }
//                                str.append("\n");
//                            }
//                            System.out.println(str);
//
//                            //////////
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
