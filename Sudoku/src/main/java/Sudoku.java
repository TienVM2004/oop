public class Sudoku {
    private static final int size = 9;
    private int[][] grid;
    private SolveAlgo solver;
    private boolean[][] steps;

    public int getSize(){
        return size;
    }

    Sudoku(int[][] grid) throws Exception {
        if(grid.length != size || grid[0].length != size) {
            throw new Exception("that table wont suffice my man");
        }
        this.grid = grid;
        steps = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for( int j = 0; j < size; j++) {
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
        for(int i = 0 ; i < size ; i++) {
            for(int j = 0; j < size; j ++) {
                str.append(grid[i][j]).append(" ");
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
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(grid[i][j] != other[i][j]) return false;
            }
        }
        return true;
    }

    public void printSteps() {
        int n = 0;
        for(int i = 0; i < size; i ++) {
            for(int j = 0; j < size; j ++) {
                if(!steps[i][j]) {
                    n++;
                    steps[i][j] = true;
                    StringBuilder str = new StringBuilder();
                    for(int k = 0 ; k < 9 ; k++) {
                        for(int l = 0; l < 9; l ++) {
                            if(!steps[k][l]) str.append("0 ");
                            else str.append(grid[k][l]).append(" ");
                        }
                        str.append("\n");
                    }
                    System.out.println("Step number " + n + " at location " + i + " " + j + " from 0 to " + grid[i][j]);
                    System.out.println(str);
                }
            }
        }

    }
    public static int[][] stringsToGrid(String... rows) throws Exception {
        int len = rows.length;
        int[][] res = new int[len][];


        for (int i = 0; i < len; i ++) {
            res[i] = stringToInts(rows[i]);
        }

        return res;
    }
    public static int[] stringToInts(String str) throws Exception {
        int len = str.length();
        int n = 0;
        int[] arr = new int[len];

        for (int i = 0; i < len; i ++) {
            if (Character.isDigit(str.charAt(i))) {
                arr[n] = Integer.parseInt(str.substring(i, i+1));

                n++;
            }
            else {
                throw new Exception("Found something not an integer in sudoku bruh");
            }
        }

        return arr;
    }
}
