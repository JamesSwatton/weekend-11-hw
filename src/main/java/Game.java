import java.util.ArrayList;

public class Game {

    Deck deck;
    Dealer dealer;
    ArrayList<Player> players;


    public Game(Deck deck, Dealer dealer, ArrayList<Player> players){
        this.deck = deck;
        this.dealer = dealer;
        this.players = players;
    }

    public int getNumOfPlayers(){
        return this.players.size();
    }

    public void dealHand(){
        for(Player player : this.players){
            if(player.numOfCards() == 0){   //DEAL OPENING HAND
                for(int i=0; i<2; i++){
                    Card playerCard = dealer.dealCard(deck);
                    player.addCardToHand(playerCard);
                    if(dealer.numOfCards() < 2){  // ONLY DEAL 2 CARDS TO DEALER REGARDLESS OF HOW MANY PLAYERS
                        dealer.dealCardToSelf(deck);
                    }
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
    }

    public Object checkWinner(){
        checkBust();

        Object winner = this.players.get(0);

        if(checkStuck()){

            if(checkDraw()){
                return null;
            }

            for(Player player : this.players){
                if(player.getHandTotal() > ((Player) winner).getHandTotal()){
                    winner = player;
                }
            }

            if(dealer.getIsBust()){
                return winner;
            }else if(!dealer.getIsBust() && ((Player) winner).getHandTotal() > dealer.getHandTotal()){
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
        boolean draw = false;
        for(Player player : this.players){
            if (player.getHandTotal() == this.players.get(0).getHandTotal() && dealer.getHandTotal() == this.players.get(0).getHandTotal()){
                draw = true;
            }else if(player.getHandTotal() == this.players.get(0).getHandTotal() && dealer.getIsBust()){
                draw = true;
            }else{
                draw = false;
            }
        }
        return draw;
    }

    public boolean checkStuck(){
        boolean stuck = false;
        for(Player player : this.players) {
            if (player.getStickOrTwist() == StatusType.STICK && dealer.getStickOrTwist() == StatusType.STICK) {
                stuck = true;
            } else {
                stuck = false;
            }
        }
        return stuck;
    }

    public void checkBust(){
        ArrayList<Player> notBustPlayers = new ArrayList<Player>();
        for(Player player : this.players){
            if(!player.getIsBust()){
                notBustPlayers.add(player);
            }
        }
        this.players = notBustPlayers;
    }

}
