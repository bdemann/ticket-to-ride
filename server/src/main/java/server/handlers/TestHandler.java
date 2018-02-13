package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;

import server.model.ServerRoot;
import server.proxies.ClientCommands;
import shared.Command;
import shared.CommandEncoder;
import shared.commandResults.CommandResult;
import shared.logging.Logger;
import shared.model.IPlayer;
import shared.model.Player;

/**
 *
 * Created by Ben on 2/6/2018.
 */

public class TestHandler  implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        Class<?>[] parmTypes1 = {String.class, String.class};
        Object[] parmValues1 = {"bdemann", "password"};
        Command command1 = new Command("server.facades.LoginServerFacade", "register", parmTypes1, parmValues1);
        try {
            command1.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //createGame(IPlayer creator, int numberPlayer, int color)
        Class<?>[] parmTypes2 = {IPlayer.class, int.class, int.class};
        Object[] parmValues2 = {new Player("bdemann", "password"), 3, 4};
        Command newGame = new Command("server.facades.GameSelectionServerFacade", "createGame", parmTypes2, parmValues2);
        try {
            System.out.println("Here we are");
            CommandResult result = newGame.execute();
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {"bdemann"};
        ClientCommands.addCommand("bdemann", command1);
        Command command = new Command("server.facades.ServerFacade", "getCommands", parmTypes, parmValues);
        CommandResult result;
        try {
            result = command.execute();
        } catch (Exception e) {
            result = new CommandResult(e.getClass().toString(), e.getMessage());
            e.printStackTrace();
        }
        Logger.log(result);
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        CommandEncoder.encodeTestResults(result, exchange.getResponseBody());
        exchange.getResponseBody().close();
    }
}
