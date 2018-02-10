package proxy.serverproxies;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.server.facades.ILoginServerFacade;

/**
 * Created by Ben on 2/7/2018.
 */

public class LoginServerProxy implements ILoginServerFacade{
    public LoginServerProxy(){}
    @Override
    public CommandResult signin(String username, String password) {
        return ClientCommunicator.sendCommand(generateLoginCommand("signin", username, password));
    }

    @Override
    public CommandResult register(String username, String password) {
        return ClientCommunicator.sendCommand(generateLoginCommand("register", username, password));
    }

    private Command generateLoginCommand(String methodName, String username, String password){
        Class<?>[] parmTypes = {String.class, String.class};
        String[] parm = {username, password};
        String className = "server.facades.LoginServerFacade";

        Command command = new Command(className, methodName, parmTypes, parm);

        return command;
    }
}
