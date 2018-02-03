package com.a340team.tickettoride.client.proxy;

import shared.command.Command;

/**
 * Created by paulinecausse on 2/3/18.
 */

public class ServerProxy {

    private String serverHost;
    private String serverPort;

    public static final ServerProxy SINGLETON = new ServerProxy();

    public ServerProxy()
    {
        this.serverHost = "localhost";
        this.serverPort = "8080";
    }

    //if we want customized host and port
    public ServerProxy(String serverHost, String serverPort)
    {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public Result signIn(String username, String password)
    {
        Command command = generateLoginCommand("signIn", username, password);
        Result result = ClientCommunicator.SINGLETON.command(command);
        return result;
    }

    public Result register(String username, String password)
    {
        Command command = generateLoginCommand("register", username, password);
        Result result = ClientCommunicator.SINGLETON.command(command);
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
