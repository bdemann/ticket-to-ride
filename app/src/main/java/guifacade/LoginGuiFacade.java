package guifacade;

import proxy.LoginClientProxy;
import proxy.serverproxies.LoginServerProxy;
import shared.commandResults.CommandResult;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class LoginGuiFacade {

    public static void signIn(String username, String password) {
        //This GuiFacade will send the username and password on to the server.
        //It will receive certain results and decide what to do with them.
        LoginServerProxy lsp = new LoginServerProxy();
        CommandResult commandResults = lsp.signin(username,password);

        //Now if things work properly, we should be able to disect the commandResults.
    }

    public static void register(String username, String password, String password_confirm){

    }
}
