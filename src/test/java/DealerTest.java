import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DealerTest {

    Dealer dealer;
    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer();
    }

    @Test
    public void canDealCard(){
        assertNotNull(dealer.dealCard(deck));
        assertNotNull(dealer.dealCard(deck));
        assertEquals(50, deck.numOfCards());
    }
}
