package shared.serverfacades;

import shared.results.Result;
import shared.model.IGame;

/**
 * Created by Ben on 2/6/2018.
 */

public interface ILobbyServerFacade {
    Result startGame(IGame game, String username);
    Result leaveGame(String username);
}
