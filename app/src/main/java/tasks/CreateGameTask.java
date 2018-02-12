package tasks;

import android.os.AsyncTask;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;

/**
 *
 * Created by BenNelson on 2/12/18.
 */

public class CreateGameTask extends AsyncTask<Command,Void,CommandResult> {

    @Override
    protected CommandResult doInBackground(Command... commands) {

        return ClientCommunicator.sendCommand(commands[0]);
    }
}
