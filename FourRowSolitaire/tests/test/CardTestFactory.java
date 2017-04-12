package test;

import org.testng.annotations.Factory;
import FourRowSolitaire.Card;

public class CardTestFactory {
	  
	@Factory // Generates the entire deck
	  public Object[] createCards() {
	   Object[] result = new Object[52]; 
	   for (int i = 1; i <= 13; i++) {
	      result[i-1] = new CardTest(Card.SPADES_SUIT, i, 1, i);
	      result[i+12] = new CardTest(Card.CLUBS_SUIT, i, 1, i + 13);
	      result[i+25] = new CardTest(Card.DIAMONDS_SUIT, i, 1, i + 26);
		  result[i+38] = new CardTest(Card.HEARTS_SUIT, i, 1, i + 39);
	    }
	    return result;
	  }

}
