package com.a340team.tickettoride.shared;

import com.a340team.tickettoride.shared.commandResults.GeneralCommandResult;

import java.io.OutputStreamWriter;

/**
 * Created by paulinecausse on 2/3/18.
 */

public class CommandEncoder {
    private static Gson gson = new Gson();

    public CommandEncoder(){}

    public GeneralCommandResult decode(String respData)
    {
        GeneralCommandResult commandResult = gson.fromJson(respData, GeneralCommandResult.class);

        return commandResult;
    }

    public void encode(Command command, OutputStreamWriter outputStreamWriter)
    {
        gson.toJson(command, outputStreamWriter);
    }


}
