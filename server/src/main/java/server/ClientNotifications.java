package server;

import server.model.ServerRoot;
import server.proxies.GameSelectionClientProxy;

/**
 * Created by bdemann on 2/12/18.
 */

public class ClientNotifications {

    private static final ClientNotifications _instance = new ClientNotifications();

    public static void playerJoinedGame(int gameId, String username) {
        new GameSelectionClientProxy().joinGame(ServerRoot.getPlayer(username), ServerRoot.getGame(gameId));
//        //Get all the users that are members of the game
//        IGame game = ServerRoot.getGame(gameId);
//        List<IPlayer> players = game.getPlayers();
//        //Inform all of those users that the new player joined the game
//        for (IPlayer player : players) {
//            //Don't inform the current user?
//            if(!player.getUsername().equals(username)){
//                new GameSelectionClientProxy().updatePlayerList(player.getUsername());
//            }
//        }
    }

    public static void gameCreated(int gameId, String username) {
        new GameSelectionClientProxy().createGame(ServerRoot.getGame(gameId));
        //Get all users
//        for(String user : ClientCommands.getUsers()){
//            //Inform all of those users that there is a new game
//            if (!user.equals(username)) { //unless its the current user
//                new GameSelectionClientProxy().updateGameList(user);
//            }
//        }
    }
}
