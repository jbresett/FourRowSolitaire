package test;

import FourRowSolitaire.Card;
import FourRowSolitaire.Card.Color;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author then0
 */
public class CardTest {
    
    public CardTest() {
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
     * Test of highlight method, of class Card.
     */
    @Test
    public void testHighlight() {
        System.out.println("highlight");
        Card instance = new Card("Spades",13,0,1);
        instance.highlight();
        boolean expResult = true;
        boolean result = instance.isHighlighted();
        assertEquals(expResult, result);
    }

    /**
     * Test of unhighlight method, of class Card.
     */
    @Test
    public void testUnhighlight() {
        System.out.println("unhighlight");
        Card instance = new Card("Spades",13,0,1);
        instance.unhighlight();
        boolean expResult = false;
        boolean result = instance.isHighlighted();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFaceUp method, of class Card.
     */
    @Test
    public void testSetFaceUp() {
        System.out.println("setFaceUp");
        Card instance = new Card("Spades",13,0,1);
        instance.setFaceUp();
        boolean expResult = true;
        boolean result = instance.isFaceUp();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFaceDown method, of class Card.
     */
    @Test
    public void testSetFaceDown() {
        System.out.println("setFaceDown");
        Card instance = new Card("Spades",13,0,1);
        instance.setFaceDown();
        boolean expResult = false;
        boolean result = instance.isFaceUp();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidSuit method, of class Card.
     */
    @Test
    public void testIsValidSuit() {
        System.out.println("isValidSuit");
        boolean expResult = true;
        
        //Spades suit test
        Card instance = new Card("Spades",13,0,1);
        String suit = "Spades";
        boolean result = instance.isValidSuit(suit);
        assertEquals(expResult, result);
        
        //Hearts suit test
        Card instance1 = new Card("Hearts",13,1,1);
        String suit2 = "Hearts";
        boolean result2 = instance1.isValidSuit(suit2);
        assertEquals(expResult, result2);
        
        //Clubs suit test
        Card instance2 = new Card("Clubs",13,0,1);
        String suit3 = "Clubs";
        boolean result3 = instance2.isValidSuit(suit3);
        assertEquals(expResult, result3);
        
        //Diamonds suit test
        Card instance3 = new Card("Diamonds",13,1,1);
        String suit4 = "Diamonds";
        boolean result4 = instance3.isValidSuit(suit4);
        assertEquals(expResult, result4);
        
    }

    /**
     * Test of getNumber method, of class Card.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        Card instance = new Card("Spades",13,0,1);
        int expResult = 13;
        int result = instance.getNumber().ordinal();
        assertEquals(expResult, result);

    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        System.out.println("getSuit");
        Card instance = new Card("Spades",13,0,1);
        String expResult = "Spades";
        String result = instance.getSuit().toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class Card.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Card instance = new Card("Spades",13,0,1);
        Color expResult = Color.BLACK;
        Color result = instance.getColor();
        assertEquals(expResult, result);
    }


    
}
