package server.handlers;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import shared.Command;
import shared.CommandEncoder;
import shared.ICommand;
import shared.commandResults.CommandResult;

/**
 * Created by Ben on 2/6/2018.
 */

public class CommandHandler implements HttpHandler {
//    @Override
//    public void handle(HttpExchange exchange) throws IOException {
//
//        System.out.print("Hello");
//        ICommand command = (ICommand) CommandEncoder.decodeCommand(exchange.getRequestBody());
//        System.out.print("Command: ");
//        CommandResult results = null;
//
//        //TODO I need to know what we are putting in these Command results
//        try {
//            results = command.execute();
//        } catch (Exception e){
//            //TODO I am wondering about the merit of having the CommandResult class being abstract. It seems we could just make instances of it when we needed a GeneralCommadnResult instead of having another class whose sole purpose is to be an implementable version of the CommandResult
//            results = new CommandResult(e.getClass().toString(), e.getMessage());
//            System.out.print(results);
//            e.printStackTrace();
//        }
//
//        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
//        CommandEncoder.encodeCommandResults(results, exchange.getResponseBody());
//        exchange.getResponseBody().close();
//    }

//    public Gson gson = new Gson();
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Object result;

        try (InputStreamReader inputStreamReader = new InputStreamReader(exchange.getRequestBody())) {
            Command command = new Command(inputStreamReader);

            try {
                result = command.execute();
            }catch (Exception e){
                e.printStackTrace();
                result = new CommandResult("Exception", e.getMessage());
            }
            String functResult = CommandEncoder.encodeGeneric(result);
//            String functResult = gson.toJson(result);

            exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);

            OutputStream os = exchange.getResponseBody();
            os.write(functResult.getBytes());
            os.close();
        }
        catch (IOException e)
        {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_SERVER_ERROR, 0);
            e.printStackTrace();
        }
    }
}
