package presenter;

import android.content.Context;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import guifacade.CreateGameGuiFacade;
import guifacade.JoinGameGuiFacade;
import model.ClientRoot;
import shared.model.Game;
import shared.model.IGame;
import view.IGameSelection;

/**
 *
 * Created by mikeporet on 2/11/18.
 */

public class GameSelectionPresenter implements IGameSelectionPresenter, Observer {

    private ClientRoot _clientRoot;


    public GameSelectionPresenter(ClientRoot clientRoot){
        this._clientRoot = clientRoot;
    }

    @Override
    public void update(Observable obs, Object o) {

        System.out.println("Game Selection Update called\n");


//        if(_clientRoot.getClientPlayer() != null && _clientRoot.getClientGame() == null){
//            Intent intent = new Intent(_context, GameSelectionActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            _context.startActivity(intent);
//        }
        if(_clientRoot.getClientGame()!= null){
            IGame game = _clientRoot.getClientGame();
            System.out.println("Here's the Game ID: " + game.getId());
        }
    }

    @Override
    public String createGame(int creatorColor, String gameName, int numberOfPlayers){
        return CreateGameGuiFacade.createGame(numberOfPlayers,creatorColor, gameName);
    }

    @Override
    public boolean joinGame(int gameID) {
        String result = JoinGameGuiFacade.joinGame(gameID);
        if (result.equals("join successful")){
            return true;
        }
        else
            return false;
    }
}

