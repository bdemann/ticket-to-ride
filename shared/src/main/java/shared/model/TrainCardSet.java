package shared.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bdemann on 3/5/18.
 */

public class TrainCardSet implements Serializable {

    public List<TrainCard> trainCards;

    public TrainCardSet(List<TrainCard> trainCards){
        this.trainCards = trainCards;
    }

    public List<TrainCard> getTrainCards() {
        return trainCards;
    }

    public Color getSetColor() {
        for( TrainCard card : trainCards) {
            if (card.getColor().equals(Color.RAINBOW)) {
                continue;
            }
            return card.getColor();
        }
        return Color.RAINBOW;
    }

    public boolean colorsMatch() {
        Color currColor = null;
        for( TrainCard card : trainCards) {
            if (card.getColor().equals(Color.RAINBOW)) {
                continue;
            }
            if (currColor == null){
                currColor = card.getColor();
            }else if (!currColor.equals(card.getColor())){
                return false;
            }
        }
        return true;
    }
}
