/* Name: Thi Vu
 * Class: CS 2336.002
 * */

package courseproject;

/* Analysis:
 * The program generates random number that select the board and
 * square value for the game
 * 
 * Design:
 * - The randomNumber method generates a random number within the 
 * certain range
 * - The selectBoardValue method return a valid random number for the board value
 * - The selectSquareValue method return a valid random number for the square value
 * */

public class ComputerPlayer extends Player {
	
	public ComputerPlayer(String name, String mark) {
		super(name, mark);
	}
	
	// Generate random number with the range
	private int randomNumber(int range) {
		return (int) (Math.random() * range);
	}

	// Return a random valid board value
	@Override
	public int selectBoardValue(int range) {
		int board = 0;
		do {
			System.out.print("Please select a valid board: \n");
			board = randomNumber(range);
		}while(!(board >= 0 && board < range));
		
		return board;
	}

	// Return a random valid square value
	@Override
	public int selectSquareValue(int range) {
		int square = 0;
		do {
			System.out.print("Please select a valid square on the selected board: \n");
			square = randomNumber(range);
		}while(!(square >= 0 && square < range));
		
		System.out.println("Selected square : " + square);
		
		return square;
	}
}
