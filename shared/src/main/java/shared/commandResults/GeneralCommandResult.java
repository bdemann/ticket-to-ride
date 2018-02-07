package shared.commandResults;

import java.util.List;

import shared.Command;

/**
 * Created by paulinecausse on 2/3/18.
 */

public class GeneralCommandResult extends CommandResult {
    public GeneralCommandResult(boolean success, List<Command> clientCommands) {
        super(success, clientCommands);
    }

    public GeneralCommandResult(String exceptionType, String exceptionMessage) {
        super(exceptionType, exceptionMessage);
    }
}
