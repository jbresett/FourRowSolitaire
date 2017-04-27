
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