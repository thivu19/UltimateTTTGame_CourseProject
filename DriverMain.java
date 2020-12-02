/* Name: Thi Vu
 * Class: CS 2336.002
 * */

package courseproject;

/* Analysis:
 * The program display a tic-tac-toe board, but 9 times in a normal
 * tic-tac-toe game. In the beginning, the user gets to select any board
 * they want to play and any square. It's like a normal game of tic-tac-toe.
 * However, you can only place a mark on the board determined by the position 
 * of your opponent's last placed mark. So, if they put an X or O in the top 
 * right corner of a square, your next move must occur in the top right 
 * board.
 * 
 * Design:
 * - Set the players and start the UltimateTTTGame 
 * */

public class DriverMain {
	public static void main(String[] args) {
		UltimateTTTGame game = new UltimateTTTGame();
		//game.setPlayers(new HumanPlayer("Player1", "X"), new HumanPlayer("Player2", "O"));
		game.setPlayers(new HumanPlayer("Player1", "X"), new ComputerPlayer("Player2", "O"));
		game.start();
	}
}
