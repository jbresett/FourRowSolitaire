package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 *
 * @author Elizabeth Layman
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({test.AcePileTest.class,test.CardTest.class,test.ColumnTest.class,test.DiscardPileTest.class,test.SingleCellTest.class})

public class FourRowSolitaireTestSuite {}
