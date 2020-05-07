package geminicode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PlayerTest {
	
	@Test
	public void notNullCheck()
	{
		Player obj = new Player("Dealer");
		assertNotNull(obj);
	}

	@Test
	public void equalsNull()
	{
		Player obj = new Player("Dealer");
		assertFalse(obj.equals(null));
	}
	
	@Test
	public void equalsFalse()
	{
		Player obj = new Player("Dealer");
		Player obj2 = new Player("Player1");
		assertFalse(obj.equals(obj2));
	}
	
	@Test
	public void equalsObjectFalse()
	{
		Player obj = new Player("Dealer");
		assertFalse(obj.equals(new String()));
	}
	
	@Test
	public void hashCodeCheck()
	{
		Player obj = new Player("Dealer");
		Player obj2 = new Player("Dealer");
		assertTrue(0 != obj.hashCode());
		assertEquals(obj.hashCode(), obj2.hashCode());
	}
	
	@Test
	public void equalsTrue()
	{
		Player obj = new Player("Dealer");
		Player obj2 = new Player("Dealer");
		assertTrue(obj.equals(obj2));
	}

	@Test
	public void hitCheck()
	{
		Player player = new Player("Dealer");
		Deck deck = new Deck();
		
		while (player.handTotal() <= 21)
		{
			Card card = deck.deal();
			player.hit(card);
		}
		String hand = player.showHand();
		assertTrue(hand, player.handTotal() > 21);
	}

}
