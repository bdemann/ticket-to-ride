package proxies.syncProxy;

import comm.ClientCommunicator;
import shared.command.Command;
import shared.results.Result;
import shared.facades.ILoginServerFacade;

/**
 * Created by Ben on 2/7/2018.
 *
 */

public class LoginServerProxySync implements ILoginServerFacade{
    @Override
    public Result signin(String username, String password) {
        Command command = generateLoginCommand("signin", username, password);
        return ClientCommunicator.sendCommand(command);
    }

    @Override
    public Result register(String username, String password) {
        Command command = generateLoginCommand("register", username, password);
        return ClientCommunicator.sendCommand(command);
    }

    private Command generateLoginCommand(String methodName, String username, String password){
        Class<?>[] parmTypes = {String.class, String.class};
        String[] parm = {username, password};
        String className = "server.facades.LoginServerFacade";

        return new Command(className, methodName, parmTypes, parm);
    }
}
