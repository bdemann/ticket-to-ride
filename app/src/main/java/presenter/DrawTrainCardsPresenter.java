package presenter;

import java.util.Observable;
import java.util.Observer;

import facade.guifacade.GameGuiFacade;
import model.ClientRoot;
import shared.model.TrainCard;
import shared.results.DrawTrainCardsResult;
import view.DrawTrainCardsActivity;

/**
 * Presenter for drawing train cards
 * Created by BenNelson on 3/6/18.
 */

public class DrawTrainCardsPresenter implements IDrawTrainCardsPresenter, Observer {

    private DrawTrainCardsActivity view;

    public DrawTrainCardsPresenter(DrawTrainCardsActivity view) {
        this.view = view;
        ClientRoot.addClientRootObserver(this);
    }

    @Override
    public void drawFaceUpCard(int index) {
        GameGuiFacade.drawFaceUpTrainCard(index);
    }

    @Override
    public void drawFaceDownCard() {
        GameGuiFacade.drawFaceDownTrainCard();
    }

    @Override
    public void update(Observable observable, Object o) {
        //TODO update the face up cards
        //TODO update the state?
        view.setFaceUpCards(ClientRoot.getClientGameInfo().getFaceUpCards());
    }
}
