package com.a340team.tickettoride.client;

import java.util.Observable;

/**
 * Created by BenNelson on 2/2/18.
 *
 */

/*
    What's up?
*/

public class ClientRoot extends Observable {

    private Player clientPlayer;
    private Game clientGame;

    public ClientRoot(Player player, Game game) {
        this.clientPlayer = player;
        this.clientGame = game;
    }
    public void setClientPlayer(Player player) {
        this.clientPlayer = player;
        setChanged();
        notifyObservers();
    }
    public Player getClientPlayer(){
        return clientPlayer;
    }

    public Game getClientGame() {
        return clientGame;
    }

    public void setClientGame(Game clientGame) {
        this.clientGame = clientGame;
        setChanged();
        notifyObservers();
    }
}
