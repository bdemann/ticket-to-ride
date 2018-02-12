package shared.commandResults;

import shared.Command;

import java.io.Serializable;
import java.util.List;

/**
 * Created by paulinecausse on 2/3/18.
 */

public class CommandResult implements Serializable {
    String exceptionType;
    String exceptionMessage;
    List<Command> clientCommands;
    String resultType;
    boolean commandSuccess;
    String userMessage;
    Object result;

    public CommandResult(boolean success, List<Command> clientCommands){
        this.commandSuccess = success;
        this.clientCommands = clientCommands;
    }

    public CommandResult(boolean success, String userMessage){
        this.commandSuccess = success;
        this.userMessage = userMessage;
    }

    public CommandResult(String exceptionType, String exceptionMessage){
        this.commandSuccess = false;
        this.exceptionType = exceptionType;
        this.exceptionMessage = exceptionMessage;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Success: " + commandSuccess);
        for (Command command : clientCommands){
            sb.append(command.toString());
        }
        return sb.toString();
    }

    public void setResult(Object o){
        this.result = o;
    }

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

    public Object getResult(){
        return result;
    }
}
