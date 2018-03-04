package shared.facades.server;

import shared.results.Result;

/**
 * Created by Ben on 2/6/2018.
 */

public interface ILoginServerFacade {
    public Result signin(String username, String password);
    public Result register(String username, String password);
}
