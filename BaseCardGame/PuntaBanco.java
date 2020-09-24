import java.io.FileNotFoundException;

public class PuntaBanco extends Game{

	public PuntaBanco() throws FileNotFoundException {
		super('C');
	}
	public void starting() throws FileNotFoundException {
		whoBet();
		dealHand();
		betAmount();
		rules();
		playerHandPrint();
		bankerHandPrint();
		value();
		result();
		betting();
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
	

	
	
	
	public void result()
	{
		if (playHandValue>bankerHandValue) {
			winner = 'p';
		}
		else if (bankerHandValue>playHandValue)
		{
			winner = 'b';
		}
		else {
			winner = 't';
		}
	}
	public void rules()
	{
		int i = 0;
		while(playerHand.size()>i)
		{	int values = 0;
		values = playerHand.get(i).getRank();
		if(values > 10){
			if(values == 0) {
				values = 0;
			}
			if(values == 11) {
				values = 0;
			}
			else if(values == 12)
			{
				values = 0;
			}
			else if(values ==13)
					{
				values = 0;
			}
			else {
				values= 1;
			}
		}
			playHandValue = playHandValue + values;
			
			i++;
		}
		playHandValue = playHandValue%10;
		bankerHandValue = bankerHandValue%10;
		//skip
		if( playHandValue == 8 || playHandValue == 9|| bankerHandValue == 8 || bankerHandValue == 9)
		{
		}
		//draw card
		else if(playHandValue == 0 || playHandValue == 1||playHandValue == 2 || playHandValue == 3||playHandValue == 4 || playHandValue == 5) {
			playerHand.addCard(deck.dealCard());
			
		}
			

		//no new card
		else if (playerHand.get(1).getRank() == 6 || playerHand.get(1).getRank() == 7) {
			if(bankerHandValue == 0 || bankerHandValue == 1 || bankerHandValue == 2 || bankerHandValue == 3||bankerHandValue == 4 || bankerHandValue == 5)
			{
				bankerHand.addCard(deck.dealCard());
			}
		}
		
		if (playerHand.size()>=3)
		{
		if(playerHand.get(2).getRank() == 2 ||playerHand.get(2).getRank() == 3 )
		{
			if(bankerHandValue == 0 || bankerHandValue == 1 || bankerHandValue == 2 || bankerHandValue == 3||bankerHandValue == 4) {
				bankerHand.addCard(deck.topCard());
			}
		}
		else if(playerHand.get(2).getRank() == 4 ||playerHand.get(2).getRank() == 5 )
		{
			if(bankerHandValue == 0 || bankerHandValue == 1 || bankerHandValue == 2 || bankerHandValue == 3||bankerHandValue == 4 || bankerHandValue == 5)
			{
				bankerHand.addCard(deck.topCard());
			}
		}
		else if (playerHand.get(2).getRank() == 6 ||playerHand.get(2).getRank() == 7)
		{
			if(bankerHandValue == 0 || bankerHandValue == 1 || bankerHandValue == 2 || bankerHandValue == 3||bankerHandValue == 4 || bankerHandValue == 5|| bankerHandValue == 6) {
				bankerHand.addCard(deck.topCard());
			}
		}
		else if (playerHand.get(2).getRank() == 8) {
			if(bankerHandValue == 0 || bankerHandValue == 1 || bankerHandValue == 2)
			{
				bankerHand.addCard(deck.topCard());
			}
		}
		else if(playerHand.get(2).getRank() == 1 ||playerHand.get(2).getRank() == 9 ||playerHand.get(2).getRank() == 10)
		{
			if(bankerHandValue == 0 || bankerHandValue == 1 || bankerHandValue == 2|| bankerHandValue == 3) {
				bankerHand.addCard(deck.topCard());
			}
		}
		}
		
	}
	
	
	public void value()
	{
		int b = 0;
		int a = 0;
		
		while(playerHand.size()>a)
		{
			int value = 0;
			value = playerHand.get(a).getRank();
			if(value >10) {
				if(value >= 13)
				{
					value = 0;
				}
				else if (value == 14)
				{
					value = 1;
				}
			}
			playerHandValue = playerHandValue + value;
			a++;
		}
		playHandValue = playHandValue % 10;
		
		
		while(bankerHand.size()>b)
		{	int values = 0;
		values = bankerHand.get(b).getRank();
		if(values > 10){
			if(values == 0) {
				values = 0;
			}
			if(values == 11) {
				values = 0;
			}
			else if(values == 12)
			{
				values = 0;
			}
			else if(values ==13)
					{
				values = 0;
			}
			else {
				values= 1;
			}
		}
			bankerHandValue = bankerHandValue + values;
			
			b++;
		}
		bankerHandValue = bankerHandValue % 10;
	}
	
	public void dealHand()
	{
		playerHand = new CardHand();
		bankerHand = new CardHand();
		playerHand.addCard(deck.dealCard());
		bankerHand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		bankerHand.addCard(deck.dealCard());
		
	}
	public void playerHandPrint()
	{
		comm.println("Player Hand:");
		comm.print(playerHand);
		comm.println("");
	}
	public void bankerHandPrint()
	{
		comm.println("Banker's Hand:");
		comm.print(bankerHand);
		comm.println("");
	}
	
	public void whoBet()
	{
		comm = new ConsoleComunicationController();
		comm.print("You can bet on P (player), B (banker) or T(tie)");
		comm.println("");
		betOn = comm.getInput_char("Who would you like to bet on?");
		boolean valid  = false;
		valid = validBet(betOn);
		if (valid == false) {
		betPerson();
		}
	}
	public void betPerson()
	{
		betOn = comm.getInput_char("Please enter a valid input:");
		boolean valid  = false;
		valid = validBet(betOn);
		if (valid == false)
		{
			betPerson();
		}
	}

	

	public boolean validBet(char a)
	{
		boolean trd;
		if(a == 'P' || a == 'p') {
			trd = true;
		}
		else if(a == 'B' || a == 'b') {
			trd = true;
		}
		else if(a == 'T' || a == 't') {
			trd = true;
		}
		else {
			trd = false;
		}
		return trd;
	}
	
	
	
	
	//getters
	public int getPlayerNumCards() {
		return playerNumCards;
	}
	public void setPlayerNumCards(int playerNumCards) {
		this.playerNumCards = playerNumCards;
	}
	public int getBankerNumCards() {
		return bankerNumCards;
	}
	public void setBankerNumCards(int bankerNumCards) {
		this.bankerNumCards = bankerNumCards;
	}
	public CardHand getBankerHand() {
		return bankerHand;
	}
	public void setBankerHand(CardHand bankerHand) {
		this.bankerHand = bankerHand;
	}
	public CardHand getPlayerHand() {
		return playerHand;
	}
	public int getMoney() {
		return balance;
	}
	public int getBet() {
		return bet;
	}
	public char getBetOn() {
		return betOn;
	}
}
