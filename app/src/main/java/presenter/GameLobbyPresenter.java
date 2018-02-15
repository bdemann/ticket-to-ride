package presenter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import guifacade.LobbyGuiFacade;
import model.ClientRoot;
import shared.model.IGame;
import shared.model.IPlayer;
import view.GameLobbyActivity;

/**
 * Created by mikeporet on 2/12/18.
 */

public class GameLobbyPresenter implements IGameLobbyPresenter, Observer {

    private GameLobbyActivity _activity;
    private ClientRoot _clientRoot;

    public GameLobbyPresenter(GameLobbyActivity activity, ClientRoot clientRoot) {
        _activity = activity;
        this._clientRoot = clientRoot;
    }

    @Override
    public void update(Observable observable, Object o) {
        //if we have left the game
        if(_clientRoot.getClientGame() == null){
            _activity.finish();
        }
        //Get the list of players
        else{
            listPlayers();
        }
    }

    @Override
    public String leaveGame() {
        return LobbyGuiFacade.leaveGame(_clientRoot.getClientPlayer().getUsername());
    }

    @Override
    public boolean checkNumPlayers() {
        IGame game = _clientRoot.getClientGame();
        int numPlayers = game.getNumberPlayer();
        int maxPlayers = game.getMaxNumberPlayer();
        if (numPlayers==maxPlayers)
            return true;
        else
            return false;
    }

    public void listGame(){
        String name = _clientRoot.getClientGame().getGameName();
        //update the name of the game in the lobby activity
        _activity.updateGameName(name);
    }

    public void listPlayers(){
        ArrayList<IPlayer> players = new ArrayList<>(_clientRoot.getClientGame().getPlayers());

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
