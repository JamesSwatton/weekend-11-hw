public class Card {

    SuitType suit;
    RankType rank;
    int value;

    public Card(SuitType suit, RankType rank){
        this.suit = suit;
        this.rank = rank;
        this.value = rank.getValue();
    }

    public SuitType getSuit(){
        return suit;
    }

    public RankType getRank() {
        return rank;
    }

    public int getValue() {
        return this.value;
    }
}
