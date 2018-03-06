package tasks;

import java.util.concurrent.ExecutionException;

import shared.command.ICommand;
import shared.results.Result;

/**
 * Created by bdemann on 3/5/18.
 */

public class TaskExecutor {

    public static Result runTask(ICommand command) {
        CommandTask task = new CommandTask();
        task.execute(command);

        Result result = null;
        try {
            result = task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            //TODO I was thinking about sending off an error result if we crash on the get but then again maybe an error result is best left for when the server gets errors. IDK what do you guys think?
//            result = new Result(e.getClass().toString(), e.getMessage());
        }

        return result;
    }
}
