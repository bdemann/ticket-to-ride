package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;

import shared.CommandEncoder;
import shared.ICommand;
import shared.commandResults.CommandResult;
import shared.commandResults.GeneralCommandResult;

/**
 * Created by Ben on 2/6/2018.
 */

public class CommandHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        ICommand command = (ICommand) CommandEncoder.decodeCommand(exchange.getRequestBody());
        CommandResult results = null;

        //TODO I need to know what we are putting in these Command results
        try {
            results = command.execute();
        } catch (Exception e){
            //TODO I am wondering about the merit of having the CommandResult class being abstract. It seems we could just make instances of it when we needed a GeneralCommadnResult instead of having another class whose sole purpose is to be an implementable version of the CommandResult
            results = new GeneralCommandResult(e.getClass().toString(), e.getMessage());
        }

        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        CommandEncoder.encodeCommandResults(results, exchange.getResponseBody());
        exchange.getResponseBody().close();
    }
}
