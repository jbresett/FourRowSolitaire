package test.testNG;

import org.testng.annotations.Test;

import FourRowSolitaire.Card;
import FourRowSolitaire.CardStack;
import FourRowSolitaire.Column;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


public class CardStackTest {
  static private final int MAX_STACK = 3; // Maximum number of stacks for test (0 to n-1)
  
  Card cards[];
  CardStack stacks[];

  // Test Supporting Functions
  public void printCard(Card card) {
	  System.out.println("< " + card.getNumber() + " " + card.getSuit() + " " + card.getColor() + ">");
  }
  
  // assertEquals() test doesn't work for .cloned cards due to .equals() not being properly designed in original
  // code for Card. Workaround until upgrade is done.
  public boolean isEq(Card card1, Card card2) {
	  return card1.getFullNumber() == card2.getFullNumber();
  }
  
  // Constructor
  @BeforeMethod
  public void beforeMethod() {
	  cards = new Card[52];
	   for (int i = 1; i <= 52; i++) {
		   cards[i-1] = new Card(i);
	   }
	   
	   stacks = new CardStack[MAX_STACK];
	   for (int i = 0; i < stacks.length; i++) {
		   stacks[i] = new CardStack();
	   }
	   
  }

  @AfterMethod
  public void afterMethod() {
  }

  @Test
  public void addCard() {
	stacks[0].addCard(cards[0]);
	assertEquals(stacks[0].peek(),cards[0]);
	stacks[0].addCard(cards[1]);
	assertEquals(stacks[0].peek(),cards[1]);
  }

  @Test
  public void addStack() {
	stacks[1].addCard(cards[0]);
	stacks[1].addCard(cards[1]);
	stacks[0].addStack(stacks[1]);
	assertEquals(stacks[0].peek(),cards[0]);
	stacks[0].pop();
	stacks[0].pop();
	assertTrue(stacks[0].isEmpty());
  }

  @Test
  public void getAvailableCards() {
	  // Gets # of cards of alternating colors and incrementing values.

	  // 1 card
	  stacks[0].push(cards[0]);
	  assertEquals(stacks[0].getAvailableCards().pop(), cards[0], "1-Card failed.");
	  
	  // Column of 2 cards + stack
	  stacks[1] = new Column();
	  stacks[1].push(cards[38]); // King of Diamonds
	  stacks[1].push(cards[11]); // Queen of Spades
	  stacks[2] = stacks[1].getAvailableCards();
	  assertEquals(2, stacks[2].length());
	  assertEquals(stacks[2].pop(),cards[38]);
	  assertEquals(stacks[2].pop(),cards[11]);

	  // 2 card stack + other cards before
	  stacks[1] = new Column();
	  stacks[1].addCard(cards[0]); // A of Spades
	  stacks[1].addCard(cards[38]); // King of Diamonds
	  stacks[1].addCard(cards[11]); // Queen of Spades
	  stacks[2] = stacks[1].getAvailableCards();
	  assertEquals(2, stacks[2].length());
	  assertEquals(stacks[2].pop(),cards[38]);
	  assertEquals(stacks[2].pop(),cards[11]);
	  
  }

  @Test
  public void getBottom() {
	  stacks[1] = new Column();
	  stacks[1].push(cards[38]);
	  stacks[1].push(cards[11]);
	  assertEquals(stacks[1].getBottom(),cards[38]);
	  
  }

  @Test
  public void getCardAtLocationint() {
	  stacks[1] = new Column();
	  stacks[1].push(cards[38]);
	  stacks[1].push(cards[11]);
	  stacks[1].push(cards[12]);
	  assertEquals(stacks[1].getCardAtLocation(1),cards[11]);
  }

  @Test
  public void getStackCard() {
	  // 2 card stack + other cards before
	  stacks[1] = new Column();
	  stacks[1].addCard(cards[0]); // A of Spades
	  stacks[1].addCard(cards[38]); // King of Diamonds
	  stacks[1].addCard(cards[11]); // Queen of Spades
	  stacks[2] = stacks[1].getStack(cards[38]);
	  assertTrue(isEq(cards[38],stacks[2].pop()));
	  assertTrue(isEq(cards[11],stacks[2].pop()));
  }

  @Test
  public void getStackint() {
	  stacks[1] = new CardStack();
	  stacks[1].addCard(cards[0]); // A of Spades
	  stacks[1].addCard(cards[38]); // King of Diamonds
	  stacks[1].addCard(cards[11]); // Queen of Spades
	  stacks[2] = stacks[1].getStack(2);
	  assertTrue(isEq(cards[38],stacks[2].pop()));
	  assertTrue(isEq(cards[11],stacks[2].pop()));
  }

  @Test
  public void isEmpty() {
    assertTrue(stacks[0].isEmpty());
    stacks[0].push(cards[38]);
    assertTrue(!stacks[0].isEmpty());
  }

  @Test
  public void length() {
	    assertEquals(stacks[0].length(),0);
	    stacks[0].push(cards[38]);
	    stacks[0].push(cards[37]);
	    assertEquals(stacks[0].length(),2);
  }

  @Test
  public void peek() {
	    stacks[0].push(cards[38]);
	    stacks[0].push(cards[37]);
	    assertEquals(stacks[0].peek(),cards[37]);
  }

  @Test
  public void pop() {
	    stacks[0].push(cards[38]);
	    stacks[0].push(cards[37]);
	    assertEquals(stacks[0].pop(),cards[37]);
	    assertEquals(stacks[0].pop(),cards[38]);
  }

  @Test
  public void popCardStack() {
	    stacks[0].push(cards[38]);
	    stacks[0].push(cards[37]);
	    stacks[1] = stacks[0].pop(stacks[0]);
	    assertEquals(stacks[1].pop(),cards[38]);
	    assertEquals(stacks[1].pop(),cards[37]);
	    assertTrue(stacks[0].isEmpty());
  }

  @Test
  public void pushCard() {
	  stacks[0].push(cards[38]);
	  assertEquals(stacks[0].pop(), cards[38]);
  }

  @Test
  public void pushCardStack() {
	  stacks[1].push(cards[38]);
	  stacks[1].push(cards[37]);
	  stacks[0].push(stacks[1]);
	  assertEquals(stacks[0].pop(), cards[38]);
	  assertEquals(stacks[0].pop(), cards[37]);
  }

  @Test
  public void search() {
	  stacks[0].push(cards[38]);
	  stacks[0].push(cards[37]);
	  assertEquals(stacks[0].search(cards[38]),2);
	  assertEquals(stacks[0].search(cards[37]),1);
  }
}
