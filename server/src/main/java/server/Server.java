package server;

/**
 * Created by Ben on 2/6/2018.
 */

public class Server {
    public static void main(String[] args) {
        int serverPortNumber;
        if (args.length == 0) {
            serverPortNumber = 8080;
        } else {
            serverPortNumber = Integer.parseInt(args[0]);
        }
        new ServerCommunicator(serverPortNumber).run();
        System.out.println("Server Started on localhost:" + serverPortNumber + "/");
    }
}
