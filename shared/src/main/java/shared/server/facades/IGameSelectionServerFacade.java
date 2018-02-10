package shared.server.facades;

import shared.commandResults.CommandResult;
import shared.model.Game;
import shared.model.Player;

/**
 * Created by Ben on 2/6/2018.
 */

public interface IGameSelectionServerFacade {
    public CommandResult createGame(Player creator, int numberPlayer);
    public CommandResult joinGame(Game game, Player joiner);
}
