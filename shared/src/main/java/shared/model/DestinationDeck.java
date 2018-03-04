package shared.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import shared.model.initialized_info.DestinationCards;

/**
 * Created by bdemann on 3/3/18.
 */

public class DestinationDeck extends Deck {

    //My justification for having a sepearte class for the destination deck is so that this class can worry about properly reading the cards from the DestinationCards class.
    public DestinationDeck(){
        super(DestinationCards.getDestinationCards());
    }

}
