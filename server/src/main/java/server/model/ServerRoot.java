package server.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import server.Server;
import shared.Command;
import shared.model.Chat;
import shared.model.Game;
import shared.model.Player;

/**
 * Created by Ben on 2/6/2018.
 */

public class ServerRoot extends Observable {
    private List<Player> _players;
    private List<Game> _games;
    private List<List<Chat>> _chats;
    private int gameId = 0;
    private Map<String, List<Command>> _commands;

    private static final ServerRoot _instance = new ServerRoot();

    public static void main(String[] args){
        List<Command> commands = new ArrayList<>();
        Class<?>[] parmTypes = {String.class, String.class};
        Object[] parmValues = {"bdemann", "password"};
        Command command = new Command("server.facades.LoginServerFacade", "register", parmTypes, parmValues);
        commands.add(command);
        _instance._commands.put("bdemann", commands);
        _instance._commands.put("mcporet", commands);
        System.out.println(_instance._commands.keySet());
        if(_instance._commands.get("mcporet")==null) {
            System.out.println("it was null");
        } else {
            System.out.println("it wasn't null");
        }
        System.out.println("This is after");
        System.out.println(_instance._commands.get("bdemann"));
        System.out.println(getCommandList("bdemann"));
        System.out.println(_instance._commands.get("bdemann"));
    }

    private ServerRoot() {
        super();
        _players = new ArrayList<>();
        _games = new ArrayList<>();
        _chats = new ArrayList<>();
        _commands = new HashMap<>();
    }

    public static void addGame(Game game) {
        _instance._addGame(game);
    }

    public static void addPlayer(Player player) {
        _instance._addPlayer(player);
    }

    private void _addGame(Game game){
        game.setId(gameId);
        gameId++;
        _games.add(game);
    }

    private void _addPlayer(Player player){
        _players.add(player);
    }

    public static Game getGame(int gameId) {
        return _instance._games.get(gameId);
    }

    public static void addChat(Game game, Chat message) {
        _instance._chats.get(game.getId()).add(message);
    }

    public static Player getPlayer(String username) {
        for (Player player : _instance._players) {
            if (player.getUsername().equals(username)){
                return player;
            }
        }
        return null;
    }

    public static List<Command> getCommandList(String username) {
        List<Command> commands = _instance._commands.get(username);
        _instance._commands.put(username, new ArrayList<Command>());
        return commands;
    }
}
