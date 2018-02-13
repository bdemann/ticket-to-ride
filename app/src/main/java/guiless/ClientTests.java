package guiless;

import proxy.serverproxies.GameSelectionServerProxy;
import shared.commandResults.CommandResult;

/**
 * Created by bdemann on 2/12/18.
 */

public class ClientTests {

    public static void main(String[] args) {
        System.out.println("We can run this to quickly make sure the client complies");
        GameSelectionServerProxy gssp = new GameSelectionServerProxy();
        CommandResult result = gssp.getGamesList("bdemann");
        System.out.println(result.toString());
    }
}
