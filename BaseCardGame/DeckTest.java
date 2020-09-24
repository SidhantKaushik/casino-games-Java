import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {
	private CardHand ac;
	private Deck ab;
	private ConsoleComunicationController comm = new ConsoleComunicationController();
	@Test
	void testGetSuit() {
		ac = new CardHand();
		ab = new Deck();
		int expect = ab.topCard().getSuit();
		ac.addCard(ab.dealCard());
		int recieved = ac.get(0).getSuit();
		assertEquals("testing suit", expect, recieved);
	}
	@Test
	void testGetRank()
	{
		ac = new CardHand();
		ab = new Deck();
		int expect = ab.topCard().getRank();
		ac.addCard(ab.dealCard());
		int recieved = ac.get(0).getRank();
		assertEquals("Testing rank", expect, recieved);
	}

	@Test
	void testSuit()
	{
		ac = new CardHand();
		Card ad = new Card(11, 2);
		ab = new Deck();
		ac.addCard(ad);
		assertEquals("testing for jack", "Jack of Spades",(ad.toString()));
		Card ae = new Card(12, 2);
		assertEquals("testing for queen", "Queen of Spades",(ae.toString()));
		Card af = new Card(13, 3);
		assertEquals("testing for king", "King of Clubs",(af.toString()));
	}
	@Test
	void handCards()
	{
		ac = new CardHand();
		ab = new Deck();
		ac.addCard(ab.dealCard());
		ac.addCard(ab.dealCard());
		ac.addCard(ab.dealCard());
		int recieved = ac.size();
		assertEquals("Checking if hand is getting filled", 3 , recieved);
	}
	@Test
	void newCard()
	{
		ac = new CardHand();
		ab = new Deck();
		Card expected = ab.topCard();
		ac.addCard(ab.dealCard());
		assertEquals("Seeing if card same", expected, ac.get(0));
	}
	@Test
	void checkShuffle()
	{
		ab = new Deck();
		CardHand expected = ab.dealHand(3);
		ab.shuffle();
		//WANT TO FAIL
		assertEquals(expected, ab.dealHand(3));
}
	
}