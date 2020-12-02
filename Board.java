/* Name: Thi Vu
 * Class: CS 2336.002
 * */

package courseproject;

/* Analysis:
 * The program set the boxes so that the board could be played 
 * in UltimateTTTGame class. Also, has method that can access 
 * the winner value of this board.
 * 
 * Design:
 * - Set the board size and board number 
 * - Initialize board boxes from 0-8
 * - The print method prints certain rows depending on the value inputed
 * - The makeMove method set a certain box value with a new mark and return 
 * true if move is valid
 * - The isFull method checks if the boxes in the board is full and return true if it is
 * - The getMark method get the mark with the certain box value and return that mark
 * - The winner method return the board winning value
 * - The setWinner method set winning value for this board and replace the remaining open space with *
 * - The getWinner method return the mark of the winner for this board
 * - The printWinner method print the winner mark of this board
 * */
public class Board {
	
	private Box[] boxes;
	private int boardNum;
	private int square;
	private boolean win = false;
	private String winnerMark = "";
	
	Board(int square, int boardNum) {
		this.setBoardNum(boardNum);
		this.setSize(square);
	}

	// Set the size of the board
	public void setSize(int square) {
		this.square = square;
		init();
	}

	// Set the board number
	private void setBoardNum(int number) {
		this.boardNum = number;
	}
	
	// Initialize the boxes
	private void init() {
		boxes = new Box[square];
		for(int i = 0; i < boxes.length; i++) {
			Box b = new Box(Integer.toString(i));
			boxes[i] = b;
		}
	}

	// Print the board
	public void print(int row) {
		if(row == 0) { // Print square 0 - 2
			for(int i = 0; i < boxes.length-6; i++) {
				if(i%3 == 0)
					System.out.print("\tBOARD#" + boardNum + " | ");
				boxes[i].print();
			}
		}else if(row == 1) { // Print square 3 - 5
			for(int i = 3; i < boxes.length-3; i++) {
				if(i%3 == 0)
					System.out.print("\tBOARD#" + boardNum + " | ");
				boxes[i].print();
			}
		}else if(row == 2) { // Print square 6 - 8
			for(int i = 6; i < boxes.length; i++) {
				if(i%3 == 0)
					System.out.print("\tBOARD#" + boardNum + " | ");
				boxes[i].print();
			}
		}
	}

	// Check to see if the move is valid 
	public boolean makeMove(String mark, int square) {
		return boxes[square].setPlaceHolder(mark);
	}
	
	// Check if the boxes are full
	public boolean isFull() {
		for(Box b : boxes)
			if(b.isAvailable()) return false;
		return true;
	}
	
	// Get the mark in the box
	public String getMark(int square) {
		return boxes[square].getPlaceHolder();
	}
	
	// Return the board winning value
	public boolean winner() {
		return this.win;
	}
	
	// Set winner for this board
	public void setWinner(String mark) {
		if(!winner()) {
			this.winnerMark = mark;
			this.win = true;
			for(Box b : boxes)
				if(b.isAvailable())
					b.setPlaceHolder("*");
		}
	}
	
	// Get the mark for this board
	public String getWinner() {
		return this.winnerMark;
	}
	
	// Print the winner mark for this board
	public void printWinner() {
		System.out.println("The Board#" + boardNum + " winner is " + this.winnerMark);
	}
}
