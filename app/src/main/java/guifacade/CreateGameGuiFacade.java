package guifacade;

import android.graphics.Color;

import java.sql.SQLOutput;

import model.ClientRoot;
import proxy.serverproxies.GameSelectionServerProxy;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.model.Game;
import shared.model.IPlayer;
import shared.model.Player;
import tasks.CreateGameTask;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class CreateGameGuiFacade {
    private static ClientRoot _clientRoot = ClientRoot.instance();

    public static void main(String[] args){
        LoginGuiFacade loginGuiFacade = new LoginGuiFacade();
        String registerResult = loginGuiFacade.register("username", "password");
        System.out.println("registerResult: " + registerResult + "\n");
        String createGameResult = createGame(4, Color.GREEN, "");
        System.out.println("createGame: " + createGameResult + "\n");
    }

    public static String createGame(int numberPlayer, int color, String gameName) {
        IPlayer player = _clientRoot.getClientPlayer();
        player.setColor(color);
        GameSelectionServerProxy proxy = new GameSelectionServerProxy();
        CommandResult commandResult = proxy.createGame(player,numberPlayer,gameName);
        return _processResults(commandResult);
    }

    private static String _processResults(CommandResult results)
    {
        if(results == null){
            return "Server couldn't create the game";
        }

        if(results.getCommandSuccess()){
            if(results.getResult() == null){

                return "Couldn't add game to ClientRoot";
            }

            //add the game to the root.
            _addGame((Game) results.getResult());
        }

        return results.getUserMessage();
    }

    private static void _addGame(Game game){
        _clientRoot.setListGames(game);
    }
}
