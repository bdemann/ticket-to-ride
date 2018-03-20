package presenter;

import shared.model.TrainCard;

/**
 * Interface for Drawing train cards
 * Created by BenNelson on 3/6/18.
 */

public interface IDrawTrainCardsPresenter {
    void drawFaceUpCard(TrainCard trainCard);
    void drawFaceDownCard();
}
