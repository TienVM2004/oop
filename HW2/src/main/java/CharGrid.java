// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {

		this.grid = grid;
	}

	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int max = 0;
		int rows = grid.length;
		int cols = grid[0].length;
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(grid[i][j]==ch){
					for(int k=i;k<rows;k++){
						for(int l=j;l<cols;l++){
							if(grid[k][l]==ch){
								if((k+1-i)*(l+1-j)>max){
									max = (k+1-i)*(l+1-j);
								}
							}
						}
					}
				}
			}
		}
		return max; // YOUR CODE HERE
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int mini(int a, int b, int c, int d){
		if(a<=b&&a<=c&&a<=d) return a;
		else if (b<=a&&b<=c&&b<=d) return b;
		else if (c<=b&&c<=a&&c<=d) return c;
		else return d;
	}
	public int thereIsPlus(char x, int i, int j){
		int rows = grid.length;
		int cols = grid[0].length;
		int top= 0, left=0,right=0, bot=0;
		for(int a = i;a<rows;a++){
			if(grid[a][j]!=x) {bot = a - i;break;}
			else if (a==rows-1) {bot = a - i+1;break;}
		}
		for(int a = i;a>=0;a--){
			if(grid[a][j]!=x) {top = i-a;break;}
			else if (a==0) {top = i-a+1;break;}
		}
		for(int a = j;a>=0;a--){
			if(grid[i][a]!=x) {left = j-a;break;}
			else if (a==0) {left = j-a+1;break;}
		}
		for(int a = j;a<cols;a++){
			if(grid[i][a]!=x) {right = a - j; break;}
			else if (a==cols-1) {right = a - j+1;break;}
		}

		int min = mini(right,left,top,bot);

		if( (top>=2)&&(bot>=2)&&(right>=2)&&(left>=2)) return min-1;
		else return 0;
	}
	public int countPlus() {
		int rows = grid.length;
		int cols = grid[0].length;
		int pluses = 0;
		for(int i=1;i<rows-1;i++) {
			for (int j = 1; j < cols-1; j++) {
				if(grid[i][j]!=' '){

					if(thereIsPlus(grid[i][j],i,j)!=0){
						pluses+=thereIsPlus(grid[i][j],i,j);
					}
				}
			}
		}

		return pluses; // YOUR CODE HERE
	}

}
