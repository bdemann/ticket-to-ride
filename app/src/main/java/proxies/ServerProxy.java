package proxies;

import java.util.concurrent.ExecutionException;

import model.ClientRoot;
import shared.command.Command;
import shared.command.ICommand;
import shared.results.Result;
import shared.facades.server.IServerFacade;
import tasks.CommandTask;
import tasks.TaskExecutor;

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
        getCommandsCommand.setGameId(ClientRoot.getClientGame().getId());

        return TaskExecutor.runTask(getCommandsCommand);
    }
}
