
package FourRowSolitaire;

import java.awt.*;
import java.util.Vector;
import javax.swing.JLayeredPane;

/**
 * Class: CardStack
 *
 * Description: The Cardstack class manages a location for cards to be placed.
 *
 */
public class CardStack extends JLayeredPane
{
    private Vector<Card> cards = new Vector<Card>();

    public CardStack() {}

    //For starting the game
    public void addCard(Card card)
    {
        cards.add(card);
        card.setBounds(0, 0, 72, 96);
        add(card, 0);
    }
    
    protected Vector<Card> getCards() {
    	return cards;
    }

    public void addStack(CardStack stack)
    {
        for(int i = stack.length(); i > 0; i--)
        {
            Card card = stack.pop();
            addCard(card);
        }
    }

    public Card push(Card card)
    {
        cards.add(card);
        card.setBounds(0, 0, 72, 96);
        add(card, 0);
        return card;
    }

    public CardStack push(CardStack stack)
    {
        while(!stack.isEmpty())
        {
            Card card = stack.pop();
            push(card);
        }

        return stack; //returns empty stack
    }

    public synchronized Card pop()
    {
    	Card card = peek();
        this.remove(card);
        cards.remove(cards.size() - 1);

	return card;
    }

    public CardStack pop(CardStack stack)
    {
        //Temporary reverse pop of entire stack transfer
        CardStack temp = new CardStack();

        while(!stack.isEmpty())
        {
            Card card = stack.pop();
            temp.push(card);
            this.remove(card);
        }

        return temp;
    }

    public synchronized Card peek()
    {
	if (cards.isEmpty())
        {
            return null;
        }

	return cards.lastElement();
    }

    public boolean isEmpty()
    {
	return cards.size() == 0;
    }

    public int length()
    {
        return cards.size();
    }

    public synchronized int search(Card card)
    {
	int i = cards.lastIndexOf(card);

	if (i >= 0)
        {
	    return cards.size() - i;
	}

	return -1;
    }

    public Card getCardAtLocation(int index)
    {
        if(index < cards.size())
        {
            return cards.get(index);
        }

        return null;
    }

    public Card getCardAtLocation(Point p)
    {
        if(cards.isEmpty())
        {
            return null;
        }
        
        if(isValidClick(p))
        {
            int y = (int)p.getY();

            int index;

            if(y > 25 * (cards.size() - 1))
            {
                index = cards.size() - 1;
            }
            else
            {
                index = y / 25;
            }

            if(isValidCard(index))
            {
                return cards.get(index);
            }
        }
        
        return null;
    }

    //Verifies that the card is a part of a valid stack
    private boolean isValidCard(int index)
    {
        if(index >= cards.size())
        {
            return false;
        }
        
        for(int i = index; i < cards.size() - 1; i++)
        {
            //Cards are not opposite colors or decreasing in value correctly
            if(cards.get(i).getColor() == cards.get(i + 1).getColor() ||
                    cards.get(i).getNumber() != (cards.get(i + 1).getNumber().mod(1)))
            {
                return false;
            }
        }

        return true;
    }

    //Checks if clicked area is defined on a card in the stack
    private boolean isValidClick(Point p)
    {
        int y = (int)p.getY();

        if(!isEmpty())
        {
            if(y > 25 * (cards.size() - 1) + cards.lastElement().getBounds().getHeight())
            {
                return false;
            }
        }

        return true;
    }

    public CardStack getStack(Card card)
    {
        CardStack temp = new CardStack();
        int index = search(card);
        
        for(int i = 0; i < index; i++)
        {
            temp.push(getCardAtLocation(cards.size() - i - 1).clone());
            getCardAtLocation(cards.size() - i - 1).highlight();
        }

        return temp;
    }

    public CardStack getStack(int numCards)	//Undo for stack, fixed by Kailab Bowler
    {
        CardStack temp = new CardStack();
        int index = length() - numCards;

        for(int i = length() - 1; i >= index; i--)
        {
        	temp.push(getCardAtLocation(i).clone());
        	getCardAtLocation(i).highlight();
        }
        for(int i = length() - 1; i >= index; i--)
        {
        	pop();
        }
        return temp;
    }

    public boolean isValidMove(Card card)
    {
        return false;
    }

    public boolean isValidMove(CardStack stack)
    {
        return false;
    }

    public Card getBottom()
    {
        return cards.firstElement();
    }

    public CardStack getAvailableCards()
    {
    	if (isEmpty()) return null;  //for deck and ace piles
    	
    	CardStack temp = new CardStack();
        temp.addCard(peek());
        return temp;
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        
        if(!isEmpty())
        {
            for(int i = 0; i < cards.size(); i++)
            {
                Image image = cards.get(i).getImage();
                g.drawImage(image, 0, i * 25, null);
            }
        }
    }
}