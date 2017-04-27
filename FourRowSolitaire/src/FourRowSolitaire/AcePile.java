//Jesse BranchTest
//Jesse PullTest

package FourRowSolitaire;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import FourRowSolitaire.Card.Suit;

/**
 * Class: AcePile
 *
 * Description: The AcePile class manages one of the four foundation stacks.
 * Extends: CardStack
 */
@SuppressWarnings("serial")
public class AcePile extends CardStack
{
	//Declare suit variable for ace piles
    private String suitStr;
    private Suit suit;

    /**
	 * Constructor to set up ace piles
	 * @param suit
	 */
    public AcePile(String suitStr)
    {
        this.suitStr = suitStr;
    }

    public AcePile(Suit suit)
    {
        this.suit = suit;
    }
    
    /**
	 * Gets suit
	 * @return
	 */
    public Suit getSuit()
    {
        return suit;
    }

    /**
	 * Pushes card to ace pile if its an ace or one card above the card 
	 * showing on the ace pile
	 * @param card
	 * @return
	 */
    public Card push(Card card)
    {
        if(isEmpty() && card.getSuit().equals(suit) && card.getNumber() == Card.Number.ACE)
        {
            super.push(card);
            return card;
        }
        else if(card.getSuit().equals(suit) && card.getNumber() == peek().getNumber().mod(1))
        {
            super.push(card);
            return card;
        }

        return null;
    }

    /**
	 * Returns peek() of stack
	 * @param p
	 * @return
	 */
    public Card getCardAtLocation(Point p)
    {
        return peek();
    }

    /**
	 * Checks if the next card pushed to ace pile is a valid move
	 * @return
	 */
    public boolean isValidMove(Card card)
    {    	
        if(isEmpty() && card.getSuit().equals(suit))
        {
            return true;
        }
        else if(!isEmpty() && card.getSuit().equals(suit) && card.getNumber() == (peek().getNumber().mod(1)))
        {
            return true;
        }

        return false;
    }

    /**
	 * Return false
	 * @return
	 */
    public boolean isValidMove(CardStack stack)
    {
        return false;
    }

    /**
	 * Paints image of the acePile
	 * @param g
	 */
    public void paint(Graphics g)
    {
        super.paint(g);
        
        for(int i = 0; i < length(); i++)
        {
            Image image = getCardAtLocation(i).getImage();
            g.drawImage(image, 0, 0, null);
        }
    }
}
