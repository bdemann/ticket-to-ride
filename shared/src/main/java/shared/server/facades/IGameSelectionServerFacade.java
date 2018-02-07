package shared.server.facades;

import shared.model.Game;
import shared.model.Player;

/**
 * Created by Ben on 2/6/2018.
 */

public interface IGameSelectionServerFacade {
    public void createGame(Player creator);
    public void joinGame(Game game, Player joiner);
}
