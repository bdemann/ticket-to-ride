package server;

import java.net.InetAddress;
import java.net.UnknownHostException;

import server.comm.ServerCommunicator;
import server.facades.GameMenuServerFacade;
import server.facades.LoginServerFacade;
import shared.facades.server.IGameMenuServerFacade;
import shared.facades.server.ILoginServerFacade;
import shared.logging.Level;
import shared.logging.Logger;
import shared.model.Player;

/**
 * Created by Ben on 2/6/2018.
 */

public class Server {
    public static void main(String[] args) {
        Logger.setLevel(Level.FINNER);
        int serverPortNumber;
        if (args.length == 0) {
            serverPortNumber = 8080;
        } else {
            serverPortNumber = Integer.parseInt(args[0]);
        }
        new ServerCommunicator(serverPortNumber).run();
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
        gameMenuServerFacade.createGame("bdemann", 2, "test game");
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
