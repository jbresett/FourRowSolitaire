package test;

import FourRowSolitaire.AcePile;
import FourRowSolitaire.Card;
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
public class AcePileTest {
    
    public AcePileTest() {
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
     * Test of getSuit method, of class AcePile.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        AcePile instance = new AcePile(Card.Suit.SPADES);
        Card.Suit expResult = Card.Suit.SPADES;
        Card.Suit result = instance.getSuit();
        assertEquals(expResult, result);
    }

    /**
     * Test of push method, of class AcePile.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Card card = new Card(1);
        AcePile instance = new AcePile(Card.Suit.SPADES);
        Card expResult = card;
        Card result = instance.push(card);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidMove method, of class AcePile.
     */
    @Test
    public void testIsValidMove_Card() {
        System.out.println("isValidMove");
        Card card = new Card(1);
        AcePile instance = new AcePile(Card.Suit.SPADES);
        boolean expResult = true;
        boolean result = instance.isValidMove(card);
        assertEquals(expResult, result);
    }

}
