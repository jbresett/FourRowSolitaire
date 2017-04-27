package FourRowSolitaire;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * Class: Card
 *
 * Description: The Card class holds information pertaining to 1 out of the 52 cards per deck.
 *
 */
public class Card extends JComponent
{
	public enum Suit {
		SPADES(Color.RED,0), 
		CLUBS(Color.BLACK,1), 
		DIAMONDS(Color.BLACK,2), 
		HEARTS(Color.RED,3), 
		INVALID(Color.INVALID,-1);

		private Color color;
		private int acePile;
		
		private Suit(Color color, int acePile) {
			this.color = color;
			this.acePile = acePile;
		}
		
		@Override
		public String toString() {
			return name().substring(0, 1) + name().substring(1).toLowerCase();
		}
		
		public static Suit get(String name) {
			for (Suit suit: Suit.values()) {
				if (suit.name().equalsIgnoreCase(name)) return suit;
			}
			return INVALID;
		}		
		
		public int acePile() {
			return acePile;
		}
		
		public String letter() {
			return name().substring(0, 1).toLowerCase();
		}
		
		public Color getColor() {
			return color;
		}
	}
	
	public enum Number {
		// 0 - 13
		INVALID, ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

		public static Number get(String name) {
			for (Number n: Number.values()) {
				if (n.name().equalsIgnoreCase(name)) return n;
			}
			return INVALID;
		}
		
		@Override
		public String toString() {
			return name().substring(0, 1) + name().substring(1).toLowerCase();
		}
		
		// Returns a card based on the value difference, eg TEN.mod(1) = JACK.
		public Number mod(int diff) {
			int index = ordinal() + diff;
			if (index < 0 || index >= Number.values().length) return Number.INVALID;
			return Number.values()[index];
		}
	}
	
	public enum Color {
		BLACK, RED, INVALID;
			
		@Override
		public String toString() {
			return name().substring(0, 1) + name().substring(1).toLowerCase();
		}		
	}

	private Suit suit;
	private Number number;
    private int fullCardNumber; // 1 - 52
	
    private int deckNumber;

    private BufferedImage image; //Takes either card back or front

    private String cardBack; //The back design
    private String cardImageString; //The card front
    private String cardHighlighted; //The highlighted card front

    private boolean faceUp = false;
    private boolean highlighted = false;

    private String location = ""; //To notify the discard pile of moves from the deck

    public Card(Suit suit, int number, int deckNumber, int fullNumber)
    {
        if((number >= 1 && number <= 13))
        {
            this.suit = suit;
            this.number = Number.values()[number];
            fullCardNumber = fullNumber;
            this.deckNumber = deckNumber;

            if(deckNumber >= 1 && deckNumber <= ChangeAppearance.NUM_DECKS)
            {
                cardBack = "/images/cardbacks/cardback" + deckNumber + ".png";
            }
            else
            {
                cardBack = "/images/cardbacks/cardback3.png";
            }

            cardImageString = "/images/cardfaces/" + this.suit.letter() + this.number.toString() + ".png";
            cardHighlighted = "/images/highlightedfaces/" + this.suit.letter() + this.number.toString() + "H.png";
            
        }
        else
        {
            this.suit = Suit.INVALID;
            this.number = Number.INVALID;
            cardImageString = "/images/invalidcard.png";
        }

        setFaceUp();
    }

	public void highlight()
    {
        highlighted = true;

        try
        {
            URL imageURL = this.getClass().getResource(cardHighlighted);

            if (imageURL != null)
            {
                image = ImageIO.read(imageURL);
            }
        }
        catch(IOException ex)
        {
            System.err.println("Error in creating highlighted card face image.");
        }

        repaint();
    }

    public void unhighlight()
    {
        highlighted = false;

        setFaceUp();
    }

    public boolean isHighlighted()
    {
        return highlighted;
    }

    public void setFaceUp()
    {
        faceUp = true;

        try
        {
            URL imageURL = this.getClass().getResource(cardImageString);
            
            if (imageURL != null)
            {
                image = ImageIO.read(imageURL);
            }
        }
        catch(IOException ex)
        {
            System.err.println("Error in creating card face image.");
        }
    }

    public void setFaceDown()
    {
        faceUp = false;

        try
        {
            URL imageURL = this.getClass().getResource(cardBack);

            if (imageURL != null)
            {
                image = ImageIO.read(imageURL);
            }
        }
        catch(IOException ex)
        {
            System.err.println("Error in creating card back image.");
        }
    }

    public boolean isFaceUp()
    {
        return faceUp;
    }

    public boolean isValidSuit(String suit)
    {
    	return (Suit.get(suit) != Suit.INVALID);
    }

    public BufferedImage getImage()
    {
        return image;
    }

    public Number getNumber()
    {
        return number;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public Color getColor()
    {
        return suit.getColor();
    }

    public int getFullNumber()
    {
        return fullCardNumber;
    }

    public String getSource()
    {
        return location;
    }

    public void setSource(String source)
    {
        location = source;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public Card clone()
    {
        Card card = new Card(suit, number.ordinal(), deckNumber, fullCardNumber);
        return card;
    }

    @Override
	public int hashCode() 
    {
		final int prime = 31;
		int result = 1;
		result = prime * result + number.hashCode();
		result = prime * result + suit.hashCode();
		result = prime * result + deckNumber;
		result = prime * result + fullCardNumber;
		return result;
	}

    @Override
    public String toString() {
    	return number + " of " + suit;
    }
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if ((obj == null) || (getClass() != obj.getClass())) return false;
		Card other = (Card) obj;
		return (number == other.number)	&&
				(suit == other.suit) &&
				(deckNumber == other.deckNumber) &&
				(fullCardNumber == other.fullCardNumber);
		
	}    
}