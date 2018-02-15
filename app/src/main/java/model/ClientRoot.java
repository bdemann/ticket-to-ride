package model;


import shared.model.IGame;
import shared.model.IPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by BenNelson on 2/2/18.
 *
 */


public class ClientRoot extends Observable {

    private IPlayer _clientPlayer;
    private IGame _clientGame;
    private List<IGame> _gamesList;
    private static ClientRoot _instance;

    public static ClientRoot instance() {

        if (_instance == null)
            _instance = new ClientRoot();
        return _instance;
    }

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

    public static void setListGames(List<IGame> list){
        _instance._gamesList = list;
        _instance.setChanged();
        _instance.notifyObservers();
    }


    private boolean _incomingListIsDifferent(List<IGame> incomingList) {


        if(incomingList == null && _instance._gamesList != null){
            return true;
        }
        if(incomingList != null && _instance._gamesList == null){
            return true;
        }
        if(incomingList == null && _instance._gamesList == null){
            return false;
        }
        if(incomingList.size() != _instance._gamesList.size())
        {
            return true;
        }

        int count = incomingList.size();
        for (int i = 0; i < count; i++ ) {

            if(incomingList.get(i).getId() != _instance._gamesList.get(i).getId()){
                return true;
            }
        }

        return false;
    }

    public void addToGameList(IGame game){
        _instance._gamesList.add(game);
        setChanged();
        notifyObservers();
    }
}
