public class Game {

    Deck deck;
    Dealer dealer;
    Player player;

    public Game(Deck deck, Dealer dealer, Player player){
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
    }

    public void dealOpeningHand(){
        for(int i=0; i<2; i++){
            Card playerCard = dealer.dealCard(deck);
            player.addCardToHand(playerCard);
            dealer.dealCardToSelf(deck);
        }
    }
}
