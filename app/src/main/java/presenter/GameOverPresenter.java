package presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import model.ClientRoot;
import shared.model.TrainCard;
import shared.model.interfaces.IGameInfo;
import view.GameOverActivity;

/**
 * Created by mikeporet on 3/23/18.
 */


public class GameOverPresenter implements Observer{

    GameOverActivity activity;

    public GameOverPresenter(GameOverActivity activity) {
        this.activity = activity;
        updateActivity();
    }

    @Override
    public void update(Observable observable, Object o) {

        if(ClientRoot.getClientGameInfo() != null){
            updateActivity();
        }
        if(ClientRoot.getClientPlayer() != null){
            updateActivity();
        }

    }

    public void updateActivity(){

        IGameInfo gameInfo = ClientRoot.getClientGameInfo();
        if(gameInfo.getPlayers() == null || gameInfo.getPlayerHandSizes() == null || gameInfo.getPlayerPoints() == null
                || gameInfo.getClaimedRoutes() == null || gameInfo.getRemainingTrains() == null){
            System.out.println("Game Info null!");
        }
        else{
            //Set player names
            List<String> players = new ArrayList<>(gameInfo.getPlayers());
            //Fill extra player slots
            for (int i = players.size(); i < 5; i++){
                players.add("-");
            }
            activity.set_player_names(players);

//            activity._updateGameInfo(gameInfo.getPlayers(),gameInfo.getPlayerPoints(),
//                    gameInfo.getClaimedRoutes(), gameInfo.getRemainingTrains(), gameInfo.getPlayerColors(), gameInfo.getPlayerDestCount());

            //Set point values
        }
    }
}
