
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
 * To store and manage the health, strength, and speed of the player.
 * To generate a 2D array of attack values using a random number generator.
 * To provide methods to access and modify the player's health, strength, and speed.
 * To provide a method to set the damage to the monster.
 * To provide a method to return the type of the object (which is "Player" in this case).
 * 
 */
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
