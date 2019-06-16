import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class Dealer {

    ArrayList<Card> hand;
    StatusType stickOrTwist;
    Boolean isBust;
    Boolean hasBlackjack;

    public Dealer(){
        this.hand = new ArrayList<Card>();
        this.stickOrTwist = StatusType.TWIST;
        this.isBust = false;
    }

    public Card dealCard(Deck deck) {
        return deck.dealCard();
    }

    public void addCardToHand(Card card){
        this.hand.add(card);
        if(getHandTotal() > 21) {
            this.isBust = true;
        }else if(getHandTotal() > 16 ) {
            stickOrTwist(StatusType.STICK);
        }
        checkForBlackjack();
    }

    public void dealCardToSelf(Deck deck){
        Card card = dealCard(deck);
        this.hand.add(card);
        if(getHandTotal() > 21) {
            this.isBust = true;
        }else if(getHandTotal() > 16 ) {
            stickOrTwist(StatusType.STICK);
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

    public Card revealCard() {
        return this.hand.get(0);
    }

    public void emptyHand() {
        this.hand.clear();
        this.isBust = false;
    }

    public void stickOrTwist(StatusType stickOrTwist) {
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

    private void checkForBlackjack(){
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
        }else{
            this.hasBlackjack = false;
        }
    }
}
