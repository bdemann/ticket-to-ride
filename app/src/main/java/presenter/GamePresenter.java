package presenter;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import facade.guifacade.GameGuiFacade;
import model.ClientRoot;
import shared.model.City;
import shared.model.Color;
import shared.model.Hand;
import shared.model.Route;
import shared.model.TrainCard;
import shared.model.TrainCardSet;
import shared.model.initialized_info.Cities;
import shared.model.interfaces.IRoute;
import view.GameActivity;
import view.GameInfoActivity;

/**
 * This class is the presenter for the game
 * Created by BenNelson on 3/6/18.
 */

public class GamePresenter implements IGamePresenter, Observer{
    private GameActivity _gameActivity;

    //This presenter needs to add itself as an observer to the client
    public GamePresenter(GameActivity gameActivity){
        this._gameActivity = gameActivity;
        ClientRoot.addClientRootObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        _gameActivity.checkTurn();
    }

    @Override
    public String claimRoute(String startCity, String endCity) {
        City start = Cities.instance().getCity(startCity);
        City end = Cities.instance().getCity(endCity);
        IRoute route = new Route(start,end);
        Hand<TrainCard> hand = ClientRoot.getClientPlayer().getTrainCardHand();
        List<TrainCard> cards = hand.get_cards();
        TrainCardSet trainCards = new TrainCardSet(cards);

        return GameGuiFacade.claimRoute(route,trainCards, ClientRoot.getClientPlayer().getUsername());
    }

    @Override
    public Map<Color, List<Route>> getRoutesMapForDrawing() {
        return null;
    }

    @Override
    public boolean checkTurn(){
        return GameGuiFacade.checkTurn();
    }


}
