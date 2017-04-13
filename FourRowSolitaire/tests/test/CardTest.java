package test;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import FourRowSolitaire.Card;

public class CardTest {
  private String suit;
  private int cardNumber, fullCardNumber;
  private Card card;
  
  public CardTest(String suit, int cardNumber, int deckNumber, int fullCardNumber) {
	  this.suit = suit;
	  this.cardNumber = cardNumber;
	  this.fullCardNumber = fullCardNumber;
	  this.card = new Card(suit, cardNumber, deckNumber, fullCardNumber);
  }
  
  @Test
  public void equals() {
	  assertEquals(card,card.clone(),"Card not .equal() to it's clone: " + card);
  }

  @Test
  public void color() {
	  int color;

	  switch (suit) {
	  case Card.DIAMONDS_SUIT:
	  case Card.HEARTS_SUIT:
	  	color = 1; // Red
	    break;
	  case Card.CLUBS_SUIT:
	  case Card.SPADES_SUIT:
		color = 0; // black
		break;
	  default:
		 fail("Card suit is invalid.");
		 return;
	  }
	  assertEquals(card.getColor(),color,"Card suit is invalid.");
  }

  @Test
  public void getNumber() {
	  assertEquals(card.getNumber(), cardNumber);
	  assertEquals(card.getFullNumber(), fullCardNumber);
  }
  
  @Test
  public void getSuit() {
	  assertEquals(card.getSuit(), suit);
  }

  @Test
  public void isHighlighted() {
	  card.highlight();
	  assertTrue(card.isHighlighted());
	  card.unhighlight();
	  assertTrue(!card.isHighlighted());
  }

  @Test
  public void isFaceUp() {
	  card.setFaceUp();
	  assertTrue(card.isFaceUp());
	  card.setFaceDown();
	  assertTrue(!card.isFaceUp());
  }

  @Test
  public void isValidSuit() {
	assertTrue(card.isValidSuit(card.getSuit()),"Invalid Suit: " + cardNumber + " of " + suit + "(ID# " + fullCardNumber + ")");	  
	assertTrue(!card.isValidSuit("Insert Random Text"));
  }

}
