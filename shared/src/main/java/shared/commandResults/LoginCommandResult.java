package shared.commandResults;

import java.util.List;

import shared.ICommand;

/**
 * Created by Ben on 2/6/2018.
 */

public class LoginCommandResult extends CommandResult {
    public LoginCommandResult(boolean success, List<ICommand> clientCommands) {
        super(success, clientCommands);
    }

    public LoginCommandResult(boolean success, List<ICommand> clientCommands, String userMessage){
        super(success, clientCommands, userMessage);
    }
}
