package shared.commandResults;

import java.util.List;

import shared.ICommand;

/**
 * Created by Ben on 2/6/2018.
 */

public class CreateGameCommandResult extends CommandResult {
    public CreateGameCommandResult(boolean success, List<ICommand> clientCommands) {
        super(success, clientCommands, "createGameSuccessfull");
    }

    public CreateGameCommandResult(boolean success, List<ICommand> clientCommands, String userMessage){
        super(success, clientCommands, userMessage);
    }
}
