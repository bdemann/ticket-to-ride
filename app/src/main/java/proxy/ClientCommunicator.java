package proxy;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import shared.Command;
import shared.CommandEncoder;
import shared.commandResults.CommandResult;

/**
 *
 *
 *
 * Created by paulinecausse on 2/3/18.
 */

public class ClientCommunicator {

    private static final String SERVER_HOST = "localhost";
    private static final String SERVER_PORT = "8080";
    private static final String URL_PREFIX = "http://" + SERVER_HOST + ":" + SERVER_PORT + "/";
    private static final String HTTP_POST = "POST";

    private static ClientCommunicator SINGLETON = new ClientCommunicator();

    public static CommandResult sendCommand(Command command){
        return SINGLETON._sendCommand(command);
    }

    //Command
    private CommandResult _sendCommand(Command command) {
        CommandResult result = null;
        try {
            result = doPost("sendCommand", command);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private CommandResult doPost(String urlPath, Command postData) throws Exception {
        try {
            URL url = new URL(URL_PREFIX + urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(HTTP_POST);
            connection.setDoOutput(true);
            connection.connect();
            CommandEncoder.encodeCommand(postData, connection.getOutputStream());
            connection.getOutputStream().close();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                CommandResult result = CommandEncoder.decodeCommandResults(connection.getInputStream());
                return result;
            } else {
                throw new Exception(
                        "doPost failed: " + urlPath + " (http code " + connection.getResponseCode() + ")");
            }
        } catch (IOException e) {
            throw e;
        }
    }



}
