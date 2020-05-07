package geminicode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum HandStatus {
	Good,
	BlackJack,
	Busted
}

/**
 * BlackJack for Java
 * @author Darrell Fuller
 *
 */
public class BlackJack {

	private int numPlayers = 2; // Dealer & One Player
	private Deck deck = null;
	private boolean playing = false;
	private List<Player> players = new ArrayList<Player>();
	private int currentPlayer = 1;
	
	public BlackJack()
	{
		deck = new Deck();
	}
	
	public void initGame(int players)
	{
		this.players.add(new Player("Dealer"));
		
		for (int i=0; i < players; i++)
		{
			this.players.add(new Player(String.format("Player#%s", i+1)));
		}
		
		play();
	}
	
	protected void play()
	{
		showPlayers();
		showMenu();
	}
	
	protected void showPlayers()
	{
		for (Player p : players)
		{
			log(String.format("%s\n", p.showHand()));
		}
	}
	
	protected void showMenu()
	{
		log(String.format("\n\n\n\nPlayer Turn: %s Actions: [H]it [S]tand", players.get(this.currentPlayer) ));
	}
	
	public static void log(String message)
	{
		System.out.print(message);
	}
	
	/**
	 * Main entry point
	 * @param args passed to application
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		log("Welcome to BlackJack!.  Let's Play a Game.\n  Five or less Players, NOT includeing the Dealer.\n");
		
		while(true)
		{
			log("How many players? ");
			
			int numPlayers = in.nextInt();
			if (numPlayers == 0)
			{
				numPlayers = 1;
			}
			else if (numPlayers > 5)
			{
				log("Error: Too many players!");
				continue;
			}
			log(String.format("Starting Game with %s Players\n", numPlayers));
			
			BlackJack game = new BlackJack();
			game.initGame(numPlayers);
			
			break;
		}
	}

}
