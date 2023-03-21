
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
 * To store and manage the health, strength, and speed of the monster.
 * To provide methods to access and modify the monster's health, strength, and speed.
 * To provide a method to set the damage to the player.
 * To provide a method to return the type of the object (which is "Monster" in this case).
 * 
 */
public class Monster extends Characters {
	// contains the HP of the monster
	private int health;
	// contains the strength of the monster in a numerical form
	private int strength;
	// contains the speed of the monster in a numerical form
	private int speed;

	public Monster() {
		// no arg constructor
	}

	// constructor that accepts 3 int arguments, initializing the HP, strength, and
	// speed of the monster
	public Monster(int newHealth, int newStr, int newSpd) {
		health = newHealth;
		strength = newStr;
		speed = newSpd;
	}

	// method that can set the monster health
	public void setHealth(int newHealth) {
		health = newHealth;
	}

	// method that can change the strength of the monster
	public void setStrength(int newStrength) {
		strength = newStrength;
	}

	// method that can change the speed of the monster
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}

	// method that returns the HP of the monster
	public int getHealth() {
		return health;
	}

	// method that returns the strength of the monster
	public int getStrength() {
		return strength;
	}

	// method that returns the speed of the monster
	public int getSpeed() {
		return speed;
	}

	// Return the object type
	@Override
	public String getType() {
		return "Monster";
	}

//	public Player getPlayer()
//	{
//		return player;
//	}

	// method that sets damage to the player by using the player object from within
	// the monster class
	public void setDamageToPlayer(Player player1, int damage) {
		player1.setHealth(player1.getHealth() - damage);
	}

}
