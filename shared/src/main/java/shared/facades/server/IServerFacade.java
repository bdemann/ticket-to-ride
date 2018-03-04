package shared.facades.server;

import shared.results.Result;

/**
 * Created by bdemann on 2/10/18.
 */

public interface IServerFacade {
    public Result getCommands(String username);
}
