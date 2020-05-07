package geminicode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardTest 
{

	@Test
	public void notNull()
	{
		Card card = new Card(Suit.Club, Face.Two);
		assertNotNull(card);
	}
	
	@Test
	public void equalsNull()
	{
		Card card = new Card(Suit.Club, Face.Two);
		assertFalse(card.equals(null));
	}
	
	@Test
	public void equalsFalse()
	{
		Card card = new Card(Suit.Club, Face.Two);
		Card card2 = new Card(Suit.Club, Face.Three);
		assertFalse(card.equals(card2));
	}
	
	@Test
	public void equalsFalse2()
	{
		Card card = new Card(Suit.Club, Face.Two);
		Card card2 = new Card(Suit.Spade, Face.Three);
		assertFalse(card.equals(card2));
	}
	
	@Test
	public void equalsObjectFalse()
	{
		Card card = new Card(Suit.Club, Face.Two);
		assertFalse(card.equals(new String()));
	}
	
	@Test
	public void toStringClubCheck()
	{
		Card card = new Card(Suit.Club, Face.Two);
		assertEquals(String.format("2%s", '\u2663'), card.toString());
	}
	
	@Test
	public void toStringHeartCheck()
	{
		Card card = new Card(Suit.Heart, Face.Two);
		assertEquals(String.format("2%s", '\u2665'), card.toString());
	}
	
	@Test
	public void hashCodeCheck()
	{
		Card card = new Card(Suit.Club, Face.Two);
		Card card2 = new Card(Suit.Club, Face.Two);
		assertTrue(0 != card.hashCode());
		assertEquals(card.hashCode(), card2.hashCode());
	}
	
	@Test
	public void equalsTrue()
	{
		Card card = new Card(Suit.Club, Face.Two);
		Card card2 = new Card(Suit.Club, Face.Two);
		assertTrue(card.equals(card2));
	}
	
	@Test
	public void twoOfClubs()
	{
		Card card = new Card(Suit.Club, Face.Two);
		assertNotNull(card);
		assertEquals(card.getSuit(), Suit.Club);
		assertEquals(card.getFace(), Face.Two);
	}

	@Test
	public void twoOfClubsValueIsTwo()
	{
		Card card = new Card(Suit.Club, Face.Two);
		assertNotNull(card);
		assertEquals(card.getValue(), 2);
	}

	@Test
	public void aceValueIsEleven()
	{
		Card card = new Card(Suit.Club, Face.Ace);
		assertNotNull(card);
		assertEquals(card.getValue(), 11);
	}

	@Test
	public void jackValueIsTen()
	{
		Card card = new Card(Suit.Club, Face.Jack);
		assertNotNull(card);
		assertEquals(card.getValue(), 10);
	}

}
