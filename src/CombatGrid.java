
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
		for (int i = 0; i < combatGrid.length; i++) {
			for (int j = 0; j < combatGrid[i].length; j++) {
				if (j > 0 && combatGrid[i][j] instanceof Player && combatGrid[i][j - 1] instanceof Monster
						&& combatGrid[i][j].getClass().equals(combatGrid[i][j - 1].getClass())) {
					return true;
				}
			}
		}
		return false;
	}
}
