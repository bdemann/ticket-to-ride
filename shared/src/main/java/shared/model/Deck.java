package shared.model;

import java.util.List;

/**
 * Created by bdemann on 3/3/18.
 */

public interface Deck {
    public void shuffle();
    public List<? extends Card> draw(int count);
}
