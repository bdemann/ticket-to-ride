package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;

import shared.Command;
import shared.CommandEncoder;
import shared.commandResults.CommandResult;

/**
 * Created by Ben on 2/6/2018.
 */

public class TestHandler  implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String[] parmTypes = {String.class.toString(), String.class.toString()};
        Object[] parmValues = {"bdemann", "password"};
        Command command = new Command("server.facades.LoginServerFacade", "register", parmTypes, parmValues);
        System.out.println(command);
        CommandResult result;
        try {
            result = command.execute();
        } catch (Exception e) {
            result = new CommandResult(e.getClass().toString(), e.getMessage());
            e.printStackTrace();
        }

        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        CommandEncoder.encodeTestResults(result, exchange.getResponseBody());
        exchange.getResponseBody().close();
    }
}
