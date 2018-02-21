package shared.results;

import java.util.List;

import shared.command.ICommand;
import shared.model.IGame;

/**
 * Created by Ben on 2/6/2018.
 */

public class CreateGameResult extends Result {

    private IGame _newGame;

    public CreateGameResult(IGame game, boolean success, List<ICommand> clientCommands) {
        super(success, clientCommands, "createGameSuccessfull");
    }

    public CreateGameResult(IGame game, boolean success, List<ICommand> clientCommands, String userMessage){
        super(success, clientCommands, userMessage);
    }

    public IGame getGame() {
        return _newGame;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Create Game Result - ");
        sb.append("Success: " + _success);
        sb.append(" | ");
        sb.append("Created Game: " + _newGame);
        return sb.toString();
    }
}
