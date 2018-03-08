package presenter;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import facade.guifacade.GameGuiFacade;
import model.ClientRoot;
import shared.model.DestCard;
import shared.model.Route;
import shared.model.TrainCard;
import shared.model.history.GameHistory;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IGameInfo;
import view.GameInfoActivity;

/**
 * Created by paulinecausse on 3/7/18.
 */

public class GameInfoPresenter implements IGameInfoPresenter, Observer {
    private GameInfoActivity _gameInfoActivity;


    public GameInfoPresenter(GameInfoActivity gameInfoActivity){

        this._gameInfoActivity = gameInfoActivity;
    }

    @Override
    public void update(Observable obs, Object o) {

        System.out.println("GameInfo Update called\n");

        if(ClientRoot.getClientGameInfo() != null){
            _updateActivity();
        }
        if(ClientRoot.getClientGameInfo() != null){
            ClientRoot.removeClientRootObserver(this);
        }
    }

    @Override
    public IGameInfo getStarterGameInfo() {
        return GameGuiFacade.getStarterGameInfo();
    }


    public void _updateActivity(){

//        Map<String, Integer> playerTrains;
//        Map<String, String> claimesRoutes;

        IGameInfo gameInfo = ClientRoot.getClientGameInfo();
        if(gameInfo.getPlayers() == null || gameInfo.getPlayerHandSizes() == null || gameInfo.getPlayerPoints() == null){
            System.out.println("Game Info null!");
        }
        else{
            _gameInfoActivity._updateGameInfo(gameInfo.getPlayers(),gameInfo.getPlayerPoints(),gameInfo.getPlayerHandSizes());

        }

    }

    public ArrayList<DestCard> getDestinationCards(){

        //Gets a list of the destination cards in a player's hand

        return new ArrayList<DestCard>();
    }

    public ArrayList<Boolean> getCompleteDestinations(){

        //Gets a list of the completion status of each destination card

        return new ArrayList<Boolean>();
    }
}
