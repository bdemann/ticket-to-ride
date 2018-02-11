package shared.facades;

import shared.commandResults.CommandResult;

/**
 * Created by Ben on 2/6/2018.
 */

public interface ILoginServerFacade {
    public CommandResult signin(String username, String password);
    public CommandResult register(String username, String password);
}