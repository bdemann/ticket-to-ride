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
    private List<IGame> _listGames;
    private static ClientRoot _instance;

    public static ClientRoot instance() {

        if (_instance == null)
            _instance = new ClientRoot();
        return _instance;
    }

    private ClientRoot(){
        this._clientPlayer = null;
        this._clientGame = null;
        this._listGames = new ArrayList<>();
    }

    //Getters and Setters
    public IPlayer getClientPlayer(){
        return _clientPlayer;
    }

    public IGame getClientGame() {
        return _clientGame;
    }

    public List<IGame> getListGames() {
        return _listGames;
    }

    public void setClientPlayer(IPlayer player) {
        this._clientPlayer = player;
        setChanged();
        //The notify observers method can be overloaded with an object, will then be Object o param
        //for the update function.
        notifyObservers();
    }

    public void setClientGame(IGame clientGame) {
        this._clientGame = clientGame;
        setChanged();
        notifyObservers();
    }

    public void setListGames(List<IGame> list){
        this._listGames = list;
        setChanged();
        notifyObservers();
    }

    public void addToGameList(IGame game){
        this._listGames.add(game);
        setChanged();
        notifyObservers();
    }
}
