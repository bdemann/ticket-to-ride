package shared.commandResults;

import shared.ICommand;

import java.io.Serializable;
import java.util.List;

/**
 * Created by paulinecausse on 2/3/18.
 */

public class CommandResult implements Serializable {
    String exceptionType;
    String exceptionMessage;
    List<ICommand> clientCommands;
    String resultType;
    boolean commandSuccess;
    String userMessage;
    Object result;

    public CommandResult(boolean success, List<ICommand> clientCommands){
        this.commandSuccess = success;
        this.clientCommands = clientCommands;
    }

    public CommandResult(boolean success, List<ICommand> clientCommands, String userMessage){
        this.commandSuccess = success;
        this.userMessage = userMessage;
        this.clientCommands = clientCommands;
    }

    public CommandResult(String exceptionType, String exceptionMessage){
        this.commandSuccess = false;
        this.exceptionType = exceptionType;
        this.exceptionMessage = exceptionMessage;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Success: ").append(commandSuccess);
        for (ICommand command : clientCommands){
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

    public void setClientCommands(List<ICommand> clientCommands) { this.clientCommands = clientCommands; }

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

    public List<ICommand> getClientCommands() { return clientCommands; }

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
