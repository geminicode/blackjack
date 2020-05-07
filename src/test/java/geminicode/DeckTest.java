package geminicode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DeckTest 
{

	@Test
	public void notNullCheck()
	{
		Deck obj = new Deck();
		assertNotNull(obj);
	}
	
	@Test
	public void shuffleCheck()
	{
		Deck obj = new Deck();
		assertNotNull(obj);
		obj.shuffle();
	}

	@Test
	public void dealCheck()
	{
		Deck obj = new Deck();
		assertNotNull(obj);
		Card card = obj.deal();
		assertNotNull(card);
	}
	
	@Test
	public void sizeCheck()
	{
		Deck obj = new Deck();
		assertNotNull(obj);
		assertEquals(obj.size(), 56);
		Card card = obj.deal();
		assertNotNull(card);
		assertEquals(obj.size(), 55);
	}
	
}
