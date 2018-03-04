package shared.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bdemann on 3/4/18.
 */

public class Hand<T> {
    List<T> _cards;

    public Hand(List<T> cards) {
        this._cards = cards;
    }

    /**
     * Move card at oldIndex to new index
     * @param oldIndex
     * @param newIndex
     */
    public void changeCardPosition(int oldIndex, int newIndex) {
        T card = _cards.get(oldIndex);
        _cards.remove(oldIndex);
        _cards.add(newIndex, card);
    }

    public T useCard(int index) {
        T card = _cards.get(index);
        _cards.remove(index);
        return card;
    }

    public T useCard(T card) {
        _cards.remove(card);
        return card;
    }

    public List<T> useCards(List<Integer> indices) throws Exception {
        List<T> cards = new ArrayList<>();
        Hand<T> originalHand = new Hand<>(new ArrayList<T>(_cards));
        for(Integer i : indices) {
            //TODO this method will defiantly not work. It's going to mess up the indices a lot and it won't accurately get the position of the card to get
            cards.add(useCard(i));
        }
        throw new Exception("This method isn't implemented yet. Check the TODO in the function for more info");
    }

    public void addCard(T card) {
        _cards.add(card);
    }

    public void addCards(List<T> newDestCards) {
        for(T card : newDestCards) {
            addCard(card);
        }
    }
}
