import java.util.Random;

public class Player extends Characters {
	// contains the HP of the player
	private int health = 0;
	// contains the strength of the player in a numerical form
	private int strength = 0;
	// contains the speed of the player in a numerical form
	private int speed = 0;
	// will contain the total damage that a player can do to a monster
	private int sum = 0;
	// mosnter object within the player class, so that the two classes can interact
	// private Monster monster = new Monster();
	// instance of a random class to will generate numbers for the attackArray
	private Random rand = new Random();

	private int[][] attackArray = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

	public Player() {
		// no arg constructor
	}

	// constructor that accepts arguments to intitalize health, strength, and speed
	public Player(int newHealth, int newStr, int newSpd) {
		health = newHealth;
		strength = newStr;
		speed = newSpd;
	}

	// method that can set the health of the player
	public void setHealth(int newHealth) {
		health = newHealth;
	}

	// method that can change the strength of the player
	public void setStrength(int newStrength) {
		strength = newStrength;
	}

	// method that can change the speed of the player
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}

	// method that returns the HP of the player
	public int getHealth() {
		return health;
	}

	// method that returns the strength of the player
	public int getStrength() {
		return strength;
	}

	// method that returns the speed of the player
	public int getSpeed() {
		return speed;
	}

	public int[][] getArray() {
		return attackArray;
	}

	public void setDamageToMonster(Monster monster1, int damage) {
		monster1.setHealth(monster1.getHealth() - damage);
	}

	// Return the object type
	@Override
	public String getType() {
		return "Player";
	}

	// double for loop
	// https://javarevisited.blogspot.com/2015/09/how-to-loop-two-dimensional-array-in-java.html
	// copied straight from the website
	// changes the numbers of the attackArray after every method call
	public void randomizeArray() {
		for (int row = 0; row < attackArray.length; row++) {
			for (int col = 0; col < attackArray[row].length; col++) {
				attackArray[row][col] = rand.nextInt(strength);
				// System.out.println(attackArray[row][col]);
			}
		}

	}

}
