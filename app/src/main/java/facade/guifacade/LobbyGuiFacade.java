package facade.guifacade;

import java.util.List;

import model.ClientRoot;
import proxies.LobbyServerProxy;
import shared.command.ICommand;
import shared.model.Game;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IGameInfo;
import shared.results.Result;
import shared.model.interfaces.IPlayer;
import shared.results.StartGameResult;

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

    public static String startGame(IGame game, String username){
        LobbyServerProxy proxy = new LobbyServerProxy();
        Result results = proxy.startGame((Game) game, username);
        return _processStartGameResults(results);
    }

    private static String _processStartGameResults(Result results) {
        if(results == null){
            return "Start Game Result is Null";
        }

        StartGameResult startGameResult = (StartGameResult) results;
        IGameInfo x = startGameResult.getGameInfo();

        if(results.getCommandSuccess()){
            List<ICommand> commands = results.getClientCommands();
            for (ICommand command: commands) {
                try {
                    command.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return results.getUserMessage();
    }

    private static String _processResults(Result results) {

        if(results == null){
            return "Leave Game Result is Null";
        }

        if(results.getCommandSuccess()){

            IPlayer player = ClientRoot.getClientPlayer();
            ClientRoot.getGame(player.getGameId()).removePlayer(player);

            //take the game from the root.
            ClientRoot.setClientGame(null);

        }

        return results.getUserMessage();
    }
}
