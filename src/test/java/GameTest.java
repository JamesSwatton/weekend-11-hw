import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game;
    Dealer dealer;
    Player player;
    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer();
        player = new Player();
        game = new Game(deck, dealer, player);
    }

    @Test
    public void canDealOpeningHand(){
        game.dealOpeningHand();
        assertEquals(2, player.showHand().size());
        assertEquals(2, dealer.showHand().size());
    }
}
