package presenter;

import java.util.Observable;
import java.util.Observer;

import guifacade.LobbyGuiFacade;
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
    public void leaveGame() {
        LobbyGuiFacade.leaveGame();
    }

    @Override
    public void update(Observable observable, Object o) {
        //if we have left the game
        if(true){
            _activity.finish();
        }
    }
}
