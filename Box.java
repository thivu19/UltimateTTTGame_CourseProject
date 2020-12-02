/* Name: Thi Vu
 * Class: CS 2336.002
 * */

package courseproject;

/* Analysis:
 * The program set the place holder for this box, so that 
 * the other classes could tell the differences between the 
 * boxes.
 * 
 * Design:
 * - The getPlaceHolder return the value place holder
 * - The set the box with the place holder value if the box is open and
 * return true if successful
 * - The isAvailable method check if the box is open that has 0-8 or "*"
 * and return true if valid
 * - The print method print the place holder value and the | that 
 * separate the place holder
 * */

//Creates the boxes for the game
class Box {

	private String placeHolder;
	
	Box(String placeHolder) {
		this.placeHolder = placeHolder;
	}
	
	String getPlaceHolder() {
		return placeHolder;
	}
	
	// Set the place holder with the pass string
	boolean setPlaceHolder(String placeHolder) {
		if(isAvailable()) {
			this.placeHolder = placeHolder;
			return true;
		}
		return false;
	}

	// Check if the box is open 
	boolean isAvailable() {
		for(int i = 0; i < 9; i++){
			if (this.placeHolder.equals(Integer.toString(i)) || this.placeHolder.equals("*")) {
				return true;
			}
		}
		return false;
	}
	
	void print() {
		System.out.print(this.placeHolder + " | ");
	}
	
	
}
