package testMethods;

import static org.junit.Assert.*;
import logic.*;

import org.junit.Test;

//TODO: NOTE: at most test methods, there is a local boolean that can be changed for more troubleshooting info.

public class TestCases {
	@Test
	// This checks to ensure a correctly sized board can be inserted.
	public void checkInsert(){
		boolean troubleshoot = false;
		if (troubleshoot)
			System.out.println(   "This is in TestCases->checkInsert.\n"
							+ "This checks to make sure that the\n"
							+ "insert is working correctly. The\n"
							+ "left column is 1's, the next column\n"
							+ "is 2's and so on until the value\n"
							+ "gets to 9.\n");
		Solver solver = new Solver();
		int[][] sampleBoard = new int[9][9];
		assertTrue(solver.newBoard(sampleBoard));
		// This inserts items into the array.
		for ( int i = 0; i < 9; i++){
			for ( int j = 0; j < 9; j++ ){
				sampleBoard[i][j] = j+1;
			}
		}
		assertTrue(solver.newBoard(sampleBoard));
		if (troubleshoot)
			solver.print();
	}
	@Test
	public void checkBadInsert(){
		Solver solver = new Solver();
		int[][] sampleBoard = null;
		assertFalse(solver.newBoard(sampleBoard));
		sampleBoard = new int[9][8];
		assertFalse(solver.newBoard(sampleBoard));
		sampleBoard = new int[9][10];
		assertFalse(solver.newBoard(sampleBoard));
		sampleBoard = new int[1][8];
		assertFalse(solver.newBoard(sampleBoard));
		Tile[][] otherBoard = null;
		assertFalse(solver.newBoard(otherBoard));
		otherBoard = new Tile[9][8];
		assertFalse(solver.newBoard(otherBoard));
		otherBoard = new Tile[9][9];
		assertTrue(solver.newBoard(otherBoard));
		}
	@Test
	public void checkInsertedBoard(){
		boolean troubleshoot = false;
		Solver solver = new Solver();
		int[][] sampleBoard = new int[9][9];
		assertTrue(solver.newBoard(sampleBoard));
		// This inserts items into an array that will be used for inserting values into the board.
		for ( int i = 0; i < 9; i++){
			for ( int j = 0; j < 9; j++ ){
				sampleBoard[i][j] = j + i;
			}
		}
		if (troubleshoot)
			System.out.print("This is located in TestCases->checkInsertedBoard.\n"
						   + "At this point, an array of ints has been generated\n"
						   + "and is about to be inserted. These values are\n"
						   + "not always between 1 and 9.\n\n");
		solver.newBoard(sampleBoard);
		if (troubleshoot){
			System.out.println("At this point, sampleBoard has read the values in\n"
							 + "the array. This is what it got out of it...\n");
			solver.print();
			System.out.println();
		}
		
		//Checks first row.
				assertTrue(solver.returnBoard()[0][0] == null);
				assertTrue(solver.returnBoard()[0][1].getValue() == 1);
				assertTrue(solver.returnBoard()[0][2].getValue() == 2);
				
				assertTrue(solver.returnBoard()[0][3].getValue() == 3);
				assertTrue(solver.returnBoard()[0][4].getValue() == 4);
				assertTrue(solver.returnBoard()[0][5].getValue() == 5);
				
				assertTrue(solver.returnBoard()[0][6].getValue() == 6);
				assertTrue(solver.returnBoard()[0][7].getValue() == 7);
				assertTrue(solver.returnBoard()[0][8].getValue() == 8);
				
				//Checks second row
				assertTrue(solver.returnBoard()[1][0].getValue() == 1);
				assertTrue(solver.returnBoard()[1][1].getValue() == 2);
				assertTrue(solver.returnBoard()[1][2].getValue() == 3);
				
				assertTrue(solver.returnBoard()[1][3].getValue() == 4);
				assertTrue(solver.returnBoard()[1][4].getValue() == 5);
				assertTrue(solver.returnBoard()[1][5].getValue() == 6);
				
				assertTrue(solver.returnBoard()[1][6].getValue() == 7);
				assertTrue(solver.returnBoard()[1][7].getValue() == 8);
				assertTrue(solver.returnBoard()[1][8].getValue() == 9);
				
				// Checks row 3.
				assertTrue(solver.returnBoard()[2][0].getValue() == 2);
				assertTrue(solver.returnBoard()[2][1].getValue() == 3);
				assertTrue(solver.returnBoard()[2][2].getValue() == 4);
				
				assertTrue(solver.returnBoard()[2][3].getValue() == 5);
				assertTrue(solver.returnBoard()[2][4].getValue() == 6);
				assertTrue(solver.returnBoard()[2][5].getValue() == 7);
				
				assertTrue(solver.returnBoard()[2][6].getValue() == 8);
				assertTrue(solver.returnBoard()[2][7].getValue() == 9);
				assertTrue(solver.returnBoard()[2][8] == null); //any of these that are supposed to be null were out of range values.

				// Checks row 4.
				assertTrue(solver.returnBoard()[3][0].getValue() == 3);
				assertTrue(solver.returnBoard()[3][1].getValue() == 4);
				assertTrue(solver.returnBoard()[3][2].getValue() == 5);
				
				assertTrue(solver.returnBoard()[3][3].getValue() == 6);
				assertTrue(solver.returnBoard()[3][4].getValue() == 7);
				assertTrue(solver.returnBoard()[3][5].getValue() == 8);
				
				assertTrue(solver.returnBoard()[3][6].getValue() == 9);
				assertTrue(solver.returnBoard()[3][7] == null);
				assertTrue(solver.returnBoard()[3][8] == null);

				// Checks row 5.
				assertTrue(solver.returnBoard()[4][0].getValue() == 4);
				assertTrue(solver.returnBoard()[4][1].getValue() == 5);
				assertTrue(solver.returnBoard()[4][2].getValue() == 6);
				
				assertTrue(solver.returnBoard()[4][3].getValue() == 7);
				assertTrue(solver.returnBoard()[4][4].getValue() == 8);
				assertTrue(solver.returnBoard()[4][5].getValue() == 9);
				
				assertTrue(solver.returnBoard()[4][6] == null);
				assertTrue(solver.returnBoard()[4][7] == null);
				assertTrue(solver.returnBoard()[4][8] == null);

				// Checks row 6.
				assertTrue(solver.returnBoard()[5][0].getValue() == 5);
				assertTrue(solver.returnBoard()[5][1].getValue() == 6);
				assertTrue(solver.returnBoard()[5][2].getValue() == 7);
				
				assertTrue(solver.returnBoard()[5][3].getValue() == 8);
				assertTrue(solver.returnBoard()[5][4].getValue() == 9);
				assertTrue(solver.returnBoard()[5][5] == null);
				
				assertTrue(solver.returnBoard()[5][6] == null);
				assertTrue(solver.returnBoard()[5][7] == null);
				assertTrue(solver.returnBoard()[5][8] == null);

				// Checks row 7.
				assertTrue(solver.returnBoard()[6][0].getValue() == 6);
				assertTrue(solver.returnBoard()[6][1].getValue() == 7);
				assertTrue(solver.returnBoard()[6][2].getValue() == 8);
				
				assertTrue(solver.returnBoard()[6][3].getValue() == 9);
				assertTrue(solver.returnBoard()[6][4] == null);
				assertTrue(solver.returnBoard()[6][5] == null);
				
				assertTrue(solver.returnBoard()[6][6] == null);
				assertTrue(solver.returnBoard()[6][7] == null);
				assertTrue(solver.returnBoard()[6][8] == null);

				// Checks row 8.
				assertTrue(solver.returnBoard()[7][0].getValue() == 7);
				assertTrue(solver.returnBoard()[7][1].getValue() == 8);
				assertTrue(solver.returnBoard()[7][2].getValue() == 9);
				
				assertTrue(solver.returnBoard()[7][3] == null);
				assertTrue(solver.returnBoard()[7][4] == null);
				assertTrue(solver.returnBoard()[7][5] == null);
				
				assertTrue(solver.returnBoard()[7][6] == null);
				assertTrue(solver.returnBoard()[7][7] == null);
				assertTrue(solver.returnBoard()[7][8] == null);

				// Checks row 9.
				assertTrue(solver.returnBoard()[8][0].getValue() == 8);
				assertTrue(solver.returnBoard()[8][1].getValue() == 9);
				assertTrue(solver.returnBoard()[8][2] == null);
				
				assertTrue(solver.returnBoard()[8][3] == null);
				assertTrue(solver.returnBoard()[8][4] == null);
				assertTrue(solver.returnBoard()[8][5] == null);
				
				assertTrue(solver.returnBoard()[8][6] == null);
				assertTrue(solver.returnBoard()[8][7] == null);
				assertTrue(solver.returnBoard()[8][8] == null);
	}
	
	@Test
	public void checkLogicFirstRow(){
		boolean troubleshoot = false;
		Solver solver = new Solver();
		int[][] sampleBoard = new int[9][9];
		assertTrue(solver.newBoard(sampleBoard));
		sampleBoard = new int[][]{
					   {9,2,8,7,0,4,3,6,5},
		               {1,5,7,2,3,6,8,9,4},
		               {3,6,4,9,5,8,1,7,2},
		               {8,3,6,5,4,9,7,2,1},
		               {7,1,2,8,6,3,4,5,9},
		               {4,9,5,1,2,7,6,8,3},
		               {6,8,3,4,9,2,5,1,7},
		               {5,4,9,6,7,1,2,3,8},
		               {2,7,1,3,8,5,9,4,6}};
		// The zero on the board is supposed to represent an empty position. It's
		// actual value is 1.
		if (troubleshoot)
			System.out.println( "This is in TestCases->checkLogicFirstRow.\n" + 
								"Here is a puzzle with only one position\nneeding to be filled in.\n");
		assertTrue(solver.newBoard(sampleBoard));
		assertTrue(solver.returnBoard()[0][4] == null);
		if (troubleshoot)
			solver.print();
		assertTrue(solver.solve());
		if (troubleshoot){
			System.out.println("The puzzle should be solved now.\n");
			solver.print();
		}
		assertTrue(solver.returnBoard()[0][4].getValue() == 1);
	}
	
	@Test
	public void checkLogicTwoRows(){
		boolean troubleshoot = false;
		Solver solver = new Solver();
		int[][] sampleBoard = new int[9][9];
		assertTrue(solver.newBoard(sampleBoard));
		sampleBoard = new int[][]{
					   {9,2,8,7,0,4,3,6,5},
		               {1,5,7,2,3,6,8,9,4},
		               {3,6,4,9,5,8,1,7,2},
		               {8,3,6,5,4,9,7,2,1},
		               {7,1,2,8,6,3,4,5,9},
		               {4,9,5,1,2,7,6,8,3},
		               {6,8,3,4,9,2,5,1,7},
		               {5,4,9,6,7,1,2,3,8},
		               {2,7,1,3,8,5,9,4,0}};
		// The zero on the top is supposed to be 1. the zero on the bottom row is a 6.
		if (troubleshoot)
			System.out.println( "This is in TestCases->checkLogicTwoRows.\n" + 
								"Here is a puzzle with only two positions\nneeding to be filled in.\n");
		assertTrue(solver.newBoard(sampleBoard));
		assertTrue(solver.returnBoard()[0][4] == null);
		assertTrue(solver.returnBoard()[8][8] == null);
		if (troubleshoot)
			solver.print();
		assertTrue(solver.solve());
		if (troubleshoot){
			System.out.println("The puzzle should be solved now.\n");
			solver.print();
		}
		assertTrue(solver.returnBoard()[0][4].getValue() == 1);
		assertTrue(solver.returnBoard()[8][8].getValue() == 6);
	}
	
	@Test
	public void checkSolveUsingVerticle(){
		boolean troubleshoot = false;
		Solver solver = new Solver();
		int[][] sampleBoard = new int[9][9];
		assertTrue(solver.newBoard(sampleBoard));
		sampleBoard = new int[][]{
					   {9,2,8,7,0,0,3,6,5},//{9,2,8,7,1,4,3,6,5}
		               {1,5,7,2,3,6,8,9,4},
		               {3,6,4,9,5,8,1,7,2},
		               {8,3,6,5,4,9,7,2,1},
		               {7,1,2,8,6,3,4,5,9},
		               {4,9,5,1,2,7,6,8,3},
		               {6,8,3,4,9,2,5,1,7},
		               {5,4,9,6,7,1,2,3,8},
		               {0,0,0,0,8,5,0,0,0}};//{2,7,1,3,8,5,9,4,6}
		if (troubleshoot){
			System.out.println( "This is in TestCases->checkSolveUsingVerticle.\n" + 
								"Here is a puzzle with only four positions\nneeding to be filled in.\n");
			}
		assertTrue(solver.newBoard(sampleBoard));
		if (troubleshoot)
			solver.print();
		assertTrue(solver.returnBoard()[0][4] == null);
		assertTrue(solver.returnBoard()[0][5] == null);
		assertTrue(solver.returnBoard()[8][8] == null);
		assertTrue(solver.returnBoard()[8][7] == null);
		assertTrue(solver.returnBoard()[8][6] == null);
		assertTrue(solver.returnBoard()[8][3] == null);
		assertTrue(solver.returnBoard()[8][2] == null);
		assertTrue(solver.returnBoard()[8][1] == null);
		assertTrue(solver.returnBoard()[8][0] == null);
		assertTrue(solver.solve());
		if (troubleshoot){
			System.out.println("The puzzle should be solved now.\n");
			solver.print();
		}
		assertTrue(solver.returnBoard()[0][4].getValue() == 1);
		assertTrue(solver.returnBoard()[0][5].getValue() == 4);
		assertTrue(solver.returnBoard()[8][0].getValue() == 2);
		assertTrue(solver.returnBoard()[8][1].getValue() == 7);
		assertTrue(solver.returnBoard()[8][2].getValue() == 1);
		assertTrue(solver.returnBoard()[8][3].getValue() == 3);
		assertTrue(solver.returnBoard()[8][6].getValue() == 9);
		assertTrue(solver.returnBoard()[8][7].getValue() == 4);
		assertTrue(solver.returnBoard()[8][8].getValue() == 6);
	}
	
	@Test
	public void testSolveUsingHorizontal(){
		boolean troubleshoot = false;
		Solver solver = new Solver();
		int[][] sampleBoard = new int[9][9];
		assertTrue(solver.newBoard(sampleBoard));
		sampleBoard = new int[][]{
					   {0,2,8,7,1,4,3,6,5},//{9,2,8,7,1,4,3,6,5}
		               {0,5,7,2,3,6,8,9,4},//{1,5,7,2,3,6,8,9,4}
		               {0,6,4,9,5,8,1,7,2},//{3,6,4,9,5,8,1,7,2}
		               {0,3,6,5,4,9,7,2,1},//{8,3,6,5,4,9,7,2,1}
		               {0,1,2,8,6,3,4,5,9},//{7,1,2,8,6,3,4,5,9}
		               {0,9,5,1,2,7,6,8,3},//{4,9,5,1,2,7,6,8,3}
		               {0,8,3,4,9,2,5,1,7},//{6,8,3,4,9,2,5,1,7}
		               {0,4,9,6,7,1,2,3,8},//{5,4,9,6,7,1,2,3,8}
		               {0,7,1,3,8,5,9,4,6}};//{2,7,1,3,8,5,9,4,6}
		if (troubleshoot){
			System.out.println( "This is in TestCases->testSolveUsingHorizontal.\n" + 
								"Here is a puzzle needing the leading position\nfilled in for all of the rows.\n");
			}
		assertTrue(solver.newBoard(sampleBoard));
		if (troubleshoot)
			solver.print();
		assertTrue(solver.returnBoard()[0][0] == null);
		assertTrue(solver.returnBoard()[1][0] == null);
		assertTrue(solver.returnBoard()[2][0] == null);
		assertTrue(solver.returnBoard()[3][0] == null);
		assertTrue(solver.returnBoard()[4][0] == null);
		assertTrue(solver.returnBoard()[5][0] == null);
		assertTrue(solver.returnBoard()[6][0] == null);
		assertTrue(solver.returnBoard()[7][0] == null);
		assertTrue(solver.returnBoard()[8][0] == null);
		assertTrue(solver.solve());
		assertTrue(solver.returnBoard()[0][0].getValue() == 9);
		assertTrue(solver.returnBoard()[1][0].getValue() == 1);
		assertTrue(solver.returnBoard()[2][0].getValue() == 3);
		assertTrue(solver.returnBoard()[3][0].getValue() == 8);
		assertTrue(solver.returnBoard()[4][0].getValue() == 7);
		assertTrue(solver.returnBoard()[5][0].getValue() == 4);
		assertTrue(solver.returnBoard()[6][0].getValue() == 6);
		assertTrue(solver.returnBoard()[7][0].getValue() == 5);
		assertTrue(solver.returnBoard()[8][0].getValue() == 2);
		if (troubleshoot){
			System.out.println("\nThe board should now be solved.\n");
			solver.print();
			System.out.println("\n");
		}
	}

	@Test
	public void testSolveUsingSquare(){
		boolean troubleshoot = false;
		Solver solver = new Solver();
		int[][] sampleBoard = new int[9][9];
		assertTrue(solver.newBoard(sampleBoard));
		sampleBoard = new int[][]{
					   {0,2,8,7,1,4,3,6,0},//{9,2,8,7,1,4,3,6,5}
		               {1,5,7,2,3,6,8,9,4},//{1,5,7,2,3,6,8,9,4}
		               {3,6,4,9,5,8,1,7,2},//{3,6,4,9,5,8,1,7,2}
		               {8,3,6,5,4,9,7,2,1},//{8,3,6,5,4,9,7,2,1}
		               {7,1,2,8,6,3,4,5,9},//{7,1,2,8,6,3,4,5,9}
		               {4,9,5,1,2,7,6,8,3},//{4,9,5,1,2,7,6,8,3}
		               {6,8,3,4,9,2,5,1,7},//{6,8,3,4,9,2,5,1,7}
		               {5,4,9,6,7,1,2,3,8},//{5,4,9,6,7,1,2,3,8}
		               {0,7,1,3,8,5,9,4,0}};//{2,7,1,3,8,5,9,4,6}
		if (troubleshoot){
			System.out.println( "This is in TestCases->testSolveUsingSquare.\n" + 
								"Here is a puzzle needing the four corners solved.\n");
			}
		assertTrue(solver.newBoard(sampleBoard));
		if (troubleshoot)
			solver.print();
		assertTrue(solver.returnBoard()[0][0] == null);
		assertTrue(solver.returnBoard()[8][0] == null);
		assertTrue(solver.returnBoard()[0][8] == null);
		assertTrue(solver.returnBoard()[8][8] == null);
		assertTrue(solver.solve());
		if (troubleshoot){
			System.out.println("\nThe puzzle should now be solved.\n");
			solver.print();
			System.out.println();
		}
		assertTrue(solver.returnBoard()[0][0].getValue() == 9);
		assertTrue(solver.returnBoard()[8][0].getValue() == 2);
		assertTrue(solver.returnBoard()[0][8].getValue() == 5);
		assertTrue(solver.returnBoard()[8][8].getValue() == 6);
	}
	
	@Test
	public void testExpertPuzzleSolve(){
		boolean troubleshoot = true;
		Solver solver = new Solver();
		int[][] sampleBoard = new int[9][9];
		assertTrue(solver.newBoard(sampleBoard));
		sampleBoard = new int[][]{
				   {0,0,1,0,0,4,0,8,0},//{6,2,1,9,3,4,7,8,5}
	               {0,0,7,0,6,0,0,4,9},//{3,8,7,5,6,1,2,4,9}
	               {0,5,0,0,0,0,1,6,0},//{9,5,4,7,8,2,1,6,3}
	               {4,0,0,0,0,6,5,7,0},//{4,3,9,2,1,6,5,7,8}
	               {1,0,0,0,9,0,0,0,2},//{1,6,5,8,9,7,4,3,2}
	               {0,0,8,0,0,5,0,0,0},//{2,7,8,3,4,5,6,9,1}
	               {0,0,0,0,0,0,8,0,7},//{5,9,6,4,2,3,8,1,7}
	               {0,4,0,0,0,0,0,0,0},//{8,4,2,1,7,9,3,5,6}
	               {0,0,0,0,0,8,9,0,0}};//{7,1,3,6,5,8,9,2,4}
		if (troubleshoot){
			System.out.println( "This is in TestCases->testExpertPuzzleSolve.\n" + 
								"Here is a puzzle needing the countless positions\nfilled in for all of the rows.\n");
			}
		assertTrue(solver.newBoard(sampleBoard));
		if (troubleshoot)
			solver.print();
		solver.solve();
		if (troubleshoot){
			System.out.println("\nThe puzzle should be solved now.\n");
			solver.print();
		}
		assertTrue(solver.returnBoard()[0][0].getValue() == 6);
		assertTrue(solver.returnBoard()[0][1].getValue() == 2);
		assertTrue(solver.returnBoard()[0][2].getValue() == 1);
		assertTrue(solver.returnBoard()[0][3].getValue() == 9);
		assertTrue(solver.returnBoard()[0][4].getValue() == 3);
		assertTrue(solver.returnBoard()[0][5].getValue() == 4);
		assertTrue(solver.returnBoard()[0][6].getValue() == 7);
		assertTrue(solver.returnBoard()[0][7].getValue() == 8);
		assertTrue(solver.returnBoard()[0][8].getValue() == 5);
		
		assertTrue(solver.returnBoard()[1][0].getValue() == 3);
		assertTrue(solver.returnBoard()[1][1].getValue() == 8);
		assertTrue(solver.returnBoard()[1][2].getValue() == 7);
		assertTrue(solver.returnBoard()[1][3].getValue() == 5);
		assertTrue(solver.returnBoard()[1][4].getValue() == 6);
		assertTrue(solver.returnBoard()[1][5].getValue() == 1);
		assertTrue(solver.returnBoard()[1][6].getValue() == 2);
		assertTrue(solver.returnBoard()[1][7].getValue() == 4);
		assertTrue(solver.returnBoard()[1][8].getValue() == 9);
		
		assertTrue(solver.returnBoard()[2][0].getValue() == 9);
		assertTrue(solver.returnBoard()[2][1].getValue() == 5);
		assertTrue(solver.returnBoard()[2][2].getValue() == 4);
		assertTrue(solver.returnBoard()[2][3].getValue() == 7);
		assertTrue(solver.returnBoard()[2][4].getValue() == 8);
		assertTrue(solver.returnBoard()[2][5].getValue() == 2);
		assertTrue(solver.returnBoard()[2][6].getValue() == 1);
		assertTrue(solver.returnBoard()[2][7].getValue() == 6);
		assertTrue(solver.returnBoard()[2][8].getValue() == 3);
		
		assertTrue(solver.returnBoard()[3][0].getValue() == 4);
		assertTrue(solver.returnBoard()[3][1].getValue() == 3);
		assertTrue(solver.returnBoard()[3][2].getValue() == 9);
		assertTrue(solver.returnBoard()[3][3].getValue() == 2);
		assertTrue(solver.returnBoard()[3][4].getValue() == 1);
		assertTrue(solver.returnBoard()[3][5].getValue() == 6);
		assertTrue(solver.returnBoard()[3][6].getValue() == 5);
		assertTrue(solver.returnBoard()[3][7].getValue() == 7);
		assertTrue(solver.returnBoard()[3][8].getValue() == 8);
		
		assertTrue(solver.returnBoard()[4][0].getValue() == 1);
		assertTrue(solver.returnBoard()[4][1].getValue() == 6);
		assertTrue(solver.returnBoard()[4][2].getValue() == 5);
		assertTrue(solver.returnBoard()[4][3].getValue() == 8);
		assertTrue(solver.returnBoard()[4][4].getValue() == 9);
		assertTrue(solver.returnBoard()[4][5].getValue() == 7);
		assertTrue(solver.returnBoard()[4][6].getValue() == 4);
		assertTrue(solver.returnBoard()[4][7].getValue() == 3);
		assertTrue(solver.returnBoard()[4][8].getValue() == 2);
		
		assertTrue(solver.returnBoard()[5][0].getValue() == 2);
		assertTrue(solver.returnBoard()[5][1].getValue() == 7);
		assertTrue(solver.returnBoard()[5][2].getValue() == 8);
		assertTrue(solver.returnBoard()[5][3].getValue() == 3);
		assertTrue(solver.returnBoard()[5][4].getValue() == 4);
		assertTrue(solver.returnBoard()[5][5].getValue() == 5);
		assertTrue(solver.returnBoard()[5][6].getValue() == 6);
		assertTrue(solver.returnBoard()[5][7].getValue() == 9);
		assertTrue(solver.returnBoard()[5][8].getValue() == 1);
		
		assertTrue(solver.returnBoard()[6][0].getValue() == 5);
		assertTrue(solver.returnBoard()[6][1].getValue() == 9);
		assertTrue(solver.returnBoard()[6][2].getValue() == 6);
		assertTrue(solver.returnBoard()[6][3].getValue() == 4);
		assertTrue(solver.returnBoard()[6][4].getValue() == 2);
		assertTrue(solver.returnBoard()[6][5].getValue() == 3);
		assertTrue(solver.returnBoard()[6][6].getValue() == 8);
		assertTrue(solver.returnBoard()[6][7].getValue() == 1);
		assertTrue(solver.returnBoard()[6][8].getValue() == 7);
		
		assertTrue(solver.returnBoard()[7][0].getValue() == 8);
		assertTrue(solver.returnBoard()[7][1].getValue() == 4);
		assertTrue(solver.returnBoard()[7][2].getValue() == 2);
		assertTrue(solver.returnBoard()[7][3].getValue() == 1);
		assertTrue(solver.returnBoard()[7][4].getValue() == 7);
		assertTrue(solver.returnBoard()[7][5].getValue() == 9);
		assertTrue(solver.returnBoard()[7][6].getValue() == 3);
		assertTrue(solver.returnBoard()[7][7].getValue() == 5);
		assertTrue(solver.returnBoard()[7][8].getValue() == 6);
		
		assertTrue(solver.returnBoard()[8][0].getValue() == 7);
		assertTrue(solver.returnBoard()[8][1].getValue() == 1);
		assertTrue(solver.returnBoard()[8][2].getValue() == 3);
		assertTrue(solver.returnBoard()[8][3].getValue() == 6);
		assertTrue(solver.returnBoard()[8][4].getValue() == 5);
		assertTrue(solver.returnBoard()[8][5].getValue() == 8);
		assertTrue(solver.returnBoard()[8][6].getValue() == 9);
		assertTrue(solver.returnBoard()[8][7].getValue() == 2);
		assertTrue(solver.returnBoard()[8][8].getValue() == 4);
		
	}
	
	@Test
	public void testExpertPuzzleSolve2(){
		boolean troubleshoot = false;
		Solver solver = new Solver();
		int[][] sampleBoard = new int[9][9];
		assertTrue(solver.newBoard(sampleBoard));
		sampleBoard = new int[][]{
				   {3,0,7,9,0,0,0,1,0},//{3,4,7,9,5,2,6,1,8}
	               {0,0,6,0,8,0,0,0,0},//{5,9,6,1,8,3,2,7,4}
	               {2,0,0,0,4,6,0,0,0},//{2,1,8,7,4,6,9,5,3}
	               {1,0,0,0,0,0,0,0,0},//{1,5,3,6,2,7,4,8,9}
	               {0,8,0,4,0,9,3,0,0},//{7,8,2,4,1,9,3,6,5}
	               {0,0,9,8,0,0,0,2,0},//{4,6,9,8,3,5,7,2,1}
	               {0,3,0,0,0,0,0,4,0},//{9,3,5,2,7,8,1,4,6}
	               {8,0,1,3,0,0,0,9,7},//{8,2,1,3,6,4,5,9,7}
	               {0,0,0,0,0,1,0,0,0}};//{6,7,4,5,9,1,8,3,2}
		if (troubleshoot){
			System.out.println( "This is in TestCases->testExpertPuzzleSolve2.\n" + 
								"Here is a puzzle needing the countless positions\nfilled in for all of the rows.\n");
			}
		assertTrue(solver.newBoard(sampleBoard));
		if (troubleshoot)
			solver.print();
		solver.solve();
		if (troubleshoot){
			System.out.println("\nThe puzzle should be solved now.\n");
			solver.print();
		}
		assertTrue(solver.returnBoard()[0][0].getValue() == 3);
		assertEquals(solver.returnBoard()[0][1].getValue() , 4);
		assertTrue(solver.returnBoard()[0][2].getValue() == 7);
		assertTrue(solver.returnBoard()[0][3].getValue() == 9);
		assertTrue(solver.returnBoard()[0][4].getValue() == 5);
		assertTrue(solver.returnBoard()[0][5].getValue() == 2);
		assertTrue(solver.returnBoard()[0][6].getValue() == 6);
		assertTrue(solver.returnBoard()[0][7].getValue() == 1);
		assertTrue(solver.returnBoard()[0][8].getValue() == 8);
		
		assertTrue(solver.returnBoard()[1][0].getValue() == 5);
		assertTrue(solver.returnBoard()[1][1].getValue() == 9);
		assertTrue(solver.returnBoard()[1][2].getValue() == 6);
		assertTrue(solver.returnBoard()[1][3].getValue() == 1);
		assertTrue(solver.returnBoard()[1][4].getValue() == 8);
		assertTrue(solver.returnBoard()[1][5].getValue() == 3);
		assertTrue(solver.returnBoard()[1][6].getValue() == 2);
		assertTrue(solver.returnBoard()[1][7].getValue() == 7);
		assertTrue(solver.returnBoard()[1][8].getValue() == 4);
		
		assertTrue(solver.returnBoard()[2][0].getValue() == 2);
		assertTrue(solver.returnBoard()[2][1].getValue() == 1);
		assertTrue(solver.returnBoard()[2][2].getValue() == 8);
		assertTrue(solver.returnBoard()[2][3].getValue() == 7);
		assertTrue(solver.returnBoard()[2][4].getValue() == 4);
		assertTrue(solver.returnBoard()[2][5].getValue() == 6);
		assertTrue(solver.returnBoard()[2][6].getValue() == 9);
		assertTrue(solver.returnBoard()[2][7].getValue() == 5);
		assertTrue(solver.returnBoard()[2][8].getValue() == 3);
		
		assertTrue(solver.returnBoard()[3][0].getValue() == 1);
		assertTrue(solver.returnBoard()[3][1].getValue() == 5);
		assertTrue(solver.returnBoard()[3][2].getValue() == 3);
		assertTrue(solver.returnBoard()[3][3].getValue() == 6);
		assertTrue(solver.returnBoard()[3][4].getValue() == 2);
		assertTrue(solver.returnBoard()[3][5].getValue() == 7);
		assertTrue(solver.returnBoard()[3][6].getValue() == 4);
		assertTrue(solver.returnBoard()[3][7].getValue() == 8);
		assertTrue(solver.returnBoard()[3][8].getValue() == 9);
		
		assertTrue(solver.returnBoard()[4][0].getValue() == 7);
		assertTrue(solver.returnBoard()[4][1].getValue() == 8);
		assertTrue(solver.returnBoard()[4][2].getValue() == 2);
		assertTrue(solver.returnBoard()[4][3].getValue() == 4);
		assertTrue(solver.returnBoard()[4][4].getValue() == 1);
		assertTrue(solver.returnBoard()[4][5].getValue() == 9);
		assertTrue(solver.returnBoard()[4][6].getValue() == 3);
		assertTrue(solver.returnBoard()[4][7].getValue() == 6);
		assertTrue(solver.returnBoard()[4][8].getValue() == 5);
		
		assertTrue(solver.returnBoard()[5][0].getValue() == 4);
		assertTrue(solver.returnBoard()[5][1].getValue() == 6);
		assertTrue(solver.returnBoard()[5][2].getValue() == 9);
		assertTrue(solver.returnBoard()[5][3].getValue() == 8);
		assertTrue(solver.returnBoard()[5][4].getValue() == 3);
		assertTrue(solver.returnBoard()[5][5].getValue() == 5);
		assertTrue(solver.returnBoard()[5][6].getValue() == 7);
		assertTrue(solver.returnBoard()[5][7].getValue() == 2);
		assertTrue(solver.returnBoard()[5][8].getValue() == 1);
		
		assertTrue(solver.returnBoard()[6][0].getValue() == 9);
		assertTrue(solver.returnBoard()[6][1].getValue() == 3);
		assertTrue(solver.returnBoard()[6][2].getValue() == 5);
		assertTrue(solver.returnBoard()[6][3].getValue() == 2);
		assertTrue(solver.returnBoard()[6][4].getValue() == 7);
		assertTrue(solver.returnBoard()[6][5].getValue() == 8);
		assertTrue(solver.returnBoard()[6][6].getValue() == 1);
		assertTrue(solver.returnBoard()[6][7].getValue() == 4);
		assertTrue(solver.returnBoard()[6][8].getValue() == 6);
		
		assertTrue(solver.returnBoard()[7][0].getValue() == 8);
		assertTrue(solver.returnBoard()[7][1].getValue() == 2);
		assertTrue(solver.returnBoard()[7][2].getValue() == 1);
		assertTrue(solver.returnBoard()[7][3].getValue() == 3);
		assertTrue(solver.returnBoard()[7][4].getValue() == 6);
		assertTrue(solver.returnBoard()[7][5].getValue() == 4);
		assertTrue(solver.returnBoard()[7][6].getValue() == 5);
		assertTrue(solver.returnBoard()[7][7].getValue() == 9);
		assertTrue(solver.returnBoard()[7][8].getValue() == 7);
		
		assertTrue(solver.returnBoard()[8][0].getValue() == 6);
		assertTrue(solver.returnBoard()[8][1].getValue() == 7);
		assertTrue(solver.returnBoard()[8][2].getValue() == 4);
		assertTrue(solver.returnBoard()[8][3].getValue() == 5);
		assertTrue(solver.returnBoard()[8][4].getValue() == 9);
		assertTrue(solver.returnBoard()[8][5].getValue() == 1);
		assertTrue(solver.returnBoard()[8][6].getValue() == 8);
		assertTrue(solver.returnBoard()[8][7].getValue() == 3);
		assertTrue(solver.returnBoard()[8][8].getValue() == 2);
		
	}
	
	@Test
	public void testMediumPuzzleSolve(){
		boolean troubleshoot = true;
		Solver solver = new Solver();
		int[][] sampleBoard = new int[9][9];
		assertTrue(solver.newBoard(sampleBoard));
		sampleBoard = new int[][]{
				   {4,0,0,0,7,0,1,0,0},//{4,6,2,5,7,8,1,3,9}
	               {0,8,0,1,0,2,0,0,0},//{7,8,9,1,3,2,4,6,5}
	               {0,5,1,0,0,0,0,2,0},//{3,5,1,9,6,4,8,2,7}
	               {0,0,0,0,0,0,0,0,3},//{6,2,5,4,8,1,7,9,3}
	               {0,0,0,6,5,3,2,0,4},//{8,9,7,6,5,3,2,1,4}
	               {0,0,0,0,2,0,6,5,0},//{1,3,4,7,2,9,6,5,8}
	               {9,0,3,2,0,0,0,8,0},//{9,1,3,2,4,7,5,8,6}
	               {0,0,8,0,1,6,9,0,2},//{5,4,8,3,1,6,9,7,2}
	               {2,7,0,0,0,5,3,0,1}};//{2,7,6,8,9,5,3,4,1}
		if (troubleshoot){
			System.out.println( "This is in TestCases->testMediumPuzzleSolve.\n" + 
								"Here is a puzzle needing the countless positions\nfilled in for all of the rows.\n");
			}
		assertTrue(solver.newBoard(sampleBoard));
		if (troubleshoot)
			solver.print();
		solver.solve();
		if (troubleshoot){
			System.out.println("\nThe puzzle should be solved now.\n");
			solver.print();
		}
		assertTrue(solver.returnBoard()[0][0].getValue() == 4);
		assertTrue(solver.returnBoard()[0][1].getValue() == 6);
		assertTrue(solver.returnBoard()[0][2].getValue() == 2);
		assertTrue(solver.returnBoard()[0][3].getValue() == 5);
		assertTrue(solver.returnBoard()[0][4].getValue() == 7);
		assertTrue(solver.returnBoard()[0][5].getValue() == 8);
		assertTrue(solver.returnBoard()[0][6].getValue() == 1);
		assertTrue(solver.returnBoard()[0][7].getValue() == 3);
		assertTrue(solver.returnBoard()[0][8].getValue() == 9);
		
		assertTrue(solver.returnBoard()[1][0].getValue() == 7);
		assertTrue(solver.returnBoard()[1][1].getValue() == 8);
		assertTrue(solver.returnBoard()[1][2].getValue() == 9);
		assertTrue(solver.returnBoard()[1][3].getValue() == 1);
		assertTrue(solver.returnBoard()[1][4].getValue() == 3);
		assertTrue(solver.returnBoard()[1][5].getValue() == 2);
		assertTrue(solver.returnBoard()[1][6].getValue() == 4);
		assertTrue(solver.returnBoard()[1][7].getValue() == 6);
		assertTrue(solver.returnBoard()[1][8].getValue() == 5);
		
		assertTrue(solver.returnBoard()[2][0].getValue() == 3);
		assertTrue(solver.returnBoard()[2][1].getValue() == 5);
		assertTrue(solver.returnBoard()[2][2].getValue() == 1);
		assertTrue(solver.returnBoard()[2][3].getValue() == 9);
		assertTrue(solver.returnBoard()[2][4].getValue() == 6);
		assertTrue(solver.returnBoard()[2][5].getValue() == 4);
		assertTrue(solver.returnBoard()[2][6].getValue() == 8);
		assertTrue(solver.returnBoard()[2][7].getValue() == 2);
		assertTrue(solver.returnBoard()[2][8].getValue() == 7);
		
		assertTrue(solver.returnBoard()[3][0].getValue() == 6);
		assertTrue(solver.returnBoard()[3][1].getValue() == 2);
		assertTrue(solver.returnBoard()[3][2].getValue() == 5);
		assertTrue(solver.returnBoard()[3][3].getValue() == 4);
		assertTrue(solver.returnBoard()[3][4].getValue() == 8);
		assertTrue(solver.returnBoard()[3][5].getValue() == 1);
		assertTrue(solver.returnBoard()[3][6].getValue() == 7);
		assertTrue(solver.returnBoard()[3][7].getValue() == 9);
		assertTrue(solver.returnBoard()[3][8].getValue() == 3);
		
		assertTrue(solver.returnBoard()[4][0].getValue() == 8);
		assertTrue(solver.returnBoard()[4][1].getValue() == 9);
		assertTrue(solver.returnBoard()[4][2].getValue() == 7);
		assertTrue(solver.returnBoard()[4][3].getValue() == 6);
		assertTrue(solver.returnBoard()[4][4].getValue() == 5);
		assertTrue(solver.returnBoard()[4][5].getValue() == 3);
		assertTrue(solver.returnBoard()[4][6].getValue() == 2);
		assertTrue(solver.returnBoard()[4][7].getValue() == 1);
		assertTrue(solver.returnBoard()[4][8].getValue() == 4);
		
		assertTrue(solver.returnBoard()[5][0].getValue() == 1);
		assertTrue(solver.returnBoard()[5][1].getValue() == 3);
		assertTrue(solver.returnBoard()[5][2].getValue() == 4);
		assertTrue(solver.returnBoard()[5][3].getValue() == 7);
		assertTrue(solver.returnBoard()[5][4].getValue() == 2);
		assertTrue(solver.returnBoard()[5][5].getValue() == 9);
		assertTrue(solver.returnBoard()[5][6].getValue() == 6);
		assertTrue(solver.returnBoard()[5][7].getValue() == 5);
		assertTrue(solver.returnBoard()[5][8].getValue() == 8);
		
		assertTrue(solver.returnBoard()[6][0].getValue() == 9);
		assertTrue(solver.returnBoard()[6][1].getValue() == 1);
		assertTrue(solver.returnBoard()[6][2].getValue() == 3);
		assertTrue(solver.returnBoard()[6][3].getValue() == 2);
		assertTrue(solver.returnBoard()[6][4].getValue() == 4);
		assertTrue(solver.returnBoard()[6][5].getValue() == 7);
		assertTrue(solver.returnBoard()[6][6].getValue() == 5);
		assertTrue(solver.returnBoard()[6][7].getValue() == 8);
		assertTrue(solver.returnBoard()[6][8].getValue() == 6);
		
		assertTrue(solver.returnBoard()[7][0].getValue() == 5);
		assertTrue(solver.returnBoard()[7][1].getValue() == 4);
		assertTrue(solver.returnBoard()[7][2].getValue() == 8);
		assertTrue(solver.returnBoard()[7][3].getValue() == 3);
		assertTrue(solver.returnBoard()[7][4].getValue() == 1);
		assertTrue(solver.returnBoard()[7][5].getValue() == 6);
		assertTrue(solver.returnBoard()[7][6].getValue() == 9);
		assertTrue(solver.returnBoard()[7][7].getValue() == 7);
		assertTrue(solver.returnBoard()[7][8].getValue() == 2);
		
		assertTrue(solver.returnBoard()[8][0].getValue() == 2);
		assertTrue(solver.returnBoard()[8][1].getValue() == 7);
		assertTrue(solver.returnBoard()[8][2].getValue() == 6);
		assertTrue(solver.returnBoard()[8][3].getValue() == 8);
		assertTrue(solver.returnBoard()[8][4].getValue() == 9);
		assertTrue(solver.returnBoard()[8][5].getValue() == 5);
		assertTrue(solver.returnBoard()[8][6].getValue() == 3);
		assertTrue(solver.returnBoard()[8][7].getValue() == 4);
		assertTrue(solver.returnBoard()[8][8].getValue() == 1);
		
	}
}