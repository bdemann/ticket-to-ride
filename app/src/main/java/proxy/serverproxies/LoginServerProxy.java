package proxy.serverproxies;

import android.content.Context;
import android.os.AsyncTask;

import java.util.concurrent.ExecutionException;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.facades.ILoginServerFacade;
import tasks.LoginTask;
import view.LoginActivity;

/**
 * Created by Ben on 2/7/2018.
 *
 */

public class LoginServerProxy implements ILoginServerFacade{
    public LoginServerProxy(){}
    @Override
    public CommandResult signin(String username, String password) {

        LoginTask loginTask = new LoginTask();
        loginTask.execute(generateLoginCommand("signin", username, password));

        CommandResult results = null;

        try {
            results = loginTask.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public CommandResult register(String username, String password) {

        LoginTask loginTask = new LoginTask();
        loginTask.execute(generateLoginCommand("register", username, password));

        CommandResult results = null;

        try {
            results = loginTask.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return results;
    }

    private Command generateLoginCommand(String methodName, String username, String password){
        Class<?>[] parmTypes = {String.class, String.class};
        String[] parm = {username, password};
        String className = "server.facades.LoginServerFacade";

        return new Command(className, methodName, parmTypes, parm);
    }
}
