package shared.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import shared.model.interfaces.Card;

/**
 * Created by bdemann on 3/7/18.
 */

public class CardSet implements Iterable<Card>, Serializable {

    public List<? extends Card> cards;

    public CardSet(List<? extends Card> cards){
        this.cards = cards;
    }

    @Override
    public Iterator<Card> iterator() {
        return new Iterator<Card>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < CardSet.this.cards.size();
            }

            @Override
            public Card next() {
                return CardSet.this.cards.get(++index);
            }
        };
    }
}
