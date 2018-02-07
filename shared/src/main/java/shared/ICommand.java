package shared;

import shared.commandResults.CommandResult;

/**
 * Created by Ben on 2/6/2018.
 */

public interface ICommand {
    public abstract CommandResult execute();
}
