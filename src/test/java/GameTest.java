import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals(2, player.numOfCards());
        assertEquals(2, dealer.numOfCards());
    }

    @Test
    public void canCheckForDraw(){
        Card card1 = new Card(SuitType.CLUBS, RankType.THREE);
        Card card2 = new Card(SuitType.CLUBS, RankType.TWO);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card2);
        assertEquals(true, game.checkDraw());
    }

    @Test
    public void canCheckForWinner(){
        Card card1 = new Card(SuitType.CLUBS, RankType.TEN);
        Card card2 = new Card(SuitType.CLUBS, RankType.TWO);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        dealer.addCardToHand(card2);
        dealer.addCardToHand(card2);
        assertTrue(game.checkWinner() instanceof Player);
    }
}
