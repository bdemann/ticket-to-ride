package server.server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;

import shared.CommandEncoder;
import shared.ICommand;
import shared.commandResults.GeneralCommandResult;

/**
 * Created by Ben on 2/6/2018.
 */

public class CommandHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        ICommand command = (ICommand) CommandEncoder.decodeCommand(exchange.getRequestBody());
        GeneralCommandResult results = null;

        try {
            //TODO I need to know what we are putting in these Command results
            results = new GeneralCommandResult();
        } catch (Exception e) {
            results = new GeneralCommandResult();
        }

        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        CommandEncoder.encodeCommandResults(results, exchange.getResponseBody());
        exchange.getResponseBody().close();
    }
}
