package guifacade;

import model.ClientRoot;
import proxy.serverproxies.GameSelectionServerProxy;
import shared.commandResults.CommandResult;
import shared.model.Game;
import shared.model.Player;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class JoinGameGuiFacade {
    private static ClientRoot _clientRoot = ClientRoot.instance();

    public static CommandResult joinGame(Game game) {
        GameSelectionServerProxy gssp = new GameSelectionServerProxy();
        Player player = _clientRoot.getClientPlayer();

        if(player == null){

            return new CommandResult(false,"Could not find player");
        }

        CommandResult commandResult = gssp.joinGame(game, player);

        if(commandResult.getCommandSuccess()){
            _addGame(game);
        }

        return commandResult;
    }

    private static void _addGame(Game game){
        _clientRoot.setClientGame(game);
    }
}
