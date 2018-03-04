package server.poller;

import server.model.ServerRoot;
import server.proxies.GameMenuClientProxy;
import server.proxies.LobbyClientFacadeProxy;
import shared.model.Chat;
import shared.model.interfaces.IEdge;
import shared.model.interfaces.IGame;

/**
 * Created by bdemann on 2/12/18.
 */

public class ClientNotifications {

    private static final ClientNotifications _instance = new ClientNotifications();

    public static void playerJoinedGame(int gameId, String username) {
        new GameMenuClientProxy().joinGame(ServerRoot.getPlayer(username), ServerRoot.getGame(gameId));
    }

    public static void gameCreated(int gameId, String username) {
        new GameMenuClientProxy().createGame(ServerRoot.getGame(gameId));
    }

    public static void playerLeftGame(String username) {
        new LobbyClientFacadeProxy().leaveGame(username);
    }

    public static void gameStarted(IGame game) {
        new LobbyClientFacadeProxy().startGame(game, null);
    }

    public static void messageSent(Chat message, IGame currentGame) {
        //TODO make sure that all players in the current game get the message
    }

    public static void playerClaimedRoute(String username, IEdge route) {
        //TODO send notification about a claimed route
    }

    public static void playerDrewTrainCards(String username) {
        //TODO send notification about drawing cards.
    }

    public static void playerDrewDestinationCards(String username) {
        //TODO send notification about drawing destination cards.
    }
}
