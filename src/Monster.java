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
	
	@Override
	public String getType()
	{
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
