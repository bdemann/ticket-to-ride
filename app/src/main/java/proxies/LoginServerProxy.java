package proxies;

import java.util.concurrent.ExecutionException;

import shared.command.Command;
import shared.command.ICommand;
import shared.results.Result;
import shared.facades.server.ILoginServerFacade;
import tasks.CommandTask;
import tasks.TaskExecutor;

/**
 * Created by Ben on 2/7/2018.
 *
 */

public class LoginServerProxy implements ILoginServerFacade{
    public LoginServerProxy(){}
    @Override
    public Result signin(String username, String password) {
        return TaskExecutor.runTask(generateLoginCommand("signin", username, password));
    }

    @Override
    public Result register(String username, String password) {
        return TaskExecutor.runTask(generateLoginCommand("register", username, password));
    }

    private ICommand generateLoginCommand(String methodName, String username, String password){
        Class<?>[] parmTypes = {String.class, String.class};
        String[] parm = {username, password};
        String className = "server.facades.LoginServerFacade";

        return new Command(className, methodName, parmTypes, parm);
    }
}
