package server;

import server.comm.ServerCommunicator;
import server.facades.LoginServerFacade;
import shared.serverfacades.ILoginServerFacade;
import shared.logging.Level;
import shared.logging.Logger;

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
        Logger.log("Server Started on localhost:" + serverPortNumber + "/", Level.FINE);
    }
}
