package test.testNG;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import FourRowSolitaire.Card;

public class CardTest {
  private Card.Suit suit;
  private int cardNumber, fullCardNumber;
  private Card card;
  
  public CardTest(int fullCardNumber) {
	  this.card = new Card(fullCardNumber);
	  this.suit = card.getSuit();
	  this.cardNumber = card.getNumber().ordinal();
	  this.fullCardNumber = fullCardNumber;
  }
  
  @Test
  public void equals() {
	  assertEquals(card,card.clone(),"Card not .equal() to it's clone: " + card);
  }

  @Test
  public void color() {
	  Card.Color color;

	  switch (suit) {
	  case DIAMONDS:
	  case HEARTS:
	  	color = Card.Color.RED; // Red
	    break;
	  case CLUBS:
	  case SPADES:
		color = Card.Color.BLACK; // black
		break;
	  default:
		 fail("Card suit is invalid.");
		 return;
	  }
	  assertEquals(card.getColor(),color,"Card suit is invalid.");
  }

  @Test
  public void getNumber() {
	  assertEquals(card.getNumber().ordinal(), cardNumber);
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
	assertTrue(card.isValidSuit(card.getSuit().toString()),"Invalid Suit: " + cardNumber + " of " + suit + "(ID# " + fullCardNumber + ")");	  
	assertTrue(!card.isValidSuit("Insert Random Text"));
  }

}
