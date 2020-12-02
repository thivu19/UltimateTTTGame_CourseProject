package courseproject;

/* Name: Thi Vu
 * Class: CS 2336.002
 * */

import java.util.Scanner;

/* Analysis:
 * The program reads in the user inputs that selects the board value and 
 * the square value. It also checks to make sure the values are valid.
 * 
 * Design:
 * - The selectBoardValue method return a valid input for the board value
 * - The selectSquareValue method return a valid input for the square value
 * - The isNumeric method checks if the value is a integer if valid return true
 * */

public class HumanPlayer extends Player{
	Scanner input = new Scanner(System.in);
	
	public HumanPlayer(String name, String mark) {
		super(name, mark);
	}

	// Return a valid board value
	@Override
	public int selectBoardValue(int range) {
		boolean validInput = false;
		String value = "";
		int board = 0;
		do {
			System.out.print("Please select a valid board: ");
			value = input.nextLine();
			// Checks if the value is a number
			if(isNumeric(value)) {
				board = Integer.parseInt(value);
				// Checks if the value is in range 
				if(board >= 0 && board < range)
					validInput = true;
			}	
		}while(!validInput);

		System.out.println("Selected board : " + board);
		
		return board;
	}
	
	// Return a valid square value on the selected board
	@Override
	public int selectSquareValue(int range) {
		boolean validInput = false;
		String value = "";
		int square = 0;
		do {
			System.out.print("Please select a valid square on the selected board: ");
			value = input.nextLine();
			// Checks if the value is a number
			if(isNumeric(value)) {
				square = Integer.parseInt(value);
				// Checks if the value is in range 
				if(square >= 0 && square < range)
					validInput = true;
			}
		}while(!validInput);
		
		System.out.println("Selected square : " + square);
		
		return square;
	}
	
	// Check if value is a integer
	public static boolean isNumeric(String value)
	{
		try {
			Integer.parseInt(value);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
