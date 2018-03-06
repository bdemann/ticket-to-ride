package presenter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import facade.guifacade.LobbyGuiFacade;
import model.ClientRoot;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;
import view.GameLobbyActivity;

/**
 * Created by mikeporet on 2/12/18.
 */

public class GameLobbyPresenter implements IGameLobbyPresenter, Observer {

    private GameLobbyActivity _activity;

    public GameLobbyPresenter(GameLobbyActivity activity) {
        _activity = activity;
    }

    @Override
    public void update(Observable observable, Object o) {

        //if we have left the game
        if(ClientRoot.getClientGame() == null){
            _activity.finish();
        }
        else if(ClientRoot.getClientGame() != null && ClientRoot.getClientGame().isGameStarted()){

            //We need to start the game.
            _activity.startGame();


        }
        //Get the list of players
        else{
            listPlayers();
        }
    }

    @Override
    public String leaveGame() {
        return LobbyGuiFacade.leaveGame(ClientRoot.getClientPlayer().getUsername());
    }

    @Override
    public String startGame() {
        return LobbyGuiFacade.startGame(ClientRoot.getClientGame(),ClientRoot.getClientPlayer().getUsername());
    }

    @Override
    public boolean checkNumPlayers() {
        IGame game = ClientRoot.getClientGame();
        int numPlayers = game.getNumberPlayer();
        int maxPlayers = game.getMaxNumberPlayer();
        if (numPlayers==maxPlayers)
            return true;
        else
            return false;
    }

    public void listGame(){
        String name = ClientRoot.getClientGame().getGameName();
        //update the name of the game in the lobby activity
        _activity.updateGameName(name);
    }

    public void listPlayers(){
        ArrayList<IPlayer> players = new ArrayList<>(ClientRoot.getClientGame().getPlayers());

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
