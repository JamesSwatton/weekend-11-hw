import java.util.ArrayList;

public class Dealer {

    ArrayList<Card> hand;

    public Dealer(){
        this.hand = new ArrayList<Card>();
    }

    public Card dealCard(Deck deck) {
        return deck.dealCard();
    }

    public void addCardToHand(Card card){
        this.hand.add(card);
    }

    public void dealCardToSelf(Deck deck){
        Card card = dealCard(deck);
        hand.add(card);
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
}
