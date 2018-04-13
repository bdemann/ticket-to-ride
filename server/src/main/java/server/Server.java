package server;

import java.net.InetAddress;
import java.net.UnknownHostException;

import server.comm.ServerCommunicator;
import server.facades.GameMenuServerFacade;
import server.facades.LoginServerFacade;
import server.model.ServerRoot;
import shared.facades.server.IGameMenuServerFacade;
import shared.facades.server.ILoginServerFacade;
import shared.logging.Level;
import shared.logging.Logger;
import shared.model.Player;
import shared.model.interfaces.IPlayer;

/**
 * Created by Ben on 2/6/2018.
 */

public class Server {
    public static void main(String[] args) {
        Logger.setLevel(Level.FINNER);
        if(args.length < 2) {
            Logger.log("Not enough arguments for plugin");
            Logger.log("USAGE: server PATH/TO/DATABASE/PLUGIN COMMAND_LIST_LEN");
            ServerRoot.setHasPlugin(false);
        } else {
            Logger.log("We are using a plugin");
            ServerRoot.setHasPlugin(true);
        }

        int serverPortNumber;
        String pluginPath = args[0];
        int commandListLen = Integer.parseInt(args[1]);
        if (args.length == 2) {
            serverPortNumber = 8080;
        } else {
            serverPortNumber = Integer.parseInt(args[2]);
        }
        new ServerCommunicator(serverPortNumber).run();
        ServerRoot.setPluginPath(pluginPath);
        ServerRoot.setCommandListLen(commandListLen);
        ILoginServerFacade loginServerFacade = new LoginServerFacade();
        loginServerFacade.register("z", "z");
        loginServerFacade.register("x", "x");
        loginServerFacade.register("c", "c");
        loginServerFacade.register("v", "v");
        loginServerFacade.register("b", "b");
        loginServerFacade.register("n", "n");
        loginServerFacade.register("m", "m");
        IGameMenuServerFacade gameMenuServerFacade = new GameMenuServerFacade();
        loginServerFacade.register("bdemann", "password");
        loginServerFacade.signin("bdemann", "password");
        IPlayer bdemann = new Player("bdemann", "password", -16777216);
        gameMenuServerFacade.createGame(bdemann, 2, "test game");
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String ipAddress = "localhost";
        String hostName = "hostName";
        if(inetAddress != null) {
            ipAddress = inetAddress.getHostAddress();
            hostName = inetAddress.getHostName();
        }
        Logger.log("Server Started on " + hostName + ". Addr: " + ipAddress + ":" + serverPortNumber + "/", Level.ALL);
    }
}
