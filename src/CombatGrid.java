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
