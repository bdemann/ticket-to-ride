package shared.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bdemann on 3/3/18.
 */

public class Deck<T> {

    List<T> _cards;

    public Deck(List<T> cards){
        this._cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(_cards);
    }

    public List<T> draw(int count){
        List<T> cards = new ArrayList<>();
        for(int i = 0; i < count; i++){
            cards.add(this._cards.get(0));
            cards.remove(0);
        }
        return cards;
    }
}
