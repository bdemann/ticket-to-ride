package presenter;

import java.util.Observable;
import java.util.Observer;

import facade.guifacade.GameGuiFacade;
import model.ClientRoot;
import shared.model.TrainCard;
import view.DrawTrainCardsActivity;

/**
 * Presenter for drawing train cards
 * Created by BenNelson on 3/6/18.
 */

public class DrawTrainCardsPresenter implements IDrawTrainCardsPresenter, Observer {

    private DrawTrainCardsActivity view;

    public DrawTrainCardsPresenter(DrawTrainCardsActivity view) {
        this.view = view;
    }

    @Override
    public void drawFaceUpCard(int index) {
        TrainCard trainCard = ClientRoot.getClientGame().getCardsFaceUp().get(index);
        GameGuiFacade.drawFaceUpTrainCard(trainCard);
    }

    @Override
    public void drawFaceDownCard() {
        ClientRoot.getClientPlayer().addTrainCard(GameGuiFacade.drawFaceDownTrainCard());
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
