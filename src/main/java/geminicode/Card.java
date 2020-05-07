package geminicode;

/**
 * Standard Suit for a deck of cards
 * @author devadmin
 *
 */
enum Suit {
	Club,
	Spade,
	Heart,
	Diamond
}

/**
 * Cards in one suite
 * @author devadmin
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
		if (this.value > Face.Ten.ordinal() && this.value < Face.Ace.ordinal())
			this.value = 10;
		
		// Aces are high by default
		if (face == Face.Ace)
			this.value = 11;
	}

	public int getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}

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
		return String.format("%s-%s", this.suit, getValue());
	}
	
}
