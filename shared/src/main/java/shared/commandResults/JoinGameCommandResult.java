package shared.commandResults;

import java.util.List;

import shared.Command;

/**
 * Created by Ben on 2/6/2018.
 */

public class JoinGameCommandResult extends CommandResult {
    public JoinGameCommandResult(boolean success, List<Command> clientCommands) {
        super(success, clientCommands);
    }

    public JoinGameCommandResult(String exceptionType, String exceptionMessage) {
        super(exceptionType, exceptionMessage);
    }
}
