package server.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

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
    private List<List<Chat>> chats;
    private List<Command> commands = new ArrayList<>();

    private static final ServerRoot _instance = new ServerRoot();

    private ServerRoot(){
        super();
    }

    public static void addGame(Game game) {
        _instance._addGame(game);
    }

    public static void addPlayer(Player player) {
        _instance._addPlayer(player);
    }

    private void _addGame(Game game){
        _games.add(game);
    }

    private void _addPlayer(Player player){
        _players.add(player);
    }

    public static Game getGame(int gameId) {
        return _instance._games.get(gameId);
    }

    public static void addChat(Game game, Chat message) {
        _instance.chats.get(game.getId()).add(message);
    }

    public static Player getPlayer(String username) {
        for (Player player : _instance._players) {
            if (player.getUsername().equals(username)){
                return player;
            }
        }
        return null;
    }

    public static List<Command> getCommandList() {
        //TODO I am not really sure how we are going to keep track of this. I'm just going to send a plain list. Do we want to keep a list for each player. If yes where do we store that, if no do we just have a lit of all the commands?
        return _instance.commands;
    }
}
