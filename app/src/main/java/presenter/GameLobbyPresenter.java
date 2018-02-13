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
    }

    @Override
    public String leaveGame() {
        return LobbyGuiFacade.leaveGame(_clientRoot.getClientPlayer().getUsername());
    }


}
