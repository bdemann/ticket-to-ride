package com.a340team.tickettoride.shared.commandResults;

import com.a340team.tickettoride.shared.Command;

import java.util.List;

/**
 * Created by paulinecausse on 2/3/18.
 */

public abstract class CommandResult {
    String exceptionType;
    String exceptionMessage;
    List<Command> clientCommands;
    String resultType;
    boolean commandSuccess;
    String userMessage;

    public void setExceptionType(String exceptionType)
    {
        this.exceptionType = exceptionType;
    }

    public void setExceptionMessage(String exceptionMessage) { this.exceptionMessage = exceptionMessage; }

    public void setClientCommands(List<Command> clientCommands) { this.clientCommands = clientCommands; }

    public void setResultType(String resultType)
    {
        this.resultType = resultType;
    }

    public void setCommandSuccess(boolean commandSuccess)
    {
        this.commandSuccess = commandSuccess;
    }

    public void setUserMessage(String userMessage)
    {
        this.userMessage = userMessage;
    }

    public String getExceptionType()
    {
        return exceptionType;
    }

    public String getExceptionMessage()
    {
        return exceptionMessage;
    }

    public List<Command> getClientCommands() { return clientCommands; }

    public String getResultType() { return resultType; }

    public boolean getCommandSuccess()
    {
        return commandSuccess;
    }

    public String getUserMessage()
    {
        return userMessage;
    }
}
