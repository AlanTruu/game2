import java.util.Random;

public class Item {
	
	
	// not sure if we want the item objects to directly affect the player/monster objects or whether
	// the item objects have characteristics that are then factored into combat calculation

	//name of the item 
	private String name;
	//damage multiplier to be factored in when player is using the item
	private int damageMultiplier;

	public Item() {

	}

	public Item(String name, int damageMultiplier) {
		this.name = name;
		this.damageMultiplier = damageMultiplier;
	}
}
