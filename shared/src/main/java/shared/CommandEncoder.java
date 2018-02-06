package shared;

import com.google.gson.Gson;

import shared.commandResults.GeneralCommandResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by paulinecausse on 2/3/18.
 */

public class CommandEncoder {
    private static Gson gson = new Gson();

    public CommandEncoder(){}

    public static GeneralCommandResult decodeCommand(String respData)
    {
        return gson.fromJson(respData, GeneralCommandResult.class);

    }

    public static void encodeCommand(Command command, OutputStreamWriter outputStreamWriter) {
        gson.toJson(command, outputStreamWriter);
    }


    public static void encodeCommandResults(GeneralCommandResult results, OutputStream responseBody) {
        String json = gson.toJson(results);
        try {
            responseBody.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ICommand decodeCommand(InputStream requestBody) {
        //TODO implement decode Command with an imput string
        return null;
    }

    public static void encodeTestResults(Object o, OutputStream responseBody) {
        String json = gson.toJson(o);
        try {
            responseBody.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
