package test;

import org.testng.annotations.Test;

import FourRowSolitaire.Card;
import FourRowSolitaire.CardStack;
import FourRowSolitaire.Deck;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.LinkedList;

import org.testng.annotations.BeforeMethod;

public class DeckTest {
  private Deck[] deck;
  private Card[] cards;
  
  public boolean isEq(Card card1, Card card2) {
	  return card1.getFullNumber() == card2.getFullNumber();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  deck = new Deck[5];
	  for (int i = 0; i < 5; i++) {
		  deck[i] = new Deck(1);
	  }
	  cards = new Card[52];
	   for (int i = 1; i <= 13; i++) {
		   cards[i-1] = new Card(Card.SPADES_SUIT, i, 1, i);
		      cards[i+12] = new Card(Card.CLUBS_SUIT, i, 1, i + 13);
		      cards[i+25] = new Card(Card.DIAMONDS_SUIT, i, 1, i + 26);
		      cards[i+38] = new Card(Card.HEARTS_SUIT, i, 1, i + 39);
	   }
  }
  
  @Test
  public void getDeck() {
	  //Should return randomized 52 card deck.
	  assertEquals(deck[0].getDeck().size(), 52);
	  assertTrue((!deck[0].getDeck().pop().equals(deck[1].getDeck().pop()) 
			  	|| !deck[0].getDeck().pop().equals(deck[1].getDeck().pop())));
  }

  @Test
  public void getDeckLinkedListInteger() {
    // Linked List
	  LinkedList<Integer> cardIds = new LinkedList<>(); // A,2, and 3 of Hearts
	  LinkedList<Card> cardList;
	  cardIds.add(39);
	  cardIds.add(40);
	  cardIds.add(41);
	  deck[0].getDeck(cardIds);
	  cardList = deck[0].getDeck(cardIds);
	  assertEquals(cardList.size(),3);
	  for (int i = 0; i < cardIds.size(); i++) {
		  assertTrue(cardList.get(i).getFullNumber() >= 39 && cardList.get(i).getFullNumber() <= 41);
	  }
  }

  @Test
  public void shuffle() {
	  // CHeck first two cards to make sure they don't match (intial randomized).
	  assertTrue((!deck[0].getDeck().pop().equals(deck[1].getDeck().pop()) 
			  	|| !deck[0].getDeck().pop().equals(deck[1].getDeck().pop())));

	  // Check deck vs. re-shuffled version, at least one card in first two should
	  // be different in most test runs.
	  Card cards[] = new Card[2];
	  cards[0] = deck[0].getDeck().peek();
	  cards[1] = deck[1].getDeck().peek();
	  assertTrue((!deck[0].getDeck().pop().equals(cards[0]) 
			  	|| !deck[0].getDeck().pop().equals(cards[1])));
  }
}
