package shared.facades.server;

import shared.results.Result;
import shared.model.IPlayer;

/**
 * Created by Ben on 2/6/2018.
 */

public interface IGameMenuServerFacade {
    public Result createGame(IPlayer creator, int numberPlayer, String gameName);
    public Result joinGame(int gameId, IPlayer joiner);
    public Result getGamesList(String username);
}
