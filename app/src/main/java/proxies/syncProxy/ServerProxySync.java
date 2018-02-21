package proxies.syncProxy;

import comm.ClientCommunicator;
import shared.command.Command;
import shared.results.Result;
import shared.facades.IServerFacade;

/**
 *
 * Created by bdemann on 2/12/18.
 */

public class ServerProxySync implements IServerFacade {
    @Override
    public Result getCommands(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        Command getCommandsCommand = new Command("server.facades.ServerFacade", "getCommands", parmTypes, parmValues);
        return ClientCommunicator.sendCommand(getCommandsCommand);
    }
}
