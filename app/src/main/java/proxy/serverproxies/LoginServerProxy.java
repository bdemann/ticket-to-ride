package proxy.serverproxies;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.server.facades.ILoginServerFacade;

/**
 * Created by Ben on 2/7/2018.
 */

public class LoginServerProxy implements ILoginServerFacade{
    @Override
    public CommandResult signin(String username, String password) {
        return ClientCommunicator.sendCommand(generateLoginCommand("signin", username, password));
    }

    @Override
    public CommandResult register(String username, String password) {
        return ClientCommunicator.sendCommand(generateLoginCommand("register", username, password));
    }

    private Command generateLoginCommand(String methodName, String username, String password){
        String[] paramTypes = new String[2];
        paramTypes[0] = "String";
        paramTypes[1] = "String";
        String[] param = new String[2];
        param[0] = username;
        param[1] = password;

        Command command = new Command("server.facades.LoginServerFacade", methodName, paramTypes, param);

        return command;
    }
}
