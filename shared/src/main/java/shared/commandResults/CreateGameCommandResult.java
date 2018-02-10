package shared.commandResults;

import java.util.List;

import shared.Command;

/**
 * Created by Ben on 2/6/2018.
 */

public class CreateGameCommandResult extends CommandResult {
    public CreateGameCommandResult(boolean success, List<Command> clientCommands) {
        super(success, clientCommands);
    }

    public CreateGameCommandResult(boolean success, String userMessage){
        super(success, userMessage);
    }
}
