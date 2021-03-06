package geminicode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * A Deck of Cards.  56 Cards of four suits; One through Ace.
 * 
 * Note: No Jokers
 * 
 * @author Darrell Fuller
 *
 */
public class Deck {

	private LinkedList<Card> cards = new LinkedList<Card>();
	
	/**
	 * Default constructor.  Initializes the deck of cards and shuffles the deck.
	 */
	public Deck()
	{
		shuffle();
	}
	
	/**
	 * Shuffle a new deck
	 */
	public void shuffle()
	{
		cards.clear();
		for (Suit s : Suit.values())
		{
			for (Face f : Face.values())
			{
				cards.add(new Card(s,f));
			}
		}
		Collections.shuffle(cards);
	}
	
	/**
	 * Deal the first card on the deck.
	 * 
	 * TBA: Deal from bottom of deck will be add later :)
	 * @return top card
	 */
	public Card deal()
	{
		return cards.pop();
	}
	
	/**
	 * Number of cards in the deck.
	 * 
	 * @return number of cards left in the deck
	 */
	public int size()
	{
		return cards.size();
	}
}
