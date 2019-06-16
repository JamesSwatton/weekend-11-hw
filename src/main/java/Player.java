import java.util.ArrayList;

public class Player {

    ArrayList<Card> hand;
    StatusType stickOrTwist;
    boolean isBust;
    boolean hasBlackjack;

    public Player(){
        this.hand = new ArrayList<Card>();
        this.stickOrTwist = StatusType.TWIST;
        this.isBust = false;
        this.hasBlackjack = false;
    }

    public void addCardToHand(Card card){
        this.hand.add(card);
        if(getHandTotal() > 21){
            this.isBust = true;
        }
        checkForBlackjack();
    }

    public int numOfCards(){
        return this.hand.size();
    }

    public int getHandTotal() {
        int handTotal = 0;
        for(Card card : this.hand){
            handTotal += card.getValue();
        }
        return handTotal;
    }

    public void emptyHand() {
        this.hand.clear();
        this.isBust = false;
    }

    public void setStickOrTwist(StatusType stickOrTwist) {
        this.stickOrTwist = stickOrTwist;
    }

    public StatusType getStickOrTwist() {
        return this.stickOrTwist;
    }

    public boolean getIsBust(){
        return this.isBust;
    }

    public boolean getHasBlackjack(){
        return this.hasBlackjack;
    }

    public void checkForBlackjack(){
        boolean hasAce = false;
        boolean hasTen = false;
        if(this.numOfCards() == 2) {
            for (Card card : this.hand) {
                if (card.getRank() == RankType.ACE) {
                    hasAce = true;
                } else if (card.getValue() == 10) {
                    hasTen = true;
                }
            }
        }
        if(hasAce && hasTen){
            this.hasBlackjack = true;
            this.setStickOrTwist(StatusType.STICK);
        }else{
            this.hasBlackjack = false;
        }
    }
}
