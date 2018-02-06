package proxy;

import shared.Command;
import shared.commandResults.GeneralCommandResult;

/**
 *
 * Created by paulinecausse on 2/3/18.
 */

public class LoginClientProxy {

    private String serverHost;
    private String serverPort;

    public static final LoginClientProxy SINGLETON = new LoginClientProxy();

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

    public GeneralCommandResult signIn(String username, String password)
    {
        Command command = generateLoginCommand("signIn", username, password);
        GeneralCommandResult result = ClientCommunicator.SINGLETON.command(command);
        return result;
    }

    public GeneralCommandResult register(String username, String password)
    {
        Command command = generateLoginCommand("register", username, password);
        GeneralCommandResult result = ClientCommunicator.SINGLETON.command(command);
        return result;
    }

    private Command generateLoginCommand(String methodName, String username, String password){
        String[] paramTypes = new String[2];
        paramTypes[0] = "String";
        paramTypes[1] = "String";
        String[] param = new String[2];
        param[0] = username;
        param[1] = password;

        Command command = new Command(methodName, paramTypes, param);

        return command;
    }


}
