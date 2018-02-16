package server.facades;

import server.proxies.ClientCommands;
import shared.commandResults.CommandResult;
import shared.facades.IServerFacade;
import shared.logging.Logger;

/**
 * Created by bdemann on 2/10/18.
 */

public class ServerFacade implements IServerFacade {
    @Override
    public CommandResult getCommands(String username) {
        CommandResult result = new CommandResult(true, ClientCommands.getCommandList(username));
        Logger.log("Here is the get commands result");
        Logger.log(result);
        return result;
    }
}
