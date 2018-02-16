package guifacade;

import java.util.concurrent.ConcurrentLinkedDeque;

import model.ClientRoot;
import proxy.serverproxies.LobbyServerProxy;
import shared.commandResults.CommandResult;
import shared.model.IPlayer;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class LobbyGuiFacade {

    public static void sendChat() {

    }

    public static String leaveGame(String username){
        LobbyServerProxy proxy = new LobbyServerProxy();
        CommandResult results = proxy.leaveGame(username);
        return _processResults(results);
    }

    private static String _processResults(CommandResult results) {

        if(results == null){
            return "Leave Game Result is Null";
        }

        if(results.getCommandSuccess()){

            IPlayer player = ClientRoot.instance().getClientPlayer();
            ClientRoot.instance().getGame(player.getGameId()).removePlayer(player);

            //take the game from the root.
            ClientRoot.instance().setClientGame(null);

        }

        return results.getUserMessage();
    }
}
