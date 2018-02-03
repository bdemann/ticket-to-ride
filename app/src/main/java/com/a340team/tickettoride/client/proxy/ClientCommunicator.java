package com.a340team.tickettoride.client.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import shared.command.Command;

/**
 * Created by paulinecausse on 2/3/18.
 */

public class ClientCommunicator {

    private static final String SERVER_HOST = "localhost";
    private static final String SERVER_PORT = "8080";
    private static final String URL_PREFIX = "http://" + SERVER_HOST + ":" + SERVER_PORT;
    private static final String HTTP_POST = "POST";

    public static ClientCommunicator SINGLETON = new ClientCommunicator();

    //Static variables
    private static Gson gson = new Gson();      //make a decoder class instead


    //Command
    public Result command(Command command) {
        Result result = "";
        HttpURLConnection connection = openConnection("/command");
        send(connection, command);
        functResult = printResponseBodyInfo(connection);

        return result;
    }

    private void send(HttpURLConnection connection, Command command)
    {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream())){
            //Encoding in JSON
            gson.toJson(command, outputStreamWriter);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Result printResponseBodyInfo(HttpURLConnection connection) {
        Result result = "OOPS";
        try {
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStream respBody = connection.getInputStream();
                String respData = readString(respBody);

                result = gson.fromJson(respData, Result.class);
            }
            else {
                result.setErrorMessage(connection.getResponseMessage());
            }
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
