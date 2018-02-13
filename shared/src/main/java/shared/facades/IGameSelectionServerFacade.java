package shared.facades;

import shared.commandResults.CommandResult;
import shared.commandResults.GameListCommandResult;
import shared.model.IPlayer;

/**
 * Created by Ben on 2/6/2018.
 */

public interface IGameSelectionServerFacade {
    public CommandResult createGame(IPlayer creator, int numberPlayer, String gameName);
    public CommandResult joinGame(int gameId, IPlayer joiner);
    public GameListCommandResult getGamesList(String username);
}
