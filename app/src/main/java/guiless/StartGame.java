package guiless;

import model.ClientRoot;
import proxies.syncProxy.GameMenuServerProxySync;
import proxies.syncProxy.GameServerProxySync;
import proxies.syncProxy.LobbyServerProxySync;
import proxies.syncProxy.LoginServerProxySync;
import shared.model.Player;
import shared.model.interfaces.IGame;
import shared.results.CreateGameResult;
import shared.results.Result;

/**
 * Created by bdemann on 3/5/18.
 */

public class StartGame {

    public static void main(String[] args) {
        Result result;
        new LoginServerProxySync().register("bdemann", "password");
        new LoginServerProxySync().register("mkporet", "password");
        new LoginServerProxySync().signin("bdemann", "password");
        new LoginServerProxySync().signin("mkporet", "password");
        result = new GameMenuServerProxySync().createGame(new Player("bdemann"), 2, "Test Game");
        System.out.println("Create Game Result:");
        System.out.println(result);
        IGame game = ((CreateGameResult) result).getGame();
        new GameMenuServerProxySync().joinGame(game.getId(), new Player("mkporet"));
        result = new LobbyServerProxySync().startGame(game, "bdemann");
        System.out.println("Start Game Result:");
        System.out.println(result);
        System.out.println(ClientRoot.getClientPlayer());
    }

}
