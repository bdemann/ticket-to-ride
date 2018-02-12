package model;


import shared.model.Game;
import shared.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by BenNelson on 2/2/18.
 *
 */


public class ClientRoot extends Observable {

    private Player _clientPlayer;
    private Game _clientGame;
    private List<Game> _listGames;
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
    public Player getClientPlayer(){
        return _clientPlayer;
    }

    public Game getClientGame() {
        return _clientGame;
    }

    public List<Game> getListGames() {
        return _listGames;
    }

    public void setClientPlayer(Player player) {
        this._clientPlayer = player;
        setChanged();
        //The notify observers method can be overloaded with an object, will then be Object o param
        //for the update function.
        notifyObservers();
    }

    public void setClientGame(Game clientGame) {
        this._clientGame = clientGame;
        setChanged();
        notifyObservers();
    }

    public void setListGames(Game game){
        this._listGames.add(game);
    }
}
