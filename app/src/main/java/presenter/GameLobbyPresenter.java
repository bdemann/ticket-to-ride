package presenter;

import java.util.Observable;
import java.util.Observer;

import guifacade.LobbyGuiFacade;
import model.ClientRoot;
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
    }
}
