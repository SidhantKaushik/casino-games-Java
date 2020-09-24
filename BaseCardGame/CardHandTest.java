import static org.junit.Assert.*;

import org.junit.Test;

public class CardHandTest {

	private CardHand ab = new CardHand();
	private Deck ac = new Deck();
	@Test
	public void testToString() {
		for(int i=0; i<12; i++) {
		ab.addCard(ac.dealCard());
		
		}
		System.out.println(ab.toString());
	}

}
