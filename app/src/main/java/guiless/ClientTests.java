package guiless;

import proxies.GameMenuServerProxy;
import proxies.syncProxy.GameMenuServerProxySync;
import shared.facades.IGameMenuServerFacade;
import shared.results.Result;

/**
 * Created by bdemann on 2/12/18.
 */

public class ClientTests {

    public static void main(String[] args) {
        System.out.println("We can run this to quickly make sure the client complies");
        IGameMenuServerFacade gssp = new GameMenuServerProxySync();
        Result result = gssp.getGamesList("b");
        System.out.println(result.toString());
    }
}
