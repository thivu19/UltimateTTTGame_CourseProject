/* Name: Thi Vu
 * Class: CS 2336.002
 * */

package courseproject;

/* Analysis:
 * The program set the player mark and name, so that the other classes
 * and user can tell them apart 
 * 
 * Design:
 * - Set the name and mark for the player
 * - The get method for name and mark return those values
 * - The abstract method are implemented to ask the user for the board 
 * and square value
 * */

public abstract class Player {
	private String name;
	private String mark;
	
	public Player(String name, String mark) {
		setName(name);
		setMark(mark);
	}
	
	// Return player name
	public String getName() {
		return name;
	}
	
	// Set player name
	public void setName(String name) {
		this.name = name;
	}
	
	// Return player mark
	public String getMark() {
		return mark;
	}
	
	// Set player mark
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public abstract int selectBoardValue(int range);
	public abstract int selectSquareValue(int range);
}
