package shared.facades;

import shared.results.Result;
import shared.model.Chat;
import shared.model.Game;

/**
 * Created by Ben on 2/6/2018.
 */

public interface ILobbyServerFacade {
    public Result sendChat(Chat message);
    public Result startGame(Game game, String username);
    public Result leaveGame(String username);
}
