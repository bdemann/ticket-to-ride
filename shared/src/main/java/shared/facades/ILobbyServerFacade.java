package shared.facades;

import shared.commandResults.CommandResult;
import shared.model.Chat;
import shared.model.Game;

/**
 * Created by Ben on 2/6/2018.
 */

public interface ILobbyServerFacade {
    public CommandResult sendChat(Chat message);
    public CommandResult startGame(Game game);
}
