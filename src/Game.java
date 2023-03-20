import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// player object
		Player player = new Player(10, 6, 2);
		// Monster object
		Monster monster = new Monster(5, 2, 1);
		// arena object
		CombatGrid arena = new CombatGrid(player, monster);
		// arena is where the objects are to be held
		while (monster.getHealth() > 0 && player.getHealth() > 0) {
			arena.getStatus();
			// encounter only runs when the player and the monster are occupying positions
			// next to each other
			if (arena.isNextToEachOther() != true) {
				System.out.print("\n");
				System.out.print("the player and monster are not next to each other, combat cannot occur yet");
			} else {
				System.out.print("\n");
				System.out.print("initiate combat??");
				encounter(player, monster);
			}
			System.out.print("\n");
			arena.movePlayer();

		}

	}

	// encounter method will accept a player object and a monster object, this is
	// how the battle will take place
	public static void encounter(Player newPlayer, Monster newMonster) {
		do
		{
		
			//randomizes the array numbers of newPlayer
			newPlayer.randomizeArray();
			//creates a new array reference, assigns it to the player object's array
			int[][] battleArray = newPlayer.getArray(); //creating a new array reference that will be initialized to the player object's array
			
			//for loop to print out the array numbers
			for (int i = 0; i < battleArray.length; i++)
			{
				//creates a new indent for each row
				System.out.print("\n");
				//prints out the first row
				System.out.print(battleArray[i][0]);
				//prints out the second row
				System.out.print(battleArray[i][1]);
				//prints out the third row
				System.out.print(battleArray[i][2]);
			}
				
			//scanner object to take input from player
			Scanner scnr = new Scanner(System.in);
			//Print out the instructions for the player
			System.out.print("\n");
			System.out.println("Add one of the rows to deal damage");
			System.out.println("Enter 1 to add the first row, enter 2 to add the second row, enter 3 to add the third row");
			//uses the scanner object to input the player's decision
			int playerChoice = scnr.nextInt();
			
			
			
			//adds the first row if the player entered 1
			if (playerChoice == 1)
			{
				int damage = 0;
				
				for(int index = 0; index < battleArray[0].length; index++)
				{
					damage += battleArray[0][index];
					
				}
				//sets the health of the monster to the health of the monster subtracted by the damage dealt
				newMonster.setHealth(newMonster.getHealth() - damage);
				System.out.println("you did damage to the monster!");
				
				
				
				//prints out player health and monster health after battle
				System.out.println("monster health: " + newMonster.getHealth());
				
			}
		
			
			// adds the second row if the player entered 2
			if (playerChoice == 2)
			{
				int damage = 0;
				
				for(int index = 0; index < battleArray[1].length; index++)
				{
					damage += battleArray[1][index];
					
				}
				
				//sets the health of the monster to the health of the monster subtracted by the damage dealt
				newMonster.setHealth(newMonster.getHealth() - damage);
				System.out.println("you did damage to the monster!");
			
				
				//prints out player health and monster health after battle
				System.out.println("monster health: " + newMonster.getHealth());
			
			}
		
			
			//adds the last row if the player entered 3
			if (playerChoice == 3)
			{
				int damage = 0;
				
				for(int index = 0; index < battleArray[2].length; index++)
				{
					damage += battleArray[2][index];
					
				}
				//sets the health of the monster to the health of the monster subtracted by the damage dealt
				newMonster.setHealth(newMonster.getHealth() - damage);
				System.out.println("you did damage to the monster!");
			
	
				//prints out player health and monster health after battle
				System.out.println("monster health: " + newMonster.getHealth());
				
			
			}
		
			//monster inflicts damage on to the player
			System.out.println("the monster did damage to you!");
			newPlayer.setHealth(newPlayer.getHealth()-newMonster.getStrength());
			System.out.println("player health: " + newPlayer.getHealth());
	
		} 
		while(newPlayer.getHealth() > 0 && newMonster.getHealth() > 0);
	}

}
