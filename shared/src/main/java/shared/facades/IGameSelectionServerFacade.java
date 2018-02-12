package shared.facades;

import shared.commandResults.CommandResult;
import shared.model.Game;
import shared.model.Player;

/**
 * Created by Ben on 2/6/2018.
 */

public interface IGameSelectionServerFacade {
    public CommandResult createGame(Player creator, int numberPlayer, int color, String gameName);
    public CommandResult joinGame(int gameId, Player joiner);
}
