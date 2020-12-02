/* Name: Thi Vu
 * Class: CS 2336.002
 * */

package courseproject;

/* Analysis:
 * The program set the players and the boards so that the
 * game of Ultimate Tic-Tac-Toe could be played by computer players or human player.
 * 
 * Design:
 * - Set the players and the boards from Board and Player class
 * 1 - Start the game message and display the boards
 * 2 - Select the current player index
 * 3 - Player should select a board in the beginning and a square on the board to place the mark
 * 4 - Board should check if the box is available and if so place the mark otherwise repeat the process
 * 5 - Then print the board and the winners on certain board
 * 6 - Repeat the steps for the other player until one player win or boards is full or all boards has a winner  
 * - The printBoard method print each row of the first row of the board then once all the rows are printed
 * would go to the next row of boards to print the reset of the board.
 * - The printWinner method prints all the winners for each board won 
 * */

public class UltimateTTTGame {
	private Player[] players = new Player[2];
	private Board[] board = new Board[9];
	
	private int gameSquareSize = 9;
	private int gameScoreToWin = 3;
	
	private int currentPlayerIndex = -1;
	private int currentBoard = -1;
	private int squareValue = -1;
	
	public UltimateTTTGame() {
		setBoard();
	}
	
	// Initialize 9 board for the big TTTGame
	private void setBoard() {
		for(int i = 0; i < gameSquareSize; i++) {
			Board b = new Board(gameSquareSize, i);
			board[i] = b;
		}
	}

	// Initialize 2 players
	public void setPlayers(Player player1, Player player2) {
		players[0] = player1;
		players[1] = player2;
	}
	
	// Print 9 board
	private void printBoards() {
		int counterBlock = 0;		// Count the number of row of board has been printed
		int counter = 0;			// Count the number of time the row is printed for each board
		int row = 0;				// Which row to print
		for(int i = 0; i <= board.length; i++) {
			// Go to next row
			if(i!=0 && i%3==0) {
				System.out.println();

				row++;
				counter++;
				if(counter != 3) {
					if(counterBlock == 0)
						i = 0;
					else if(counterBlock == 1)
						i = 3;
					else if(counterBlock == 2)
						i = 6;
				}else {
					// Go to the next block
					System.out.println();
					counter = 0;
					row = 0;
					counterBlock++;
				}
			}
			// If it print all 3 block of the board then break
			if(counterBlock == 3) break;
			board[i].print(row);
			
		}
	}
	
	// Print the winner in each board
	private void printWinner() {
		for(int i = 0; i < board.length; i++) {
			if(board[i].winner()) 
				board[i].printWinner();
		}
	}
	
	// Start the Ultimate Tic-Tac-Toe game
	public void start() {
		System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");
		System.out.print("\nThis type of Tic-Tac-Toe Game is the same as the original. Now instead of just winning the main"
				+ "\nboard, you also need to win each of the smaller boards first "
				+ "until you have a line of three.\n\nNew Rule:\nYou can only place a mark on the board determined by the position of your\r\n" + 
				"opponent’s last placed mark. So, if they put an X or O in the top right corner\r\n" + 
				"of a square, your next move must occur in the top right board.\n"
				+ "\n======================================================\n\n");
		do {
			printBoards();
			printWinner();
			switchPlayer();
			System.out.println("\nCurrent Player is: " + players[this.currentPlayerIndex].getMark());
			selectBoard();
			// While player move is valid
			while(!board[currentBoard].makeMove(players[this.currentPlayerIndex].getMark(), 
					squareValue = players[this.currentPlayerIndex].selectSquareValue(gameSquareSize))); 
			// Check to see if the current board has winner
			boardWinner();
			currentBoard = squareValue;
		}while(!gameOver()); 
	}

	// Switch the current player with the next player
	private void switchPlayer() {
		if(this.currentPlayerIndex == 0) {
			this.currentPlayerIndex = 1;
		}else this.currentPlayerIndex = 0;
	}
	
	// Select a different board if the current board is full or it is just starting
	private boolean selectBoard() {
		if(currentBoard == -1 || board[currentBoard].isFull()) {
			// Check to make sure the board value is valid
			do {
				currentBoard = players[this.currentPlayerIndex].selectBoardValue(gameSquareSize);
			}while(board[currentBoard].isFull());
			return true;
		}else {
			System.out.println("Selected board : " + currentBoard);
		}
		return false;
	}
		
	// Game over if there is a tie or there is a winner 
	private boolean gameOver() {
		// Call isWinner to check if there is a winner for the game
		if(isWinner()) {
			printBoards();
			printWinner();
			System.out.println("\nGame winner is : " + players[this.currentPlayerIndex].getMark());
			return true;
		// It's a tie whenever all board has a winner
		}else if(board[0].winner()&& board[1].winner()&&board[2].winner()&&board[3].winner()&&board[4].winner()&&
				board[5].winner()&&board[6].winner() &&board[7].winner() &&board[8].winner()) { 
			printBoards();
			printWinner();
			System.out.println("\nGame winner is : T");
			return true;
		// It's a tie whenever all board is full 	
		}else if(board[0].isFull()&& board[1].isFull()&&board[2].isFull()&&board[3].isFull()&&board[4].isFull()&&
				board[5].isFull()&&board[6].isFull() &&board[7].isFull() &&board[8].isFull()) {
			printBoards();
			printWinner();
			System.out.println("\nGame winner is : T");
			return true;
		}
		return false;
	}
	
	// Check the row, column, diagonal for winner of the whole game
	private boolean isWinner() {
		if(checkRow() || checkCol() || checkDiagRL() || checkDiagLR()) return true;
		return false;
	}

	// Check the rows of the boards
	private boolean checkRow() {
		int count = 0;
		for(int i = 0; i < gameSquareSize; i++) {
			if(board[i].getWinner() == players[this.currentPlayerIndex].getMark())
				count++;
			if(count == gameScoreToWin) return true;
			if(i==2 || i==5) count = 0;
		}
		return false;
	}
	
	// Check the columns of the boards
	private boolean checkCol() {
		if(board[0].getWinner() == players[this.currentPlayerIndex].getMark() && 
				board[3].getWinner() == players[this.currentPlayerIndex].getMark() && 
				board[6].getWinner() == players[this.currentPlayerIndex].getMark()) return true;
		else if(board[1].getWinner() == players[this.currentPlayerIndex].getMark() && 
				board[4].getWinner() == players[this.currentPlayerIndex].getMark() && 
				board[7].getWinner() == players[this.currentPlayerIndex].getMark()) return true;
		else if(board[2].getWinner() == players[this.currentPlayerIndex].getMark() && 
				board[5].getWinner() == players[this.currentPlayerIndex].getMark() && 
			    board[8].getWinner() == players[this.currentPlayerIndex].getMark()) return true;
		return false;
	}

	// Check the bottom right board to the top left board
	private boolean checkDiagRL() {
		if(board[0].getWinner() == players[this.currentPlayerIndex].getMark() && 
				board[4].getWinner() == players[this.currentPlayerIndex].getMark() && 
				board[8].getWinner() == players[this.currentPlayerIndex].getMark()) return true;
		return false;
	}
	
	// Check the bottom left board to the top right board
	private boolean checkDiagLR() {
		if(board[2].getWinner() == players[this.currentPlayerIndex].getMark() && 
				board[4].getWinner() == players[this.currentPlayerIndex].getMark() && 
				board[6].getWinner() == players[this.currentPlayerIndex].getMark()) return true;
		return false;
	}
	
	/***Check the current board for winner***/
	private void boardWinner() {
		if(checkSRow() || checkSCol() || checkSDiagRL() || checkSDiagLR()) {
			board[currentBoard].setWinner(players[this.currentPlayerIndex].getMark());
		}
	}

	// Check the rows of the current board
	private boolean checkSRow() {
		int count = 0;
		for(int i = 0; i < gameSquareSize; i++) {
			if(board[currentBoard].getMark(i) == players[this.currentPlayerIndex].getMark())
				count++;
			if(count == gameScoreToWin) return true;
			if(i==2 || i==5) count = 0;
		}
		return false;
	}
	// Check the column of the current board
	private boolean checkSCol() {
		if(board[currentBoard].getMark(0) == players[this.currentPlayerIndex].getMark() &&
				board[currentBoard].getMark(3) == players[this.currentPlayerIndex].getMark() &&
				board[currentBoard].getMark(6) == players[this.currentPlayerIndex].getMark()) return true;
		else if(board[currentBoard].getMark(1) == players[this.currentPlayerIndex].getMark() &&
				board[currentBoard].getMark(4) == players[this.currentPlayerIndex].getMark() &&
				board[currentBoard].getMark(7) == players[this.currentPlayerIndex].getMark()) return true;
		else if(board[currentBoard].getMark(2) == players[this.currentPlayerIndex].getMark() &&
				board[currentBoard].getMark(5) == players[this.currentPlayerIndex].getMark() &&
				board[currentBoard].getMark(8) == players[this.currentPlayerIndex].getMark()) return true;
		return false;
	}
	// Check the bottom right of the current board to the top left 
	private boolean checkSDiagRL() {
		if(board[currentBoard].getMark(0) == players[this.currentPlayerIndex].getMark() &&
				board[currentBoard].getMark(4) == players[this.currentPlayerIndex].getMark() &&
				board[currentBoard].getMark(8) == players[this.currentPlayerIndex].getMark())
			return true;
		return false;
	}
	// Check the bottom left of the current board to the top right 
	private boolean checkSDiagLR() {
		if(board[currentBoard].getMark(2) == players[this.currentPlayerIndex].getMark() &&
				board[currentBoard].getMark(4) == players[this.currentPlayerIndex].getMark() &&
				board[currentBoard].getMark(6) == players[this.currentPlayerIndex].getMark())
			return true;
		return false;
	}
}
