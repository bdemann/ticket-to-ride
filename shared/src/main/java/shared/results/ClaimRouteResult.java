package shared.results;

import java.util.List;

import shared.command.ICommand;

/**
 * Created by bdemann on 2/28/18.
 *
 */

public class ClaimRouteResult extends Result {
    public ClaimRouteResult(boolean success, List<ICommand> clientCommands, String userMessage) {
        super(success, clientCommands, userMessage);
    }

    public ClaimRouteResult(String exceptionType, String exceptionMessage) {
        super(exceptionType, exceptionMessage);
    }
}
