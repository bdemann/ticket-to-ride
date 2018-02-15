package tasks;

import android.os.AsyncTask;

import guifacade.LoginGuiFacade;
import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import view.LoginActivity;

/**
 * Created by BenNelson on 2/10/18.
 *
 */

public class CommandTask extends AsyncTask<Command,Void,CommandResult>{

    @Override
    protected CommandResult doInBackground(Command... commands) {

        return ClientCommunicator.sendCommand(commands[0]);
    }
}
