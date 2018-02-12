package server.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import shared.Command;
import shared.ICommand;
import shared.model.Chat;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 * Created by Ben on 2/6/2018.
 */

public class ServerRoot extends Observable {
    private List<IPlayer> _players;
    private List<IGame> _games;
    private List<List<Chat>> _chats;
    private int gameId = 0;

    private static final ServerRoot _instance = new ServerRoot();

    private ServerRoot() {
        super();
        _players = new ArrayList<>();
        _games = new ArrayList<>();
        _chats = new ArrayList<>();
    }

    public static void addGame(IGame game) {
        _instance._addGame(game);
    }

    public static void addPlayer(IPlayer player) {
        _instance._addPlayer(player);
    }

    private void _addGame(IGame game){
        game.setId(gameId);
        gameId++;
        _games.add(game);
    }

    private void _addPlayer(IPlayer player){
        _players.add(player);
    }

    public static IGame getGame(int gameId) {
        return _instance._games.get(gameId);
    }

    public static void addChat(IGame game, Chat message) {
        _instance._chats.get(game.getId()).add(message);
    }

    public static IPlayer getPlayer(String username) {
        for (IPlayer player : _instance._players) {
            if (player.getUsername().equals(username)){
                return player;
            }
        }
        return null;
    }

    public static List<IGame> getGames() {
        return _instance._games;
    }
    public static List<Game> getGames(){
        return _instance._games;
    }
}
