import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    Game game;
    Dealer dealer;
    Player player;
    Player player2;
    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
        dealer = new Dealer();
        player = new Player("Frank");
        player2 = new Player("Ralph");
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player);
        players.add(player2);
        game = new Game(deck, dealer, players);
    }

    @Test
    public void canDealOpeningHand(){
        game.dealHand();
        assertEquals(2, player.numOfCards());
        assertEquals(2, player2.numOfCards());
        assertEquals(2, dealer.numOfCards());
    }

    @Test
    public void canCheckForDraw(){
        Card card1 = new Card(SuitType.CLUBS, RankType.TEN);
        Card card2 = new Card(SuitType.CLUBS, RankType.TWO);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player2.addCardToHand(card1);
        player2.addCardToHand(card2);
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card2);
        assertTrue(game.checkDraw());
    }

    @Test
    public void canCheckForStuck(){
        Card card1 = new Card(SuitType.CLUBS, RankType.TEN);
        Card card2 = new Card(SuitType.CLUBS, RankType.TWO);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player2.addCardToHand(card1);
        player2.addCardToHand(card2);
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card1);
        player.setStickOrTwist(StatusType.STICK);
        player2.setStickOrTwist(StatusType.STICK);
        assertTrue(game.checkStuck());
    }

    @Test
    public void canCheckForBust(){
        Card card1 = new Card(SuitType.CLUBS, RankType.TEN);
        Card card2 = new Card(SuitType.CLUBS, RankType.TWO);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player2.addCardToHand(card1);
        player2.addCardToHand(card1);
        player2.addCardToHand(card1);
        game.checkBust();
        assertEquals(1, game.getNumOfPlayers());
    }

//    @Test
//    public void canCheckForWinner(){
//        Card card1 = new Card(SuitType.CLUBS, RankType.TEN);
//        Card card2 = new Card(SuitType.CLUBS, RankType.TWO);
//        player.addCardToHand(card1);
//        player.addCardToHand(card2);
//        dealer.addCardToHand(card2);
//        dealer.addCardToHand(card2);
//        assertTrue(game.checkWinner() instanceof Player);
//    }

    @Test
    public void willOnlyCheckForWinnerIfBothPlayerAndDealerHaveStuck(){
        Card card1 = new Card(SuitType.CLUBS, RankType.TEN);
        Card card2 = new Card(SuitType.CLUBS, RankType.TWO);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player2.addCardToHand(card2);
        player2.addCardToHand(card2);
        dealer.addCardToHand(card1);
        dealer.addCardToHand(card1);
        player.setStickOrTwist(StatusType.STICK);
        player2.setStickOrTwist(StatusType.STICK);
        assertTrue(game.checkWinner() instanceof Dealer);
    }

}
