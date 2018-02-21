package presenter;

import android.content.Intent;

import java.util.Observable;
import java.util.Observer;

import facade.guifacade.CreateGameGuiFacade;
import model.ClientRoot;
import shared.model.IGame;
import view.CreateGameActivity;
import view.GameLobbyActivity;

/**
 *
 * Created by mikeporet on 2/11/18.
 */

public class CreateJoinPresenter implements ICreateJoinPresenter, Observer {

    private ClientRoot _clientRoot;
    private CreateGameActivity _createGameActivity;


    public CreateJoinPresenter(ClientRoot clientRoot, CreateGameActivity createGameActivity){

        this._clientRoot = clientRoot;
        this._createGameActivity = createGameActivity;
    }

    @Override
    public void update(Observable obs, Object o) {

        System.out.println("Create Join Update called\n");

        if(_clientRoot.getClientGame()!= null){
            IGame game = _clientRoot.getClientGame();
            System.out.println("Here's the Game ID: " + game.getId());

            //Transition to the game lobby
            Intent intent = new Intent(_createGameActivity, GameLobbyActivity.class);
            String gameID = Integer.toString(game.getId());
            intent.putExtra("GameName", game.getGameName());
            intent.putExtra("GameID", gameID);
            _createGameActivity.startActivity(intent);
        }



    }

    @Override
    public String createGame(int creatorColor, String gameName, int numberOfPlayers){
        return CreateGameGuiFacade.createGame(numberOfPlayers,creatorColor, gameName);
    }


}

