package presenter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import guifacade.JoinGameGuiFacade;
import model.ClientRoot;
import shared.model.Game;
import shared.model.IGame;
import view.GameSelectionActivity;

/**
 *
 * Created by BenNelson on 2/12/18.
 */

public class GameSelectionPresenter implements IGameSelectionPresenter, Observer{

    private ClientRoot _clientRoot;
    private GameSelectionActivity _gameSelectionActivity;


    public GameSelectionPresenter(ClientRoot clientRoot, GameSelectionActivity gameSelectionActivity){

        this._clientRoot = clientRoot;
        this._gameSelectionActivity = gameSelectionActivity;
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("Game Selection Update called\n");
        //If a game has been joined
        if (_clientRoot.getClientGame() != null){
            _gameSelectionActivity.goToGameLobby();
        }



        //Update game list
        ArrayList<IGame> gamesList = new ArrayList<>(_clientRoot.getListGames());
        ArrayList<String> gameNames = new ArrayList<>();
        ArrayList<String> gameNumPlayers = new ArrayList<>();
        ArrayList<Integer> gameIDs = new ArrayList<>();
        for(int i = 0; i < gamesList.size(); i++){
            IGame game = gamesList.get(i);
            gameNames.add(game.getGameName());
            StringBuilder numPlayers = new StringBuilder();
            numPlayers.append(game.getNumberPlayer());
            numPlayers.append("/");
            numPlayers.append(game.getMaxNumberPlayer());
            gameNumPlayers.add(numPlayers.toString());
            gameIDs.add(game.getId());

        }
        _gameSelectionActivity.updateGameList(gameNames,gameIDs,gameNumPlayers);
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
