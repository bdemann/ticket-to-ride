package server.facades;

import server.poller.ClientCommands;
import shared.results.Result;
import shared.serverfacades.IServerFacade;
import shared.logging.Logger;

/**
 * Created by bdemann on 2/10/18.
 */

public class ServerFacade implements IServerFacade {
    @Override
    public Result getCommands(String username) {
        Result result = new Result(true, ClientCommands.getCommandList(username), "Got Command List");
        Logger.log("Here is the get commands result");
        Logger.log(result);
        return result;
    }
}
