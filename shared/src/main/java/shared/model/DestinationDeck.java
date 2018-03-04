package shared.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import shared.model.initialized_info.DestinationCards;

/**
 * Created by bdemann on 3/3/18.
 */

public class DestinationDeck implements Deck {

    List<DestCard> cards;

    public DestinationDeck(){
        cards = new ArrayList<>(DestinationCards.getDestinationCards());
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public List<DestCard> draw(int count) {
        List<DestCard> cards = new ArrayList<>();
        for(int i = 0; i < count; i++){
            cards.add(this.cards.get(0));
            cards.remove(0);
        }
        return cards;
    }
}
