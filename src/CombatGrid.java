import java.util.Scanner;

public class CombatGrid {
	// array
	private Characters[][] combatGrid = { { new Empty(), new Empty(), new Empty() },
			{ new Empty(), new Empty(), new Empty() }, { new Empty(), new Empty(), new Empty() } };

	public CombatGrid(Characters player, Characters monster) {
		combatGrid[0][0] = player;
		combatGrid[2][2] = monster;
	}

	public void getStatus() {
		for (int i = 0; i < combatGrid.length; i++) {

			System.out.print("\n");
			System.out.print(combatGrid[i][0].getType());
			System.out.print(" | ");
			System.out.print(combatGrid[i][1].getType());
			System.out.print(" | ");
			System.out.print(combatGrid[i][2].getType());
		}
	}

	public boolean isNextToEachOther() {
		for (int row = 0; row < combatGrid.length; row++) {
			for (int col = 0; col < combatGrid[row].length; col++) {
				if (combatGrid[row][col] instanceof Player) {
					// check left
					if (col > 0 && combatGrid[row][col - 1] instanceof Monster) {
						return true;
					}
					// check right
					if (col < combatGrid.length - 1 && combatGrid[row][col + 1] instanceof Monster) {
						return true;
					}
					// check top
					if (row > 0 && combatGrid[row - 1][col] instanceof Monster) {
						return true;
					}
					// check bottom
					if (row < combatGrid.length - 1 && combatGrid[row + 1][col] instanceof Monster) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void movePlayer() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press 'd' to move the Player object to the right or 's' to move the Player object down.");
		String input = scanner.nextLine();
		if (input.equals("d")) {
			movePlayerRight();
		} else if (input.equals("s")) {
			movePlayerDown();
		} else {
			System.out.println("Invalid input. Please try again.");
		}

	}

	// method to swap the element right one column in the matrix with the player
	// element
	public void movePlayerRight() {
		for (int row = 0; row < combatGrid.length; row++) {
			for (int col = 0; col < combatGrid[row].length; col++) {
				if (combatGrid[row][col] instanceof Player) {
					if (col < combatGrid[row].length - 1) {
						Characters temp = combatGrid[row][col + 1];
						combatGrid[row][col + 1] = combatGrid[row][col];
						combatGrid[row][col] = temp;
						return;
					}
				}
			}
		}
	}

	// method to swap the element down one row in the matrix with the player element
	public void movePlayerDown() {
		for (int row = 0; row < combatGrid.length; row++) {
			for (int col = 0; col < combatGrid[row].length; col++) {
				if (combatGrid[row][col] instanceof Player) {
					if (row < combatGrid.length - 1) {
						Characters temp = combatGrid[row + 1][col];
						combatGrid[row + 1][col] = combatGrid[row][col];
						combatGrid[row][col] = temp;
						return;
					}
				}
			}
		}
	}
}
