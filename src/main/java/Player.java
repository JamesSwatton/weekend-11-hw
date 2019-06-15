import java.util.ArrayList;

public class Player {

    ArrayList<Card> hand;

    public Player(){
        this.hand = new ArrayList<Card>();
    }

    public void addCardToHand(Card card){
        this.hand.add(card);
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
    }
}
