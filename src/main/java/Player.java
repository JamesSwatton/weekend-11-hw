import java.util.ArrayList;

public class Player {

    ArrayList<Card> hand;

    public Player(){
        this.hand = new ArrayList<Card>();
    }

    public void addCardToHand(Card card){
        this.hand.add(card);
    }

    public ArrayList<Card> showHand(){
        return this.hand;
    }
}
