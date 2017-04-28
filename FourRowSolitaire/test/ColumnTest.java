package test;

import FourRowSolitaire.Card;
import FourRowSolitaire.Column;
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
public class ColumnTest {
    
    public ColumnTest() {
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
     * Test of push method, of class Column.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Card card =  new Card("Spades",13,0,1);
        Column instance = new Column();
        Card expResult = card;
        Card result = instance.push(card);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidMove method, of class Column.
     */
    @Test
    public void testIsValidMove_Card() {
        System.out.println("isValidMove");
        Card card =  new Card("Spades",13,0,1);
        Column instance = new Column();
        boolean expResult = true;
        boolean result = instance.isValidMove(card);
        assertEquals(expResult, result);
    }
    
    
}
