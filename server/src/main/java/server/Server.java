package server;

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
        Logger.log("Server Started on localhost:" + serverPortNumber + "/", Level.FINE);
    }
}
