package guiless;

import proxies.syncProxy.GameMenuServerProxySync;
import proxies.syncProxy.LoginServerProxySync;
import shared.facades.server.IGameMenuServerFacade;
import shared.facades.server.ILoginServerFacade;
import shared.results.Result;
import shared.model.Player;

/**
 * Created by bdemann on 2/12/18.
 */

public class MakeGame {
    public static void main(String[] args) {
        System.out.println("We can run this to quickly make sure the client complies");
        ILoginServerFacade loginServerFacade = new LoginServerProxySync();
        System.out.println(loginServerFacade.register("bdemann", "password"));
        IGameMenuServerFacade menuServerFacade = new GameMenuServerProxySync();
        Result result = menuServerFacade.createGame(new Player("bdemann", "password"), 3, "The Game");
        System.out.println(result.toString());
    }
}
