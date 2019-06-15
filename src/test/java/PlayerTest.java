import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Dealer dealer;
    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer();
        player = new Player();
    }

    @Test
    public void canBeDealtHand(){
        player.addCardToHand(dealer.dealCard(deck));
        player.addCardToHand(dealer.dealCard(deck));
        assertEquals(2, player.showHand().size());
    }
}
