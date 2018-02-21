package server.poller;

import server.model.ServerRoot;
import server.proxies.GameMenuClientProxy;

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
}
