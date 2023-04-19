//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	boolean[][] tetGrid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		tetGrid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int x = tetGrid.length;
		int y = tetGrid[0].length;
		for(int i=0;i<y;i++){
			for(int j=0;j<x;j++){
				if(tetGrid[j][i]==false) break;
				else if(j == x - 1){
					for(int k = i; k <y;k++){
						if(k == y - 1){
							for(int l = 0;l<x;l++){
								tetGrid[l][k] = false;
							}
						}
						else{
							for(int l = 0; l<x;l++){
								tetGrid[l][k] = tetGrid[l][k+1];
							}
						}
					}
					i--;j--;
					break;
				}
			}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return tetGrid; // YOUR CODE HERE
	}
}
