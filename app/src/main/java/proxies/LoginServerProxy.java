package proxies;

import java.util.concurrent.ExecutionException;

import shared.command.Command;
import shared.command.ICommand;
import shared.results.Result;
import shared.facades.ILoginServerFacade;
import tasks.CommandTask;

/**
 * Created by Ben on 2/7/2018.
 *
 */

public class LoginServerProxy implements ILoginServerFacade{
    public LoginServerProxy(){}
    @Override
    public Result signin(String username, String password) {

        CommandTask loginTask = new CommandTask();
        loginTask.execute(generateLoginCommand("signin", username, password));

        Result results = null;

        try {
            results = loginTask.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public Result register(String username, String password) {

        CommandTask loginTask = new CommandTask();
        loginTask.execute(generateLoginCommand("register", username, password));

        Result results = null;

        try {
            results = loginTask.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return results;
    }

    private ICommand generateLoginCommand(String methodName, String username, String password){
        Class<?>[] parmTypes = {String.class, String.class};
        String[] parm = {username, password};
        String className = "server.facades.LoginServerFacade";

        return new Command(className, methodName, parmTypes, parm);
    }
}
