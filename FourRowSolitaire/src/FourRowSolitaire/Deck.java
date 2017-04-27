package FourRowSolitaire;

import java.util.LinkedList;
import java.util.Random;

/**
 * Class: Deck
 *
 * Description: The Deck class holds all the Cards to form a 52 card deck.
 *
 */
public class Deck
{
    private int deckNumber;
    private LinkedList<Card> deck = new LinkedList<Card>();

    public Deck(int deckNumber)
    {
        this.deckNumber = deckNumber;
        shuffle();
    }

    public LinkedList<Card> getDeck()
    {
        return deck;
    }

    public LinkedList<Card> getDeck(LinkedList<Integer> numbers)
    {
        deck = new LinkedList<Card>();

        for(int i = 0; i < numbers.size(); i++)
        {
            if(numbers.get(i) > 0)
            {
                createCard(numbers.get(i));
            }
        }

        return deck;
    }

    public void shuffle()
    {
        LinkedList<Integer> numberList = new LinkedList<Integer>();

        for(int i = 1; i <= 52; i++)
        {
            numberList.add(i);
        }

        Random gen = new Random();

        for(int i = 0; i < 52; i++)
        {
            int num = gen.nextInt(numberList.size());

            int cardNumber = numberList.get(num);
            numberList.remove(num);

            createCard(cardNumber);
        }
    }

    private void createCard(int cardNumber)
    {
        deck.add(new Card(cardNumber));
    }
}