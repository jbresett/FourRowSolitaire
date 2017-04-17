package test;

import org.testng.annotations.Factory;
import FourRowSolitaire.Card;

public class TestFactory {
	  
	  @Factory // Generates the entire deck
	  public Object[] cardTest() {
	   Object[] result = new Object[52]; 
	   for (int i = 1; i <= 13; i++) {
	      result[i-1] = new CardTest(Card.SPADES_SUIT, i, 1, i);
	      result[i+12] = new CardTest(Card.CLUBS_SUIT, i, 1, i + 13);
	      result[i+25] = new CardTest(Card.DIAMONDS_SUIT, i, 1, i + 26);
		  result[i+38] = new CardTest(Card.HEARTS_SUIT, i, 1, i + 39);
	    }
	    return result;
	  }
	  
	  @Factory
	  public Object[] cardStackTest() {
	    Object[] result = new Object[1];
	    result[0] = new CardStackTest();
	    return result;
	  }	  

	  @Factory // Generates the entire deck
	  public Object[] deckTest() {
	    Object[] result = new Object[1];
	    result[0] = new DeckTest();
	    return result;
	  }	  

	  @Factory // Generates the entire deck
	  public Object[] dealDeckTest() {
	    Object[] result = new Object[1];
	    result[0] = new DealDeckTest();
	    return result;
	  }	  

	  
}
