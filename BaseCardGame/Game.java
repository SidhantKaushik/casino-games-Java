import java.io.FileNotFoundException;

public class Game {
	protected ConsoleComunicationController comm;
	protected Deck ab = new Deck();
	protected int balance;
	protected Deck deck = new Deck();
	protected CardHand playerHand;
	protected CardHand bankerHand;
	protected int playerNumCards;
	protected int bankerNumCards;
	protected int bet;
	protected char betOn;
	protected int playerHandValue = 0;
	protected int playHandValue = 0;
	protected int bankerHandValue = 0;
	protected char winner;
	char choices;
	public Game(char choice) throws FileNotFoundException{
		choices = choice;
		balance = StartUp.getBalance();
		moneyChecker();
		deck.shuffle();
		playerHand = new CardHand();
		bankerHand = new CardHand();
	}
	public void choice(char choice) throws FileNotFoundException {
		
		ab.shuffle();
		if (choice == 'A')
		{
			
			PuntaBanco ab =new PuntaBanco();
			ab.starting();
			
		}
		else if (choice == 'B')
		{
			HighLow ad = new HighLow();
			ad.starting();;
		}
		else if (choice == 'C')
		{
		}
	}
	public void moneyChecker() throws FileNotFoundException
	{
		if(balance>0){
			choice(choices);
		}
		else {
			System.out.println("Your balance is insufficent.");
		}
	}
	public void moveGamesMessage() {
	
	comm.println("Your balance is: ");
	comm.print(balance);
	comm.println("");
	}
	public void betWin(double d) throws FileNotFoundException
	{
		StartUp saved = new StartUp();
		comm.println("");
		comm.println("=====You win=====");
		balance = (int) (balance + (bet * d));
		comm.print(balance);
		comm.println("");
		saved.save(balance);
	}
	
	public void betLose() throws FileNotFoundException {
		StartUp saved = new StartUp();
		comm.println("=====You lost=====");
		balance = balance - bet;
		comm.print(balance);
		comm.println("");
		saved.save(balance);
	}
	public void noWin() throws FileNotFoundException {
		StartUp saved = new StartUp();
		bet = 0;
		comm.print(balance);
		comm.println("");
		saved.save(balance);
	}
	
	public void betting() throws FileNotFoundException {
		if(winner == 'p' && betOn == 'p') {
			betWin(1);
		}
		else if(winner == 'p' && betOn == 'P') {
			betWin(1);
		}
		else if(winner == 'b' && betOn == 'b') {
			betWin(0.95);
		}
		else if(winner == 'b' && betOn == 'B') {
			betWin(0.95);
		}
		else if(winner == 't' && betOn == 't') {
			betWin(8);
		}
		else if (winner == 't' && betOn == 'T') {
			betWin(8);
		}
		else {
			betLose();
		}
	}
	public void betAmount() throws FileNotFoundException
	{
		int amount = comm.getInput_Int("Please enter the amount that you would like to bet:");
		if (validBetAmt(amount) == true) {
			bet = amount;
		}
		else {
			new Menu();	
		}
		
	}
	public boolean validBetAmt(int amount)
	{
		if (amount > balance)
		{
			System.out.println("Error, bet is greater than balance");
			return false;
		}
		else {
			return true;
		}
		
	}
}
