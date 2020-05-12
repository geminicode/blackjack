package geminicode;

import java.util.ArrayList;
import java.util.List;


/**
 * A player in the game, with hand of cards
 * @author Darrell Fuller
 *
 */
public class Player {
	
	private List<Card> hand = new ArrayList<Card>();
	private String name;
	
	/**
	 * Player, must have a name
	 * @param name of player
	 */
	public Player(String name)
	{
		this.name = name;
	}
	
	/**
	 * Deal a single card to the Player
	 * @param card given to the player
	 */
	public int hit(Card card)
	{
		hand.add(card);
		return getHandTotal();
	}
	
	/**
	 * The numerical, face value of the player's hand.
	 * @return the hand total
	 */
	public int getHandTotal()
	{
		int total = 0;
		for (Card c : hand)
		{
			total += c.getValue();
		}
		return total;
	}

	/**
	 * Player's name.  Cannot be changed.
	 * @return the player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Create a string buffer of the user's name, hand total and cards in hand. 
	 * @return String display of player's hand
	 */
	public String getHand()
	{
		StringBuffer buffer = new StringBuffer(String.format("%s:[%d]  ", getName(), getHandTotal() ));
		
		for (Card c : hand)
		{
			buffer.append(String.format("%s: ", c));
		}

		return buffer.toString();
	}
	
	/**
	 * Compare this Player to another
	 * @param obj other Player
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		
		if (!(obj instanceof Player))
			return false;
		
		Player other = (Player) obj;
		
		return this.getName().equals(other.getName());
	}

	/**
	 * Player's hashcode
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * String representation of a player.
	 */
	@Override
	public String toString() {
		return String.format("%s", getName());
	}
	
	
}
