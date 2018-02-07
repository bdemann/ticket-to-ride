package shared.commandResults;

import java.util.List;

import shared.Command;

/**
 * Created by Ben on 2/6/2018.
 */

public class RegisterCommandResult extends CommandResult {
    public RegisterCommandResult(boolean success, List<Command> clientCommands) {
        super(success, clientCommands);
    }

    public RegisterCommandResult(String exceptionType, String exceptionMessage) {
        super(exceptionType, exceptionMessage);
    }
}
