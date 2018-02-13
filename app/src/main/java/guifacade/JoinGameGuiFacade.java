package guifacade;

import model.ClientRoot;
import proxy.serverproxies.GameSelectionServerProxy;
import shared.commandResults.CommandResult;
import shared.model.Game;
import shared.model.IPlayer;
import shared.model.Player;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class JoinGameGuiFacade {
    private static ClientRoot _clientRoot = ClientRoot.instance();

    public static String joinGame(int gameId) {
        GameSelectionServerProxy gssp = new GameSelectionServerProxy();
        IPlayer player = _clientRoot.getClientPlayer();

        if(player == null){

            return "Could not find player";
        }

        CommandResult commandResult = gssp.joinGame(gameId, player);

        if(commandResult.getCommandSuccess()){
            _addGame((Game) commandResult.getResult());
        }

        return commandResult.getUserMessage();
    }

    private static void _addGame(Game game){
        _clientRoot.setClientGame(game);
    }
}
