package geminicode;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BlackJackTest 
{
	@Test
	public void equalsFalse()
	{
		BlackJack obj = new BlackJack();
		assertNotNull(obj);
	}
	
	@Test
	public void logCheck()
	{
		BlackJack obj = new BlackJack();
		assertNotNull(obj);
		obj.log("Test Message");
	}	
}
