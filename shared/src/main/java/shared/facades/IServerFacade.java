package shared.facades;

import shared.commandResults.CommandResult;

/**
 * Created by bdemann on 2/10/18.
 */

public interface IServerFacade {
    public CommandResult getCommands(String username);
}
