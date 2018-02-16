package proxy.serverproxies;

import java.util.concurrent.ExecutionException;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.facades.IServerFacade;
import tasks.CommandTask;

/**
 *
 * Created by bdemann on 2/12/18.
 */

public class ServerProxy implements IServerFacade {
    @Override
    public CommandResult getCommands(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        Command getCommandsCommand = new Command("server.facades.ServerFacade", "getCommands", parmTypes, parmValues);

        CommandTask getCommandsTask = new CommandTask();
        getCommandsTask.execute(getCommandsCommand);

        CommandResult results = null;
        try {
            results = getCommandsTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return results;
    }
}
