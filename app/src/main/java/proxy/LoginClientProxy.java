package proxy;

import shared.Command;
import shared.commandResults.CommandResult;

/**
 *
 * Created by paulinecausse on 2/3/18.
 */

public class LoginClientProxy {

    private String serverHost;
    private String serverPort;

    public LoginClientProxy()
    {
        this.serverHost = "localhost";
        this.serverPort = "8080";
    }

    //if we want customized host and port
    public LoginClientProxy(String serverHost, String serverPort)
    {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public CommandResult signIn(String username, String password)
    {
        Command command = generateLoginCommand("signIn", username, password);
        return ClientCommunicator.sendCommand(command);
    }

    public CommandResult register(String username, String password)
    {
        Command command = generateLoginCommand("register", username, password);
        return ClientCommunicator.sendCommand(command);
    }

    private Command generateLoginCommand(String methodName, String username, String password){
        String[] parmTypes = {"String", "String"};
        String[] parm = {username, password};

        Command command = new Command("server.facades.LoginServerFacade", methodName, parmTypes, parm);

        return command;
    }


}
