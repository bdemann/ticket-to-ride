package shared.commandResults;

import java.util.List;

import shared.ICommand;
import shared.model.IGame;

/**
 * Created by bdemann on 2/12/18.
 */

public class GameListCommandResult extends CommandResult {
    private final List<IGame> _games;

    public GameListCommandResult(boolean success, List<IGame> games, List<ICommand> clientCommands) {
        super(success, clientCommands);
        this._games = games;
    }

    public List<IGame> getGameList(){
        return _games;
    }
}
