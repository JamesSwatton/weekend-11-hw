public class Game {

    Deck deck;
    Dealer dealer;
    Player player;


    public Game(Deck deck, Dealer dealer, Player player){
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
    }

    public void dealHand(){
        if(player.numOfCards() == 0){   //DEAL OPENING HAND
            for(int i=0; i<2; i++){
                Card playerCard = dealer.dealCard(deck);
                player.addCardToHand(playerCard);
                dealer.dealCardToSelf(deck);
            }
        }else{ //DEAL TO PLAYER IF TWIST AND NOT BUST
            if(player.getStickOrTwist() == StatusType.TWIST && !player.getIsBust()){
                Card playerCard = dealer.dealCard(deck);
                player.addCardToHand(playerCard);
            } //DEAL TO DEALER IF TWIST AND NOT BUST
            if(dealer.getStickOrTwist() == StatusType.TWIST && !dealer.getIsBust()){
                dealer.dealCardToSelf(deck);
            }
        }
    }

    public Object checkWinner(){
        Object winner = player;

        if(player.getStickOrTwist() == StatusType.STICK && dealer.getStickOrTwist() == StatusType.STICK){

            if(player.getIsBust()){
                winner = dealer;
                return winner;
            }else if(dealer.getIsBust()){
                return winner;
            }else if(player.getIsBust() && dealer.getIsBust()){
                return null;
            }

            if(checkDraw()){
                return null;
            }

            if(player.getHandTotal() > dealer.getHandTotal()){
                return winner;
            }else{
                winner = dealer;
                return winner;
            }
        }else{
            return null;
        }
    }

    public boolean checkDraw(){
        return (player.getHandTotal() == dealer.getHandTotal() || player.getHasBlackjack() && dealer.getHasBlackjack());
    }

}
