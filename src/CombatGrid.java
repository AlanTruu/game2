
/* Lead Author(s):
 * @author Alan Truong
 * @author Robin Stranton
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * Kenny Truong kennytruong29@yahoo.com
 *
 * References:
 *
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  Gaddis, Tony. Starting out with Java: Control Structures through Objects. Pearson, 2021, https://www.pearson.com/en-us/subject-catalog/p/Gaddis-Revel-for-Starting-Out-With-Java-Control-Structures-through-Objects-Access-Card-8th-Edition/P200000003368/9780137451524. 
 * 
 * How to loop over two dimensional array in Java? Example. (n.d.). Javarevisited: Blog about Java 
 * Programming Tutorials, Examples, Design Patterns, Interview Questions and Answers, FIX 
 * Protocol, Tibco RV messaging, UNIX and Linux Commands, XML, SQL, MySQL, Oracle, jQuery, 
 * JavaScript,HTML, Multithreading, Collection, Error and Exception, Debugging, Best Practices 
 * and Practical tips from my experience. https://javarevisited.blogspot.com/2015/09/how-to-loop-two-dimensional-array-in-java.html
 * 
 * Return keyword in Java. (2022, August 17). GeeksforGeeks. https://www.geeksforgeeks.org/return-keyword-java/
 * Version/date: 3/20/2023
 * 
 * Responsibilities of class:
 * Declare a 2D array of Characters objects.
 * Set the first element of the first row to the Player object
 * Set the last element of the last row to the Monster object.
 * Print the status of the combat grid.
 * Check if the Player object is next to a Monster object.
 */
import java.util.Scanner;

public class CombatGrid {
	// Declare a 2D array of Characters objects
	private Characters[][] combatGrid = { { new Empty(), new Empty(), new Empty() },
			{ new Empty(), new Empty(), new Empty() }, { new Empty(), new Empty(), new Empty() } };

	// Constructor that takes a Player object and a Monster object as arguments
	public CombatGrid(Characters player, Characters monster) {
		// Set the first element of the first row to the Player object
		combatGrid[0][0] = player;
		// Set the last element of the last row to the Monster object
		combatGrid[2][2] = monster;
	}

	// This method prints the status of the combat grid. i.e. builds a picture of
	// the arena
	public void getStatus() {
		// Loop through each row of the matrix
		for (int i = 0; i < combatGrid.length; i++) {

			System.out.print("\n");
			// Print the type of the first element in the current row to the console
			System.out.print(combatGrid[i][0].getType());
			System.out.print(" | ");
			// Print the type of the second element in the current row to the console
			System.out.print(combatGrid[i][1].getType());
			System.out.print(" | ");
			// Print the type of the third element in the current row to the console
			System.out.print(combatGrid[i][2].getType());
		}
	}

	// This method checks if the Player object is next to a Monster object
	public boolean isNextToEachOther() {
		// Loop through each row of the matrix
		for (int row = 0; row < combatGrid.length; row++) {
			// Loop through each column of the matrix
			for (int col = 0; col < combatGrid[row].length; col++) {
				// Check if the current element is an instance of the Player class
				if (combatGrid[row][col] instanceof Player) {
					// Check if there is a Monster object to the left of the Player object
					if (col > 0 && combatGrid[row][col - 1] instanceof Monster) {
						// Return true if there is a Monster object to the left of the Player object
						return true;
					}
					// Check if there is a Monster object to the right of the Player object
					if (col < combatGrid.length - 1 && combatGrid[row][col + 1] instanceof Monster) {
						// Return true if there is a Monster object to the right of the Player object
						return true;
					}
					// Check if there is a Monster object above the Player object
					if (row > 0 && combatGrid[row - 1][col] instanceof Monster) {
						// Return true if there is a Monster object above the Player object
						return true;
					}
					// Check if there is a Monster object below the Player object
					if (row < combatGrid.length - 1 && combatGrid[row + 1][col] instanceof Monster) {
						// Return true if there is a Monster object below the Player object
						return true;
					}
				}
			}
		}
		// Return false if there is no Monster object next to the Player object
		return false;
	}

	// This method prompts the user to move the Player object to the right or down
	public void movePlayer() {
		// Create a new Scanner object to read user input
		Scanner scanner = new Scanner(System.in);
		System.out.print("\n");
		// Print a message to the console asking the user to input a character
		System.out.println("Press 'd' to move the Player object to the right or 's' to move the Player object down.");
		// Read the user's input
		String input = scanner.nextLine();
		// Check if the user input is 'd'
		if (input.equals("d")) {
			// Call the movePlayerRight() method to move the Player object to the right
			movePlayerRight();
			// Check if the user input is 's'
		} else if (input.equals("s")) {
			// Call the movePlayerDown() method to move the Player object down
			movePlayerDown();
			// If the user input is neither 'd' nor 's'
		} else {
			// Print an error message to the console
			System.out.println("Invalid input. Please try again.");
		}

	}

	// This method swaps the element right one column in the matrix with the player
	// element
	public void movePlayerRight() {
		// Loop through each row of the matrix
		for (int row = 0; row < combatGrid.length; row++) {
			// Loop through each column of the matrix
			for (int col = 0; col < combatGrid[row].length; col++) {
				// Check if the current element is an instance of the Player class
				if (combatGrid[row][col] instanceof Player) {
					// Check if the current column is not the last column of the matrix
					if (col < combatGrid[row].length - 1) {
						// Store the element to the right of the current element in a temporary variable
						Characters temp = combatGrid[row][col + 1];
						// Replace the element to the right of the current element with the current
						// element
						combatGrid[row][col + 1] = combatGrid[row][col];
						// Replace the current element with the element stored in the temporary variable
						combatGrid[row][col] = temp;
						// Exit the method
						// https://www.geeksforgeeks.org/return-keyword-java/
						return;
					}
				}
			}
		}
	}

	// This method swaps the element down one row in the matrix with the player
	// element
	public void movePlayerDown() {
		// Loop through each row of the matrix
		for (int row = 0; row < combatGrid.length; row++) {
			// Loop through each column of the matrix
			for (int col = 0; col < combatGrid[row].length; col++) {
				// Check if the current element is an instance of the Player class
				if (combatGrid[row][col] instanceof Player) {
					// Check if the current row is not the last row of the matrix
					if (row < combatGrid.length - 1) {
						// Store the element below the current element in a temporary variable
						Characters temp = combatGrid[row + 1][col];
						// Replace the element below the current element with the current element
						combatGrid[row + 1][col] = combatGrid[row][col];
						// Replace the current element with the element stored in the temporary variable
						combatGrid[row][col] = temp;
						// Exit the method
						// https://www.geeksforgeeks.org/return-keyword-java/
						return;
					}
				}
			}
		}
	}
}
