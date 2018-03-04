package shared.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import shared.model.initialized_info.TrainCards;

/**
 * Created by bdemann on 3/3/18.
 */

public class TrainDeck implements Deck {

    List<TrainCard> cards;

    public TrainDeck(){
        cards = new ArrayList<>(TrainCards.getTrainCards());
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public List<? extends Card> draw(int count) {
        List<TrainCard> cards = new ArrayList<>();
        for(int i = 0; i < count; i++){
            cards.add(this.cards.get(0));
            cards.remove(0);
        }
        return cards;
    }
}
