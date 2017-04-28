package test;

import FourRowSolitaire.Card;
import FourRowSolitaire.DiscardPile;
import java.awt.Graphics;
import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elizabeth Layman
 */
public class DiscardPileTest {
    
    public DiscardPileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDrawCount method, of class DiscardPile.
     */
    @Test
    public void testSetDrawCount() {
        System.out.println("setDrawCount");
        int draw = 1;
        DiscardPile instance =  new DiscardPile(1);
        instance.setDrawCount(draw);
    }

    /**
     * Test of getNumViewableCards method, of class DiscardPile.
     */
    @Test
    public void testGetNumViewableCards() {
        System.out.println("getNumViewableCards");
        DiscardPile instance =  new DiscardPile(1);
        int expResult = 0;
        int result = instance.getNumViewableCards();
        assertEquals(expResult, result);
    }

    /**
     * Test of setView method, of class DiscardPile.
     */
    @Test
    public void testSetView() {
        System.out.println("setView");
        int numViewableCards = 1;
        DiscardPile instance = new DiscardPile(1);
        instance.setView(numViewableCards);
    }

    /**
     * Test of addCard method, of class DiscardPile.
     */
    @Test
    public void testAddCard() {
        System.out.println("addCard");
        Card card = new Card("Spades",13,0,1);
        DiscardPile instance = new DiscardPile(1);
        instance.addCard(card);
    }

    /**
     * Test of push method, of class DiscardPile.
     */
    @Test
    public void testPush_Card() {
        System.out.println("push");
        Card card = new Card("Spades",13,0,1);
        DiscardPile instance = new DiscardPile(1);
        Card expResult = card;
        Card result = instance.push(card);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidMove method, of class DiscardPile.
     */
    @Test
    public void testIsValidMove_Card() {
        System.out.println("isValidMove");
        Card card =  new Card("Spades",13,0,1);
        DiscardPile instance = new DiscardPile(1);
        boolean expResult = true;
        if(!card.getSource().equals("Deck"))
        {
            expResult = false;
        }
        boolean result = instance.isValidMove(card);
        assertEquals(expResult, result);
    }
}
