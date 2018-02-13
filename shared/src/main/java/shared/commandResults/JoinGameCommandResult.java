package shared.commandResults;

import java.util.List;

import shared.ICommand;
import shared.model.IGame;

/**
 * Created by Ben on 2/6/2018.
 */

public class JoinGameCommandResult extends CommandResult {

    private IGame game;

    public JoinGameCommandResult(IGame joinedGame, boolean success, List<ICommand> clientCommands) {
        super(success, clientCommands);
        this.game = joinedGame;
        this.result = joinedGame;
    }

    public JoinGameCommandResult(IGame joinedGame, boolean success, List<ICommand> clientCommands, String userMessage){
        super(success, clientCommands, userMessage);
        this.game = joinedGame;
        this.result = joinedGame;
    }

    public IGame getGame() {
        return game;
    }
}
