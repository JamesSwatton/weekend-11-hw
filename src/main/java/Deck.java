import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
        populateDeck();
        shuffleDeck();
    }

    public void populateDeck(){
        for (SuitType suit : SuitType.values()){
            for (RankType rank : RankType.values()){
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public int numOfCards() {
        return cards.size();
    }

    public Object dealCard() {
        return cards.remove(0);
    }
}
