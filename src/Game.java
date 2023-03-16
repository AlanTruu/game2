public class Game
{

	public static void main(String[] args)
	{
		//player object
		Player player = new Player(10, 6, 2);
		//Monster object
		Monster monster = new Monster(5, 2, 1);
		
		encounter(player, monster);
	}
	//encounter method will accept a player object and a monster object, this is how the battle will take place
	public static void encounter(Player newPlayer, Monster newMonster)
	{
		newPlayer.rngArray();
		int[][] battleArray = newPlayer.getArray(); //creating a new array reference that will be initialized to the player object's array
		
		//for loop to print out the array numbers
		for (int i = 0; i < battleArray.length; i++)
		{
			System.out.print(battleArray[i][0]);
			System.out.print(battleArray[i][1]);
			System.out.print(battleArray[i][2]);
		}
	}



}
