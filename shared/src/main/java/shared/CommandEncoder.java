package shared;

import com.google.gson.Gson;

import shared.commandResults.GeneralCommandResult;

import java.io.OutputStreamWriter;

/**
 * Created by paulinecausse on 2/3/18.
 */

public class CommandEncoder {
    private static Gson gson = new Gson();

    public CommandEncoder(){}

    public GeneralCommandResult decodeCommand(String respData)
    {
        return gson.fromJson(respData, GeneralCommandResult.class);

    }

    public void encodeCommand(Command command, OutputStreamWriter outputStreamWriter)
    {
        gson.toJson(command, outputStreamWriter);
    }


}
