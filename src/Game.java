
public class Game {

	public static void main(String[] args) {
		// player object
		Player player = new Player(10, 6, 2);
		// Monster object
		Monster monster = new Monster(5, 2, 1);
		// arena object
		CombatGrid arena = new CombatGrid(player, monster);
		// arena is where the objects are to be held
		arena.getStatus();
		if(arena.isNextToEachOther()) {
		encounter(player, monster);
		}

	}

	// encounter method will accept a player object and a monster object, this is
	// how the battle will take place
	public static void encounter(Player newPlayer, Monster newMonster) {
		newPlayer.rngArray();
		// creating a new array reference that will be initialized to the
		// player object's array
		int[][] battleArray = newPlayer.getArray();

		// for loop to print out the array numbers
		for (int i = 0; i < battleArray.length; i++) {
			System.out.print("\n");
			System.out.print(battleArray[i][0]);
			System.out.print(battleArray[i][1]);
			System.out.print(battleArray[i][2]);
		}
	}

	

}
