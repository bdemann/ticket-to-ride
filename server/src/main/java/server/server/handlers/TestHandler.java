package server.server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;

import shared.CommandEncoder;

/**
 * Created by Ben on 2/6/2018.
 */

public class TestHandler  implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
        CommandEncoder.encodeTestResults("These are the results from the Test Handler", exchange.getResponseBody());
        exchange.getResponseBody().close();
    }
}
