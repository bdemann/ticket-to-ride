package model;


import shared.model.interfaces.IGame;
import shared.model.interfaces.IGameInfo;
import shared.model.interfaces.IPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by BenNelson on 2/2/18.
 *
 */

public class ClientRoot extends Observable {

    private IPlayer _clientPlayer;
    private IGame _clientGame;
    private List<IGame> _gamesList;
    private static ClientRoot _instance = new ClientRoot();
    private IGameInfo _gameInfo;

    private ClientRoot(){
        this._clientPlayer = null;
        this._clientGame = null;
        this._gamesList = new ArrayList<>();
    }

    //Getters and Setters
    public static IPlayer getClientPlayer(){
        return _instance._clientPlayer;
    }

    public static IGame getClientGame() {
        return _instance._clientGame;
    }

    public static IGameInfo getClientGameInfo() {
        return _instance._gameInfo;
    }

    public static List<IGame> getListGames() {
        return _instance._gamesList;
    }

    public static void setClientPlayer(IPlayer player) {
        _instance._clientPlayer = player;
        _instance.setChanged();
        //The notify observers method can be overloaded with an object, will then be Object o param
        //for the update function.
        _instance.notifyObservers();
    }

    public static void setClientGame(IGame clientGame) {
        _instance._clientGame = clientGame;
        _instance.setChanged();
        _instance.notifyObservers();
    }

    public static void setListGames(List<IGame> list) {
        if (_instance._incomingListIsDifferent(list)) {
            _instance._gamesList = list;
            _instance.setChanged();
            _instance.notifyObservers();
        }
    }

    public static void addToGameList(IGame game){
        _instance._gamesList.add(game);
        _instance.setChanged();
        _instance.notifyObservers();
    }

    public static IGame getGame(int gameId){
        for(IGame game : _instance._gamesList){
            if(game.getId() == gameId){
                return game;
            }
        }
        return null;
    }


    private boolean _incomingListIsDifferent(List<IGame> incomingList) {


        if (incomingList == null && _instance._gamesList != null) {
            return true;
        }
        if (incomingList != null && _instance._gamesList == null) {
            return true;
        }
        if (incomingList == null) {
            return false;
        }
        if (incomingList.size() != _instance._gamesList.size()) {
            return true;
        }

        int count = incomingList.size();
        for (int i = 0; i < count; i++) {

            if (incomingList.get(i).getId() != _instance._gamesList.get(i).getId()) {
                return true;
            }
        }

        return false;
    }

    public static void setClientGameInfo(IGameInfo gameInfo) {
        _instance._gameInfo = gameInfo;
    }

    public static void addClientRootObserver(Observer o){
        _instance.addObserver(o);
    }
}
