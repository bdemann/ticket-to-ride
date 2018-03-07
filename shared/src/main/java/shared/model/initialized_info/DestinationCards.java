package shared.model.initialized_info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import shared.model.DestCard;

/**
 * Created by paulinecausse on 2/27/18.
 */

public class DestinationCards implements Serializable {
    private static DestinationCards _instance = new DestinationCards();

    public static DestinationCards instance() {
        return _instance;
    }

    private DestinationCards(){
        this._destCards = new ArrayList<DestCard>();
        set_destCards();
    }

    public static List<DestCard> getDestinationCards() {
        return instance()._destCards;
    }

    private List<DestCard> _destCards;

    private void set_destCards(){
        DestCard _1 = new DestCard("New York", "Los Angeles", 21);
        DestCard _2 = new DestCard("Houston", "Duluth", 8);
        DestCard _3 = new DestCard("Nashville", "Sault St. Marie", 8);
        DestCard _4 = new DestCard("Atlanta", "New York", 6);
        DestCard _5 = new DestCard("Nashville", "Portland", 17);
        DestCard _6 = new DestCard("Montréal", "Vancouver", 20);
        DestCard _7 = new DestCard("El Paso", "Duluth", 10);
        DestCard _8 = new DestCard("Miami", "Toronto", 10);
        DestCard _9 = new DestCard("Pheonix", "Portland", 11);
        DestCard _10 = new DestCard("New York", "Dallas", 11);
        DestCard _11 = new DestCard("Salt Lake City", "Calgary", 7);
        DestCard _12 = new DestCard("Pheonix", "Calgary", 13);
        DestCard _13 = new DestCard("Miami", "Los Angeles", 20);
        DestCard _14 = new DestCard("Little Rock", "Winnipeg", 11);
        DestCard _15 = new DestCard("Atlanta", "San Francisco", 17);
        DestCard _16 = new DestCard("Houston", "Kansas City", 5);
        DestCard _17 = new DestCard("Chicago", "Los Angeles", 16);
        DestCard _18 = new DestCard("Pittsburg", "Denver", 11);
        DestCard _19 = new DestCard("Santa Fe", "Chicago", 9);
        DestCard _20 = new DestCard("Santa Fe", "Vancouver", 13);
        DestCard _21 = new DestCard("Miami", "Boston", 12);
        DestCard _22 = new DestCard("New Orleans", "Chicago", 7);
        DestCard _23 = new DestCard("Atlanta", "Montréal", 9);
        DestCard _24 = new DestCard("New York City", "Seattle", 22);
        DestCard _25 = new DestCard("El Paso", "Denver", 4);
        DestCard _26 = new DestCard("Los Angeles", "Helena", 8);
        DestCard _27 = new DestCard("Houston", "Winnipeg", 12);
        DestCard _28 = new DestCard("New Orleans", "Montréal", 13);
        DestCard _29 = new DestCard("Oklahoma City", "Sault St. Marie", 9);
        DestCard _30 = new DestCard("Los Angeles", "Seattle", 9);

        _destCards.add(_1);
        _destCards.add(_2);
        _destCards.add(_3);
        _destCards.add(_4);
        _destCards.add(_5);
        _destCards.add(_6);
        _destCards.add(_7);
        _destCards.add(_8);
        _destCards.add(_9);
        _destCards.add(_10);
        _destCards.add(_11);
        _destCards.add(_12);
        _destCards.add(_13);
        _destCards.add(_14);
        _destCards.add(_15);
        _destCards.add(_16);
        _destCards.add(_17);
        _destCards.add(_18);
        _destCards.add(_19);
        _destCards.add(_20);
        _destCards.add(_21);
        _destCards.add(_22);
        _destCards.add(_23);
        _destCards.add(_24);
        _destCards.add(_25);
        _destCards.add(_26);
        _destCards.add(_27);
        _destCards.add(_28);
        _destCards.add(_29);
        _destCards.add(_30);
    }

}