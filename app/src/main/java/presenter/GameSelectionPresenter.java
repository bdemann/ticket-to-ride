package presenter;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import facade.guifacade.JoinGameGuiFacade;
import model.ClientRoot;
import shared.model.interfaces.IGame;
import view.GameSelectionActivity;

/**
 *
 * Created by BenNelson on 2/12/18.
 */

public class GameSelectionPresenter implements IGameSelectionPresenter, Observer{

    private GameSelectionActivity _gameSelectionActivity;




    public GameSelectionPresenter(GameSelectionActivity gameSelectionActivity){

        this._gameSelectionActivity = gameSelectionActivity;
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("Game Selection Update called\n");
        //If a game has been joined
        if (ClientRoot.getClientGame() != null){
            _gameSelectionActivity.goToGameLobby();
        }

        listGames();

    }

    @Override
    public boolean joinGame(int gameID) {
        String result = JoinGameGuiFacade.joinGame(gameID);
        if (result.equals("Join successful")){
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<String> getGameNames() {
        ArrayList<IGame> gamesList = new ArrayList<>(ClientRoot.getListGames());
        ArrayList<String> gameNames = new ArrayList<>();
        for(int i = 0; i < gamesList.size(); i++){
            IGame game = gamesList.get(i);
            gameNames.add(game.getGameName());
        }
        return gameNames;
    }

    @Override
    public ArrayList<Integer> getGameIDs() {
        ArrayList<IGame> gamesList = new ArrayList<>(ClientRoot.getListGames());
        ArrayList<Integer> gameIDs = new ArrayList<>();
        for(int i = 0; i < gamesList.size(); i++){
            IGame game = gamesList.get(i);
            gameIDs.add(game.getId());
        }
        return gameIDs;
    }

    @Override
    public ArrayList<String> getGameNumPlayers() {
        ArrayList<IGame> gamesList = new ArrayList<>(ClientRoot.getListGames());
        ArrayList<String> gameNumPlayers = new ArrayList<>();
        for(int i = 0; i < gamesList.size(); i++){
            IGame game = gamesList.get(i);

            StringBuilder numPlayers = new StringBuilder();
            numPlayers.append(game.getNumberPlayer());
            numPlayers.append("/");
            numPlayers.append(game.getMaxNumberPlayer());
            gameNumPlayers.add(numPlayers.toString());

        }
        return gameNumPlayers;
    }

    public void listGames(){
        //Update game list
        ArrayList<IGame> gamesList = new ArrayList<>(ClientRoot.getListGames());
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


}
