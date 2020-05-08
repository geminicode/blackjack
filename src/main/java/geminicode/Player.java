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
	
	/*
	 * Deal a single card to the Player
	 */
	public int hit(Card card)
	{
		hand.add(card);
		return handTotal();
	}
	
	/**
	 * The numerical, face value of the player's hand.
	 * @return the hand total
	 */
	public int handTotal()
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

	public String showHand()
	{
		StringBuffer buffer = new StringBuffer(String.format("%s:[%d]  ", getName(), handTotal() ));
		
		for (Card c : hand)
		{
			buffer.append(String.format("%s: ", c));
		}

		return buffer.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		
		if (!(obj instanceof Player))
			return false;
		
		Player other = (Player) obj;
		
		return this.getName().equals(other.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return String.format("%s", getName());
	}
	
	
}
