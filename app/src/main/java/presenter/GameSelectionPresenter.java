package presenter;

import android.content.Context;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import guifacade.CreateGameGuiFacade;
import guifacade.JoinGameGuiFacade;
import model.ClientRoot;
import shared.model.Game;
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

        if(_clientRoot.getClientGame()!= null){
            Game game = _clientRoot.getClientGame();
            System.out.println("Here's the Game ID: " + game.getId());

            //Switch to the game lobby
            System.out.println("I WANT TO GO TO THE GAME LOBBY!!! PLEASE HELP");
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
            return false;
    }
}

