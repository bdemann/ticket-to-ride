package com.a340team.tickettoride.client.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//Have to set up Gson
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import com.a340team.tickettoride.shared.Command;
import com.a340team.tickettoride.shared.Encoder;
import com.a340team.tickettoride.shared.commandResults.GeneralCommandResult;

/**
 * Created by paulinecausse on 2/3/18.
 */

public class ClientCommunicator {

    private static final String SERVER_HOST = "localhost";
    private static final String SERVER_PORT = "8080";
    private static final String URL_PREFIX = "http://" + SERVER_HOST + ":" + SERVER_PORT;
    private static final String HTTP_POST = "POST";

    private Encoder encoder;

    public static ClientCommunicator SINGLETON = new ClientCommunicator();

    //Command
    public GeneralCommandResult command(Command command) {
        GeneralCommandResult result = new GeneralCommandResult();
        HttpURLConnection connection = openConnection("/command");
        send(connection, command);
        result = printResponseBodyInfo(connection);

        return result;
    }

    private void send(HttpURLConnection connection, Command command)
    {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream())){
            //Encoding in JSON
            encoder.encode(command,outputStreamWriter);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private GeneralCommandResult printResponseBodyInfo(HttpURLConnection connection) {
        GeneralCommandResult commandResult = new GeneralCommandResult();
        try {
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStream respBody = connection.getInputStream();
                String respData = readString(respBody);

                commandResult = encoder.decode(respData);
            }
            else {
                commandResult.setUserMessage(connection.getResponseMessage());
            }
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commandResult;
    }


    private void sendReqBody(String result, HttpURLConnection connection)
    {
        try {
            OutputStream reqBody = connection.getOutputStream();
            writeString(result, reqBody);
            reqBody.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private HttpURLConnection openConnection(String contextIdentifier) {
        HttpURLConnection result = null;
        try {
            URL url = new URL(URL_PREFIX + contextIdentifier);
            result = (HttpURLConnection)url.openConnection();
            result.setRequestMethod(HTTP_POST);
            result.setDoOutput(true);
            result.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private static String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while ((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }


    private static void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }



}
