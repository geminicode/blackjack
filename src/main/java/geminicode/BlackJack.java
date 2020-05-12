package geminicode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Status of a Players Hand
 * @author Darrell Fuller
 */
enum HandStatus {
	/** Player is playing the game */
	Playing,
	/** Player is playing the game */
	Standing,
	/** Player is holding his hand and current points */
	BlackJack,
	/** Player has the highest possible hand */
	Busted,
	/** Player has won the game */
	Winner
}

/**
 * BlackJack for Java
 * @author Darrell Fuller
 *
 */
public class BlackJack {

	/** Take input from players */
 	private Scanner in;
	/** Deck of Cards  */
	private Deck deck = null;
	
	/** Players in the game  */
	protected List<Player> players = new ArrayList<Player>();
	/** Status of Players in the game  */
	protected Map<Player, HandStatus> playerStatus = new HashMap<Player, HandStatus>();
	
	// Commands
	/** Quit Key Command  */
	private static final char CMD_QUIT = 'Q';
	/** Hit Key Command  */
	private static final char CMD_HIT = 'H';
	/** Stand Key Command  */
	private static final char CMD_STAND = 'S';
	
	/** Dealer's name  */
	protected static final String DEALER_NAME = "Dealer";
	
	/**
	 * Default Constructor.  Will use System.in for Input Scanner
	 */
	public BlackJack()
	{
		this(new Scanner(System.in));
	}
	
	/**
	 * Create a BlackJack object using passed in input Scanner
	 * @param input scanner for player input.
	 */
	public BlackJack(Scanner input)
	{
		deck = new Deck();
		this.in = input;
	}	
	
	/**
	 * Deal a single card to the specified player
	 * @param player to deal cards to
	 */
	protected void dealCard(Player player)
	{
		dealCards(player, 1);
	}
	
	/**
	 * Deal a specified number of cards to a player
	 * @param player to deal cards to
	 * @param cards to deal out
	 */
	protected void dealCards(Player player, int cards)
	{
		for (int i=0; i<cards; i++)
		{
			player.hit(deck.deal());
		}
		
		if (player.getHandTotal() >= 21)
		{
			if (player.getHandTotal() == 21)
				playerStatus.put(player, HandStatus.BlackJack);
			else
				playerStatus.put(player, HandStatus.Busted);
		}
		else
		{
			playerStatus.put(player, HandStatus.Playing);
		}
	}
	
	/**
	 * Create the appropriate number of players as well as the dealer.
	 * Deal each player two (2) cards.
	 * 
	 * @param players that are in the game
	 */
	public void initGame(int players)
	{
		for (int i=0; i < players; i++)
		{
			Player player = new Player(String.format("Player#%s", i+1));
			this.players.add(player);
			dealCards(player, 2);
		}
		
		Player dealer = new Player(DEALER_NAME);
		this.players.add(dealer);
		dealCards(dealer, 2);
		
		try
		{
			play();
		}
		catch(java.util.NoSuchElementException e)
		{
			// Determine the winner.
			if (playerStatus.get(dealer) == HandStatus.BlackJack)
			{
				// House always wins
				playerStatus.put(dealer, HandStatus.Winner);
			}
			else
			{
				// Default winner to Dealer since he gets the "push", but he can't be busted.
				int wintotal = (playerStatus.get(dealer) != HandStatus.Busted)?dealer.getHandTotal():0;
				Player winner = dealer;
				for (Player p : this.players)
				{
					if (p.getHandTotal() > wintotal && playerStatus.get(p) != HandStatus.Busted)
					{
						winner = p;
					}
				}
				playerStatus.put(winner, HandStatus.Winner);
				
				// check if two players are tied
				if (!winner.equals(dealer))
				{
					for (Player p : this.players)
					{
						if (p.getHandTotal() == winner.getHandTotal())
						{
							playerStatus.put(p, HandStatus.Winner);
						}
					}					
				}
			}
			
			showPlayers(dealer);
			
			log("\n\nGame is over!\n");
		}
		catch(Exception e)
		{
			log(String.format("Unexpected Error: %s", e.getMessage()));
		}
	}
	
	/**
	 * Play the BlackJack Game
	 * @throws RuntimeException
	 */
	protected void play() throws RuntimeException
	{
		char cmd;
		Iterator<Player> nextPlayer = players.iterator();
		Player player = nextPlayer.next();
		do {
			showPlayers(player);
			showMenu(player);
			cmd = in.next().toUpperCase().charAt(0);
			switch(cmd)
			{
			case CMD_HIT:
				dealCard(player);
				if (player.getHandTotal() >= 21)
				{
					player = nextPlayer.next();
				}
				break;
			case CMD_STAND:
				playerStatus.put(player, HandStatus.Standing);
				player = nextPlayer.next();
				break;
			case CMD_QUIT:
				log("Thank you for playing!\n\n");
				break;
			default:
				log(String.format("Invalid Command: %s", cmd));
				break;
			}

		} while (cmd != CMD_QUIT );
		
	}
	
	/**
	 * Show all the players and their hands
	 * @param currentPlayer is annotated in list.
	 */
	protected void showPlayers(Player currentPlayer)
	{
		for (Player p : players)
		{
			log(String.format("%s (%s) %s\n", (p.equals(currentPlayer))?"->":"..", playerStatus.get(p),  p.getHand()));
		}
	}
	
	/**
	 * Display Game Menu
	 * @param currentPlayer displayed in the menu
	 */
	protected void showMenu(Player currentPlayer)
	{
		log(String.format("\n\n\n\nPlayer %s Turn: [H]it [S]tand [Q]uit : ", currentPlayer ));
	}
	
	/**
	 * Print a message to STDOUT
	 * @param message to print
	 */
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
			
			BlackJack game = new BlackJack(in);
			game.initGame(numPlayers);
			
			break;
		}
		in.close();
	}

}
