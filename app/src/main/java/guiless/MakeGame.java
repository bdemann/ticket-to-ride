package guiless;

import proxy.serverproxies.GameSelectionServerProxy;
import proxy.serverproxies.LoginServerProxy;
import shared.commandResults.CommandResult;
import shared.model.Player;

/**
 * Created by bdemann on 2/12/18.
 */

public class MakeGame {
    public static void main(String[] args) {
        System.out.println("We can run this to quickly make sure the client complies");
        LoginServerProxy lsp = new LoginServerProxy();
        lsp.register("bdemann", "password");
        GameSelectionServerProxy gssp = new GameSelectionServerProxy();
        CommandResult result = gssp.createGame(new Player("bdemann", "password"), 3, "The Game");
        System.out.println(result.toString());
    }
}
