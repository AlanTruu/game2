
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
 * Create a new Player object with 10 health, 6 attack, and 2 defense.
 * Create a new Monster object with 5 health, 2 attack, and 1 defense.
 * Create a new CombatGrid object with the Player and Monster objects.
 * Loop until either the Monster or the Player has 0 health.
 * Print the status of the CombatGrid object to the console.
 * Check if the Player and the Monster are next to each other.
 * Run the encounter method to trigger combat.
 * Prompt the user to move the Player object to a new position.
 * 
 */
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// Create a new Player object with 10 health, 6 attack, and 2 defense
		Player player = new Player(10, 6, 2);
		// Create a new Monster object with 5 health, 2 attack, and 1 defense
		Monster monster = new Monster(5, 2, 1);
		// Create a new CombatGrid object with the Player and Monster objects
		CombatGrid arena = new CombatGrid(player, monster);
		// Loop until either the Monster or the Player has 0 health
		while (monster.getHealth() > 0 && player.getHealth() > 0) {
			// Print the status of the CombatGrid object to the console
			arena.getStatus();
			// Check if the Player and the Monster are next to each other
			if (arena.isNextToEachOther() != true) {
				System.out.print("\n");
				System.out.print("\n");
				System.out.print("the player and monster are not next to each other, combat cannot occur yet");
			} else {
				System.out.print("\n");
				System.out.print("\n");
				// Prompt the user to initiate combat | not an active feature atm, encounter
				// will run 100% of the time
				System.out.print("initiate combat??");
				// Run the encounter method to trigger combat
				encounter(player, monster);
			}
			System.out.print("\n");
			// Promt the user to move the Player object to a new position
			arena.movePlayer();

		}

	}

	// encounter method will accept a player object and a monster object, this is
	// how the battle will take place
	public static void encounter(Player newPlayer, Monster newMonster) {
		do {

			// randomizes the array numbers of newPlayer
			newPlayer.randomizeArray();
			// creates a new array reference, assigns it to the player object's array
			int[][] battleArray = newPlayer.getArray(); // creating a new array reference that will be initialized to
														// the player object's array

			// for loop to print out the array numbers
			for (int i = 0; i < battleArray.length; i++) {
				// creates a new indent for each row
				System.out.print("\n");
				// prints out the first row
				System.out.print(battleArray[i][0]);
				// prints out the second row
				System.out.print(battleArray[i][1]);
				// prints out the third row
				System.out.print(battleArray[i][2]);
			}

			// scanner object to take input from player
			Scanner scnr = new Scanner(System.in);
			// Print out the instructions for the player
			System.out.print("\n");
			System.out.println("Add one of the rows to deal damage");
			System.out.println(
					"Enter 1 to add the first row, enter 2 to add the second row, enter 3 to add the third row");
			// uses the scanner object to input the player's decision
			int playerChoice = scnr.nextInt();

			// adds the first row if the player entered 1
			if (playerChoice == 1) {
				int damage = 0;

				for (int index = 0; index < battleArray[0].length; index++) {
					damage += battleArray[0][index];

				}
				// sets the health of the monster to the health of the monster subtracted by the
				// damage dealt
				newMonster.setHealth(newMonster.getHealth() - damage);
				System.out.println("you did damage to the monster!");

				// prints out player health and monster health after battle
				System.out.println("monster health: " + newMonster.getHealth());

			}

			// adds the second row if the player entered 2
			if (playerChoice == 2) {
				int damage = 0;

				for (int index = 0; index < battleArray[1].length; index++) {
					damage += battleArray[1][index];

				}

				// sets the health of the monster to the health of the monster subtracted by the
				// damage dealt
				newMonster.setHealth(newMonster.getHealth() - damage);
				System.out.println("you did damage to the monster!");

				// prints out player health and monster health after battle
				System.out.println("monster health: " + newMonster.getHealth());

			}

			// adds the last row if the player entered 3
			if (playerChoice == 3) {
				int damage = 0;

				for (int index = 0; index < battleArray[2].length; index++) {
					damage += battleArray[2][index];

				}
				// sets the health of the monster to the health of the monster subtracted by the
				// damage dealt
				newMonster.setHealth(newMonster.getHealth() - damage);
				System.out.println("you did damage to the monster!");

				// prints out player health and monster health after battle
				System.out.println("monster health: " + newMonster.getHealth());

			}

			// monster inflicts damage on to the player
			System.out.println("the monster did damage to you!");
			newPlayer.setHealth(newPlayer.getHealth() - newMonster.getStrength());
			System.out.println("player health: " + newPlayer.getHealth());

		} while (newPlayer.getHealth() > 0 && newMonster.getHealth() > 0);
	}

}
