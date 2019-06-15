import java.util.ArrayList;

public class Dealer {

    ArrayList<Card> hand;

    public Dealer(){
        this.hand = new ArrayList<Card>();
    }

    public Card dealCard(Deck deck) {
        return deck.dealCard();
    }

    public void dealCardToSelf(Deck deck){
        Card card = dealCard(deck);
        hand.add(card);
    }

    public ArrayList<Card> showHand(){
        return this.hand;
    }

    public Card revealCard() {
        return this.hand.get(0);
    }
}
