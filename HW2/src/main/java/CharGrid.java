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
		int l = -1, r = -1;
		int max_l = -1, max_r = -1;
		int check = 0;
		for (int i = 0; i < this.grid.length; i++) {
			for (int j = 0; j < this.grid[0].length; j++) {
				if (this.grid[i][j] == ch) {
					check = 1;
					if (l == -1 && r == -1) {
						l = i;
						r = j;
					}
					else {
						max_l = i;
						max_r = j;
					}
				}
			}
		}
		if (check == 0) return 0;
		else if(max_l == -1 && max_r == -1) return 1;
		else return (Math.abs(l - max_l) + 1) * (Math.abs(r - max_r) + 1);
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int dem  = 0;
		for(int i = 1; i < grid.length - 1; i++){
			for(int j = 1; j < grid[0].length - 1; j++){
				if(grid[i][j] == grid[i-1][j] && grid[i][j] == grid[i+1][j] && grid[i][j] == grid[i][j-1]
				&& grid[i][j] == grid[i][j+1]){
					dem += 1;
				}
			}
		}
		return dem;
	}

}
