import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals(2, player.numOfCards());
    }

    @Test
    public void canGetHandTotal(){
        Card card1 = new Card(SuitType.CLUBS, RankType.FIVE);
        Card card2 = new Card(SuitType.CLUBS, RankType.THREE);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        assertEquals(8, player.getHandTotal());
    }

    @Test
    public void canEmptyHand(){
        player.addCardToHand(dealer.dealCard(deck));
        player.addCardToHand(dealer.dealCard(deck));
        player.emptyHand();
        assertEquals(0, player.numOfCards());
    }

    @Test
    public void canTwistOrStick(){
        player.setStickOrTwist(StatusType.STICK);
        assertEquals(StatusType.STICK, player.getStickOrTwist());
    }

    @Test
    public void canGoBust(){
        Card card1 = new Card(SuitType.CLUBS, RankType.TEN);
        Card card2 = new Card(SuitType.CLUBS, RankType.JACK);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player.addCardToHand(card2);
        assertTrue(player.getIsBust());
    }

    @Test
    public void canGetBlackjack(){
        Card card1 = new Card(SuitType.CLUBS, RankType.TEN);
        Card card2 = new Card(SuitType.CLUBS, RankType.ACE);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        assertTrue(player.getHasBlackjack());
    }
}
