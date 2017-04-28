
package FourRowSolitaire;

/**
 * Class: Column
 *
 * Description: The Column class manages a single column on the board.
 *
 */
public class Column extends CardStack
{
    public Column() {}

    @Override
    public CardStack getAvailableCards() {
    	if (isEmpty()) return null;

        CardStack temp = new CardStack();
        boolean cardsMatch = true;
        int index = length() - 1;

        temp.addCard(getCards().get(index));

        do
        {
            index--;

            if(index >= 0)
            {
                Card card = getCards().get(index);

                if(card.getColor() != temp.peek().getColor() && card.getNumber() == temp.peek().getNumber().mod(1))
                {
                    temp.addCard(card);
                }
                else
                {
                    cardsMatch = false;
                }
            }
            else
            {
                cardsMatch = false;
            }

        } while(cardsMatch);

        return temp;

    }
    
    public Card push(Card card)
    {
        if(isEmpty() && card.getNumber() == Card.Number.KING)
        {
            super.push(card);
            return card;
        }
        else if(card.getColor() != peek().getColor() && card.getNumber() == peek().getNumber().mod(-1))
        {
            super.push(card);
            return card;
        }

        return null;
    }

    public boolean isValidMove(Card card)
    {
        if(isEmpty() && card.getNumber() == Card.Number.KING)
        {
            return true;
        }
        else if(!isEmpty() && card.getColor() != peek().getColor() && card.getNumber() == (peek().getNumber().mod(-1)))
        {
            return true;
        }

        return false;
    }

    public boolean isValidMove(CardStack stack)
    {
        return isValidMove(stack.peek());
    }
}