package shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import shared.model.interfaces.Card;

/**
 *
 * Created by bdemann on 3/7/18.
 */

public class CardSet implements Iterable<DestCard>, Serializable {

    public List<DestCard> cards;
    public CardSet(List<DestCard> cards){
        this.cards = cards;
    }

    @Override
    public Iterator<DestCard> iterator() {
        return new Iterator<DestCard>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < CardSet.this.cards.size();
            }

            @Override
            public DestCard next() {
                return CardSet.this.cards.get(index++);
            }

            @Override
            public void remove(){

            }
        };
    }
}
