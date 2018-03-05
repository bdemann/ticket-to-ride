package shared.model;

import java.io.Serializable;
import java.util.ArrayList;

import shared.model.initialized_info.TrainCards;

/**
 * Created by bdemann on 3/3/18.
 */

public class TrainDeck extends Deck implements Serializable {

    public TrainDeck(){
        super(new ArrayList<>(TrainCards.getTrainCards()));
    }

}
