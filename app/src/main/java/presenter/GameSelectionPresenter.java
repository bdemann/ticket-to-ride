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
        ArrayList<IGame> gamesList = new ArrayList<>(_clientRoot.getListGames());
        ArrayList<String> gameNames = new ArrayList<>();
        ArrayList<String> gameNumPlayers = new ArrayList<>();
        ArrayList<String> gameIDs = new ArrayList<>();
        for(int i = 0; i < gamesList.size(); i++){
//            IGame game = gamesList.get(i).getN

        }
        _gameSelectionActivity.updateGameList(gamesList);
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
