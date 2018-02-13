package shared.commandResults;

import java.util.List;

import shared.ICommand;
import shared.model.IGame;

/**
 * Created by Ben on 2/6/2018.
 */

public class JoinGameCommandResult extends CommandResult {
    public JoinGameCommandResult(IGame joinedGame, boolean success, List<ICommand> clientCommands) {
        super(success, clientCommands);
    }

    public JoinGameCommandResult(IGame joinedGame, boolean success, List<ICommand> clientCommands, String userMessage){
        super(success, clientCommands, userMessage);
    }
}
