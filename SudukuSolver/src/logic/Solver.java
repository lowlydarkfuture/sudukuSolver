//Michael Hejny
//This program is the logic to solve any provided Suduku puzzle in the format of either 
//just numbers or a 2D array of Tiles.
package logic;

public class Solver {
	private Tile[][] board;

	// newBoard ensures that the input matches the required size
	public boolean newBoard(int[][] board) {
		// This ensures the initial board had been initialized and has enough
		// rows.
		if (board == null || board.length != 9)
			return false;
		// This checks each row to ensure it is initiated and contains enough
		// columns.
		for (int i = 0; i < 9; i++) {
			// If this is true, the board isn't initiated or of the correct
			// size.
			if (board[i] == null || board[i].length != 9) {
				return false;
			}
		}
		// This sets the board and reports it to be a valid size.
		this.board = new Tile[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] < 10 && board[i][j] > 0) {
					this.board[i][j] = new Tile(board[i][j], true);
				} else
					this.board[i][j] = null;
			}
		}
		return true;
	}

	public boolean newBoard(Tile[][] board) {
		if (board == null) {
			this.board = board;
			return false;
		}
		if (board.length != 9)
			return false;
		for (int i = 0; i < 9; i++) {
			if (board[i].length != 9) {
				return false;
			}
		}
		return true;
	}

	public boolean solve() {

		// foundAnswer is used while looking for guaranteed answers. If during
		// the
		// process of looking at all of the positions it finds a certain answer,
		// this is
		// toggled to true. NOTE: it is initially set to true to get into the
		// while loop.
		boolean foundAnswer = true;

		while (foundAnswer) {
			foundAnswer = false;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j] == null) {
						board[i][j] = new Tile(0, false);
						// This for loop enters 1-9 as possible numbers for the
						// squares

						// NOTE: This is not attempting the numbers at this
						// point. It is
						// simply entering them in as all of the possibilities,
						// so that
						// it can remove those that it finds from the
						// possibilities. The
						// more efficient way to do this would be having a list
						// of not
						// possibles but this seems slightly more intuitive for
						// possible
						// troubleshooting.

						for (int k = 1; k < 10; k++) {
							board[i][j].setPossible(k);
						}

						// This goes and removes impossible numbers for the
						// position not
						// setting the number so that it can be kept track of
						// whether we
						// found a valid number or not. If we didn't after
						// making it
						// through all of the rows, we now know we have to start
						// guessing.
						// It is assumed that it is faster looping through all
						// of the
						// positions looking for guaranteed answers than to try
						// and do
						// guesses across the board.

						findPossibleOptions(i, j);

						// if an answer isn't found for the tile, the tile is
						// removed since
						// their guesses aren't maintained by other portions of
						// the program.
						// This is done to remove some of the possible
						// complexities created
						// by leaving it in place. It also makes it easier to
						// find unsolved
						// positions.
						if (!board[i][j].setToOnlyOption()) {
							board[i][j] = null;
							// System.out.println("\nThe program could not find an answer for\nposition "
							// + i + " " + j);
						}

						// It found an answer, so other positions might be
						// solvable without
						// guessing.
						else {
							// System.out.println("The program found an answer at i: "
							// + i + " j: " + j + ". The answer is " +
							// board[i][j].getValue());
							foundAnswer = true;
						}
					}
				}
			}
		}
		return true;//guess(0, 0);
	}

	private boolean guess(int row, int col) {
		// TODO
		System.out.println("I'm in Guess(). Looking at " + row + ", " + col);
		// if it is the lower right corner...
		if (row == 8 && col == 8) {
			// if it hasn't been answered
			if (board[row][col] == null || board[row][col].getValue() == 0) {
				board[row][col] = new Tile(0, false);
				this.findPossibleOptions(row, col);
				// there should only be one possible option because all other
				// squares have
				// been filled in. If it fails, there was an incorrect number
				// guessed.
				if (board[row][col].setToOnlyOption())
					return true;
				// an incorrect number was guessed if it got here.
				else
					return false;
			}
			// the puzzle should be solved if it got here. If something goes
			// wrong, it
			// will return false.
			else if (board[row][col].getSolved())
				return true;
			// this is a short circuit. If it gets here, something went wrong.
			else
				System.err
						.println("Somehow the program got to Solver line 156, which should be unreachable.");
			return false;
		}
		// if it is at the end of a row...
		if (col == 8) {
			// if not solved
			if (board[row][col] == null || board[row][col].getValue() == 0) {
				this.findPossibleOptions(row, col);
				int[] toTry = board[row][col].returnPossibles();
				for (int i = 0; i < 9; i++) {
					if (toTry[i] != 0) {
						board[row][col].setPossible(i + 1);
						if (guess(row + 1, 0))
							return true;
					}
				}
			}
			// if it is already solved
			return guess(row + 1, 0);
		}

		// if it isn't at the end of the board, or end of the row...
		// TODO
		else {
			// if it isn't solved...
			if (board[row][col] == null || board[row][col].getValue() == 0) {
				board[row][col] = new Tile(0, false);
				this.findPossibleOptions(row, col);
				int[] toTry = board[row][col].returnPossibles();
				for (int i = 0; i < 9; i++) {
					System.out.println("toTry[i] where i = " + i + " returns " + toTry[i]);
					if (toTry[i] != 0) {
						board[row][col].setPossible(i + 1);
						if (guess(row, col + 1))
							return true;
					}
				}
				return false;
			}
			// if it is already solved, go to the next square.
			return guess(row, col + 1);
		}
	}

	private void findPossibleOptions(int i, int j) {
		// if the position provided doesn't contain a tile, it creates one there
		if (board[i][j] == null)
			board[i][j] = new Tile(0, false);
		
		// sets all of the possible options at the given spot.
		for (int k = 0; k < 9; k++ ){
			board[i][j].setPossible(k);
		}
		// Checks the contents of the columns it's in.
		for (int k = 0; k < 9; k++) {
			if (board[k][j] != null && k != i) {
				switch (board[k][j].getValue()) {
				case 1:
					board[i][j].setPossible(-1);
					break;
				case 2:
					board[i][j].setPossible(-2);
					break;
				case 3:
					board[i][j].setPossible(-3);
					break;
				case 4:
					board[i][j].setPossible(-4);
					break;
				case 5:
					board[i][j].setPossible(-5);
					break;
				case 6:
					board[i][j].setPossible(-6);
					break;
				case 7:
					board[i][j].setPossible(-7);
					break;
				case 8:
					board[i][j].setPossible(-8);
					break;
				case 9:
					board[i][j].setPossible(-9);
					break;
				default:
					System.out
							.println("If this line is ever gotten to, somehow there there wasn't a\n"
									+ "possible value for there to be at a position. This will likely\n"
									+ "show up while trying possibilities if the computer runs out of\n"
									+ "sure bets.");
				}
			}
		}

		// Checks the contents of the row it's in.
		for (int k = 0; k < 9; k++) {
			if (board[i][k] != null && k != j) {
				switch (board[i][k].getValue()) {
				case 1:
					board[i][j].setPossible(-1);
					break;
				case 2:
					board[i][j].setPossible(-2);
					break;
				case 3:
					board[i][j].setPossible(-3);
					break;
				case 4:
					board[i][j].setPossible(-4);
					break;
				case 5:
					board[i][j].setPossible(-5);
					break;
				case 6:
					board[i][j].setPossible(-6);
					break;
				case 7:
					board[i][j].setPossible(-7);
					break;
				case 8:
					board[i][j].setPossible(-8);
					break;
				case 9:
					board[i][j].setPossible(-9);
					break;
				default:
					System.out
							.println("If this line is ever gotten to, somehow there there wasn't a\n"
									+ "possible value for there to be at a position. This will likely\n"
									+ "show up while trying possibilities if the computer runs out of\n"
									+ "sure bets.");
					return;
				}
			}
		}

		// This checks within the sub-square for numbers.

		int row, col; // These are used to hold the starting location within the
						// square(upper left corner)

		// this is looking to find the correct row to look at
		if (i < 3 && i > -1)
			row = 0;
		else if (i > 2 && i < 6)
			row = 3;
		else if (i > 5 && i < 9)
			row = 6;
		else {
			System.out
					.println("There is an error detected at Solver -> findPossibleOptions() looking\nat the subsquare rows.");
			row = -999999;
		}
		// this is looking to find the correct column to look at
		if (j < 3 && j > -1)
			col = 0;
		else if (j > 2 && j < 6)
			col = 3;
		else if (j > 5 && j < 9)
			col = 6;
		else {
			System.out
					.println("There is an error detected at Solver -> findPossibleOptions() looking\nat the subsquare columns.");
			col = -99999;
		}
		for (int k = 0; k < 3; k++) {
			// this is used to look at each row in the sub-square.
			for (int L = 0; L < 3; L++) {
				// this is used to look at the individual items in each column
				// in the sub-square.

				if (!(i == row + k && j == col + L)
						&& board[row + k][col + L] != null) {
					switch (board[k + row][L + col].getValue()) {
					case 1:
						board[i][j].setPossible(-1);
						break;
					case 2:
						board[i][j].setPossible(-2);
						break;
					case 3:
						board[i][j].setPossible(-3);
						break;
					case 4:
						board[i][j].setPossible(-4);
						break;
					case 5:
						board[i][j].setPossible(-5);
						break;
					case 6:
						board[i][j].setPossible(-6);
						break;
					case 7:
						board[i][j].setPossible(-7);
						break;
					case 8:
						board[i][j].setPossible(-8);
						break;
					case 9:
						board[i][j].setPossible(-9);
						break;
					default:
						System.out
								.println("If this line is ever gotten to, somehow there there wasn't a\n"
										+ "possible value for there to be at a position. This will likely\n"
										+ "show up while trying possibilities if the computer runs out of\n"
										+ "sure bets. This one is in the part looking at the sub-squares.\n"
										+ "The interesting bits... board[k + i/3][L + j/3].getValue() returns "
										+ board[k + i / 3][L + j / 3]
												.getValue());

					}
				}

			}
		}

	}

	public void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != null) {
					System.out.print(board[i][j].getValue() + " ");
				} else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	// This returns a copy of the board to the requester.
	public Tile[][] returnBoard() {
		return board.clone();
	}
}
