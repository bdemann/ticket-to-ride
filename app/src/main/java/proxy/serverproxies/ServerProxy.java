package proxy.serverproxies;

import java.util.concurrent.ExecutionException;

import shared.Command;
import shared.commandResults.CommandResult;
import shared.facades.IServerFacade;
import tasks.CommandTask;

/**
 * Created by bdemann on 2/12/18.
 */

public class ServerProxy implements IServerFacade {
    @Override
    public CommandResult getCommands(String username) {
        Class<?>[] parmTypes = {};
        Object[] parmValues = {};
        Command command = new Command("server.facades.ServerFacade", "getCommands", parmTypes, parmValues);
        CommandTask task = new CommandTask();
        task.execute(command);
        CommandResult result = null;
        try {
            result = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
