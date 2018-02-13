package tasks;

import android.os.AsyncTask;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.logging.Logger;

/**
 *
 * Created by BenNelson on 2/12/18.
 */

public class JoinGameTask extends AsyncTask<Command,Void,CommandResult> {
    @Override
    protected void onPostExecute(CommandResult commandResult) {
        super.onPostExecute(commandResult);
        Logger.log("We are looking at the results:");
        Logger.log(commandResult);
    }

    @Override
    protected CommandResult doInBackground(Command... commands) {

        return ClientCommunicator.sendCommand(commands[0]);
    }
}
