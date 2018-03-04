package guiless;

import proxies.syncProxy.GameMenuServerProxySync;
import proxies.syncProxy.LobbyServerProxySync;
import proxies.syncProxy.LoginServerProxySync;
import shared.model.interfaces.IGame;
import shared.model.Player;
import shared.results.CreateGameResult;
import shared.results.Result;

/**
 * Created by bdemann on 2/20/18.
 */

public class DoAllTheThings {
    public static void main(String[] args) {
        Result result = new LoginServerProxySync().register("bdemann", "password");
        System.out.println("Register Result:");
        System.out.println(result);
        result = new LoginServerProxySync().signin("bdemann", "password");
        System.out.println("Login Result:");
        System.out.println(result);
        result = new GameMenuServerProxySync().createGame(new Player("bdemann"), 2, "Test Game");
        System.out.println("Create Game Result:");
        System.out.println(result);
        IGame game = ((CreateGameResult) result).getGame();
        result = new LobbyServerProxySync().leaveGame("bdemann");
        System.out.println("Leave Game Result:");
        System.out.println(result);
        result = new GameMenuServerProxySync().joinGame(game.getId(), new Player("bdemann"));
        System.out.println("Leave Game Result:");
        System.out.println(result);
    }
}
