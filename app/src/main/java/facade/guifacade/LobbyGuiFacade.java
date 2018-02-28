package facade.guifacade;

import model.ClientRoot;
import proxies.LobbyServerProxy;
import shared.model.Game;
import shared.model.IGame;
import shared.results.Result;
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
        Result results = proxy.leaveGame(username);
        return _processResults(results);
    }

    public static void startGame(IGame game, String username){
        LobbyServerProxy proxy = new LobbyServerProxy();
        Result results = proxy.startGame((Game) game, username);

    }

    private static String _processResults(Result results) {

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
