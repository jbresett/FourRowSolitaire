package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import FourRowSolitaire.*;

public class DealDeckTest {
	DealDeck deck;
	DiscardPile pile;
	
  @BeforeMethod
  public void beforeMethod() {
	  pile = new DiscardPile(3);
	  deck = new DealDeck(pile, 3);
	  //deck.
  }	
	  
  @Test
  public void DealDeck() {
  }

  @Test
  public void getDeckThroughs() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void hasDealsLeft() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void isValidMoveCard() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void isValidMoveCardStack() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void pop() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void reset() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setDeck() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setDeckThroughs() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setDifficulty() {
    
	  //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setDrawCount() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void undoPop() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void undone() {
    throw new RuntimeException("Test not implemented");
  }
}
