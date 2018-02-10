package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Scanner;

import shared.Command;
import shared.CommandEncoder;
import shared.ICommand;
import shared.commandResults.CommandResult;

/**
 * Created by Ben on 2/6/2018.
 */

public class CommandHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        ICommand command = null;
        CommandResult results = null;
        try {
            command = (ICommand) CommandEncoder.decodeCommand(exchange.getRequestBody());
        } catch (Exception e){
            results = new CommandResult(e.getClass().toString(), e.getMessage());
            System.out.print(results);
            e.printStackTrace();
        }

        try {
            results = command.execute();
        } catch (Exception e){
            results = new CommandResult(e.getClass().toString(), e.getMessage());
            System.out.print(results);
            e.printStackTrace();
        }

        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        CommandEncoder.encodeCommandResults(results, exchange.getResponseBody());
        exchange.getResponseBody().close();
    }
}
