package presenter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import guifacade.LobbyGuiFacade;
import model.ClientRoot;
import shared.model.IPlayer;
import view.GameLobbyActivity;

/**
 * Created by mikeporet on 2/12/18.
 */

public class GameLobbyPresenter implements IGameLobbyPresenter, Observer {

    private GameLobbyActivity _activity;
    private ClientRoot clientRoot;

    public GameLobbyPresenter(GameLobbyActivity activity, ClientRoot clientRoot) {
        _activity = activity;
        this.clientRoot = clientRoot;
    }

    @Override
    public void leaveGame() {
        LobbyGuiFacade.leaveGame();
    }

    @Override
    public void update(Observable observable, Object o) {
        //if we have left the game
        if(clientRoot.getClientGame() == null){
            _activity.finish();
        }

        //Get the list of players
        else{
            ArrayList<IPlayer> players = new ArrayList<>(clientRoot.getClientGame().getPlayers());

            StringBuilder playerList = new StringBuilder();

            for (int i = 0; i < players.size(); i++){
                playerList.append(players.get(i).getUsername());
                if (i != (players.size()-1)){
                    playerList.append(", ");
                }
            }

            //Update the list of players on the lobby activity
            _activity.updatePlayerList(playerList.toString());
        }
    }
}
