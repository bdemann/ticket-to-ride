package proxies;

import java.util.concurrent.ExecutionException;

import shared.command.Command;
import shared.command.ICommand;
import shared.results.Result;
import shared.serverfacades.IServerFacade;
import tasks.CommandTask;

/**
 *
 * Created by bdemann on 2/12/18.
 */

public class ServerProxy implements IServerFacade {
    @Override
    public Result getCommands(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        ICommand getCommandsCommand = new Command("server.facades.ServerFacade", "getCommands", parmTypes, parmValues);

        CommandTask getCommandsTask = new CommandTask();
        getCommandsTask.execute(getCommandsCommand);

        Result results = null;
        try {
            results = getCommandsTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return results;
    }
}
