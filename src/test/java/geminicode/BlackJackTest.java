package geminicode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;
import java.util.NoSuchElementException;

import org.junit.Test;
import java.util.Scanner;

/**
 * Simple game throwing next user exception
 * @author devadmin
 *
 */
class BlackJackTestNoOpGame extends BlackJack
{

	@Override
	protected void play() throws RuntimeException {
		throw new NoSuchElementException();
	}

	@Override
	protected void showPlayers(Player currentPlayer) {
	}

	@Override
	protected void showMenu(Player currentPlayer) {
	}
	
}

/**
 * Game where "NO" exception (i.e. Next user) is thrown.
 * NOT a real world situation.  Used for code coverage.
 * @author devadmin
 *
 */
class BlackJackTestNoExceptionGame extends BlackJack
{

	@Override
	protected void play() throws RuntimeException {
		showPlayers(players.get(0));
		showMenu(players.get(0));
	}

	@Override
	protected void showPlayers(Player currentPlayer) {
		super.showPlayers(currentPlayer);
	}

	@Override
	protected void showMenu(Player currentPlayer) {
		super.showMenu(currentPlayer);
	}
}

class BlackJackTestDealerBustedGame extends BlackJack
{

	@Override
	protected void play() throws RuntimeException {
		for (Player p : players)
		{
			if (p.getName().equals(DEALER_NAME))
			{
				while(p.handTotal() < 21)
				{
					dealCard(p);
				}
				throw new NoSuchElementException();
			}
		}
	}

	@Override
	protected void showPlayers(Player currentPlayer) {
	}

	@Override
	protected void showMenu(Player currentPlayer) {
	}
}

/**
 * Some RuntimeException occurs during game play
 * @author devadmin
 *
 */
class BlackJackTestOtherRuntimeExceptionGame extends BlackJack
{

	@Override
	protected void play() throws RuntimeException {
		throw new RuntimeException();
	}

	@Override
	protected void showPlayers(Player currentPlayer) {
	}

	@Override
	protected void showMenu(Player currentPlayer) {
	}
	
}

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
		BlackJack.log("Test Message");
	}	
	
	@Test 
	public void statusCheck()
	{
		HandStatus status = HandStatus.Playing;
		assertNotNull(status);
		assertEquals(status.ordinal(), 0);
	}
	
	@Test
	public void initGameCheck()
	{
		BlackJackTestNoOpGame obj = new BlackJackTestNoOpGame();
		assertNotNull(obj);
		obj.initGame(1);
	}
	
	@Test
	public void initGameCheckNoException()
	{
		BlackJackTestNoExceptionGame obj = new BlackJackTestNoExceptionGame();
		assertNotNull(obj);
		obj.initGame(2);
	}	
	
	@Test
	public void initGameCheckOtherException()
	{
		BlackJackTestOtherRuntimeExceptionGame obj = new BlackJackTestOtherRuntimeExceptionGame();
		assertNotNull(obj);
		obj.initGame(1);
	}	
	
	@Test
	public void initDealerBustedGame()
	{
		BlackJackTestDealerBustedGame obj = new BlackJackTestDealerBustedGame();
		assertNotNull(obj);
		obj.initGame(1);
	}	
	
	@Test
	public void playQuitCommandCheck()
	{
	
		byte playback[] = {'Q'};
		PushbackInputStream pbis = new PushbackInputStream(new ByteArrayInputStream(playback));
		Scanner scanner = new Scanner(pbis);
		BlackJack game = new BlackJack(scanner);
		game.initGame(2);
	}

	@Test
	public void playHitCommandCheck()
	{
	
		byte playback[] = {'H'};
		PushbackInputStream pbis = new PushbackInputStream(new ByteArrayInputStream(playback));
		Scanner scanner = new Scanner(pbis);
		BlackJack game = new BlackJack(scanner);
		game.initGame(2);
	}

	@Test
	public void playStayCommandCheck()
	{
	
		byte playback[] = {'S'};
		PushbackInputStream pbis = new PushbackInputStream(new ByteArrayInputStream(playback));
		Scanner scanner = new Scanner(pbis);
		BlackJack game = new BlackJack(scanner);
		game.initGame(2);
	}

	@Test
	public void playInvalidCommandCheck()
	{
	
		byte playback[] = {'I'};
		PushbackInputStream pbis = new PushbackInputStream(new ByteArrayInputStream(playback));
		Scanner scanner = new Scanner(pbis);
		BlackJack game = new BlackJack(scanner);
		game.initGame(2);
	}
}
