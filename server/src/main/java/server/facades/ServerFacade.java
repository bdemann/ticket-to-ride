package server.facades;

import server.proxies.ClientCommands;
import shared.commandResults.CommandResult;
import shared.facades.IServerFacade;

/**
 * Created by bdemann on 2/10/18.
 */

public class ServerFacade implements IServerFacade {
    @Override
    public CommandResult getCommands(String username) {
        return new CommandResult(true, ClientCommands.getCommandList(username));
    }
}
