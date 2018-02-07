package shared.commandResults;

import java.util.List;

import shared.Command;

/**
 * Created by Ben on 2/6/2018.
 */

public class LoginCommandResult extends CommandResult {
    public LoginCommandResult(boolean success, List<Command> clientCommands) {
        super(success, clientCommands);
    }

    public LoginCommandResult(String exceptionType, String exceptionMessage) {
        super(exceptionType, exceptionMessage);
    }
}
