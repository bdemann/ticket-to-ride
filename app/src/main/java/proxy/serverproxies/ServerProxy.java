package proxy.serverproxies;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.facades.IServerFacade;

/**
 *
 * Created by bdemann on 2/12/18.
 */

public class ServerProxy implements IServerFacade {
    @Override
    public CommandResult getCommands(String username) {
        Class<?>[] parmTypes = {};
        Object[] parmValues = {};
        return ClientCommunicator.sendCommand(new Command("server.facades.ServerFacade", "getCommands", parmTypes, parmValues));
    }
}
