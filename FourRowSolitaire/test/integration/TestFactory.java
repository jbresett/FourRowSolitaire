package test.integration;

import org.testng.annotations.Factory;

import test.integration.IntCardTest;

public class TestFactory {
	  
	  @Factory // Generates the entire deck
	  public Object[] cardTest() {
	   Object[] result = new Object[52]; 
	   for (int i = 1; i <= 52; i++) {
	      result[i-1] = new IntCardTest(i);
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

	  //@Factory // Generates the entire deck
	  public Object[] dealDeckTest() {
	    Object[] result = new Object[1];
	    //result[0] = new DealDeckTest();
	    return result;
	  }


	  
}
