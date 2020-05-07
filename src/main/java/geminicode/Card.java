package geminicode;

/**
 * Standard Suit for a deck of cards
 * @author Darrell Fuller
 *
 */
enum Suit {
	Club,  // '\u2663'
	Spade, // '\u2660'
	Heart, // '\u2665'
	Diamond // '\u2662'
}

/**
 * Cards in one suite
 * @author Darrell Fuller
 *
 */
enum Face {
	One,
	Two, 
	Three,
	Four,
	Five,
	Six,
	Seven,
	Eight,
	Nine,
	Ten,
	Jack,
	Queen,
	King,
	Ace
}

/**
 * Card in a Deck.  A Card has a Suit (Heart, Spade, etc.) and a Face (Two, Queen, Ace, etc).
 * There is an associated value for each card.  Face cards are 10.
 * 
 * @author Darrell Fuller
 *
 */
public class Card {

	private Suit suit = Suit.Club;
	private Face face = Face.One;
	private int value = 0;
	
	public Card(Suit suit, Face face)
	{
		this.suit = suit;
		this.face = face;
		
		// Ordinal is zero based.
		this.value = face.ordinal()+1;  
		
		// Face cards are ten
		if ((face == Face.Jack) || (face == Face.Queen) || (face == Face.King))
			this.value = 10;
		
		// Aces are high by default
		if (face == Face.Ace)
			this.value = 11;
	}

	/**
	 * Numerical value of Face of Card.  
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Card Suit (Heart, Spade, etc.)
	 * @return
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Card Face (Two, Jack, Ace, etc.)
	 * @return
	 */
	public Face getFace() {
		return face;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) 
			return false;
		
		if (!(obj instanceof Card))
			return false;
		
		Card other = (Card) obj;
		
		return this.getFace().equals(other.getFace()) &&
				this.getSuit().equals(other.getSuit());
	}

	@Override
	public int hashCode() {
		return this.suit.hashCode() +  this.face.hashCode();
	}

	@Override
	public String toString() {
		char s = '\u2663';
		switch (this.suit)
		{
			case Spade:
				s = '\u2660';
				break;
			case Heart:
				s = '\u2665';
				break;			
			case Diamond:
				s = '\u2662';
				break;
			default:
				break;				
		}
		return String.format("%s%s", getValue(), s);
	}
	
}
