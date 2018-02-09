package shared;

import com.google.gson.Gson;

import shared.commandResults.CommandResult;

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

//    public static void main(String[] args){
//        String methods = "method";
//        String[] paramTypes = {"String"};
//        String[] param = {"hello"};
//        Command command = new Command("class", methods,paramTypes,param);
//
//        encodeCommand(command);
//    }


    public static CommandResult decodeCommand(String respData)
    {
        return gson.fromJson(respData, CommandResult.class);

    }

    public static void encodeCommand(Command command, OutputStreamWriter outputStreamWriter) {
        gson.toJson(command, outputStreamWriter);
        String json = gson.toJson(command);
        System.out.print(json);
    }


    public static void encodeCommandResults(CommandResult results, OutputStream responseBody) {
        String json = gson.toJson(results);
        try {
            responseBody.write(json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ICommand decodeCommand(InputStream requestBody) {
        //TODO implement decode Command with an input string
//        System.out.print("\nGSON: " + gson.fromJson(requestBody.toString(), Command.class) + "\n");
        return gson.fromJson(requestBody.toString(), Command.class);
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
