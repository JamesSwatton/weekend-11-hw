import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(SuitType.HEARTS, RankType.ACE);
    }

    @Test
    public void hasSuit(){
        assertEquals(SuitType.HEARTS, card.getSuit());
    }

    @Test
    public void hadRank(){
        assertEquals(RankType.ACE, card.getRank());
    }

    @Test
    public void hasValue(){
        assertEquals(1, card.getValue());
    }
}
