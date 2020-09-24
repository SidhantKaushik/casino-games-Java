import java.io.FileNotFoundException;

public class HighLow extends Game{
	private char selection;
	private String betOn;
	private char winner = 'd';
public HighLow() throws FileNotFoundException {
	super('C');
}
public void starting() throws FileNotFoundException
{
	setUpHand();
	betAmount();
	drawNextCard();
	didPlayerWin();
	betOn();
	playAgain();
}

public void playAgain() throws FileNotFoundException {
	if(deck.size()<6)
	{
		deck = new Deck();
	}
	else {
		deck.shuffle();
	}
	comm = new ConsoleComunicationController();
	String choice = comm.getInput_String("Would you like to continue playing? 'Yes or No':");
	choice = choice.toLowerCase();
	if (choice.equals("yes"))
	{
		comm.println("");
		starting();
	}
	else {
		moveGamesMessage();
		new Menu();
	}
}

public void setUpHand()
{
	comm = new ConsoleComunicationController();
	playerHand = new CardHand();
	playerHand.addCard(deck.dealCard());
	comm.print(playerHand);
	comm.println("");
	betOn = comm.getInput_String("Do you think the dealers card will be HIGHER, LOWER, or the SAME");
}
public void drawNextCard()
{
	bankerHand = new CardHand();
	bankerHand.addCard(deck.dealCard());
	comm.println("The dealer drew: ");
	comm.print(bankerHand);
	comm.println("");
}
public void didPlayerWin()
{
	if(playerHand.get(0).getRank()>bankerHand.get(0).getRank())
	{
		winner = 'p';
	}
	else if (playerHand.get(0).getRank()<bankerHand.get(0).getRank()) {
		winner = 'b';
	}
	else if (playerHand.get(0).getRank()==bankerHand.get(0).getRank())
	{
		if (playerHand.get(0).getSuit() == bankerHand.get(0).getSuit())
		{
			winner = 'n';
		}
		else {
		winner = 't';
		}
	}
}
public void betOn() throws FileNotFoundException {
	
	if (betOn.toLowerCase().equals("higher") && winner == 'b')
	{
		betWin(1);
	}
	else if (betOn.toLowerCase().equals("lower") && winner == 'p')
	{
		betWin(1);
	}
	else if (betOn.toLowerCase().equals("same") && winner == 't')
	{
		betWin(1.5);
	}
	else if (winner == 'n')
	{
		noWin();
	}
	else {
		betLose();
}
}
}
