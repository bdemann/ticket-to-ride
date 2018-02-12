package shared.commandResults;

import java.util.List;

import shared.ICommand;

/**
 * Created by Ben on 2/6/2018.
 */

public class ChatCommandResult extends CommandResult {
    private String message;

    public ChatCommandResult(boolean success, List<ICommand> clientCommands) {
        super(success, clientCommands);
    }

    public String getMessage(){
        return message;
    }
}
