package shared.model;

import java.util.ArrayList;

import shared.model.initialized_info.TrainCards;

/**
 * Created by bdemann on 3/3/18.
 */

public class TrainDeck extends Deck {

    public TrainDeck(){
        super(new ArrayList<>(TrainCards.getTrainCards()));
    }

}
