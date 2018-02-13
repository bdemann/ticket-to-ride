package shared.commandResults;

import java.util.ArrayList;
import java.util.List;

import shared.ICommand;
import shared.model.IGame;

/**
 * Created by bdemann on 2/12/18.
 */

public class GameListResult extends CommandResult {
    private List<IGame> _games;

    public GameListResult(boolean success, List<IGame> games, List<ICommand> clientCommands) {
        super(success, clientCommands);
        this._games = games;
        if(this._games == null) {
            _games = new ArrayList<>();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Game List Results:");
        for(IGame game : _games) {
            sb.append(game.toString());
        }
        return sb.toString();
    }

    public List<IGame> getGameList(){
        return _games;
    }
}
