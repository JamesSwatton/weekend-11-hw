import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeckTest {

    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void has52Cards(){
        assertEquals(52, deck.numOfCards());
    }

    @Test
    public void canGetCard(){
        assertNotNull(deck.dealCard());
        assertEquals(51, deck.numOfCards());
    }
}
