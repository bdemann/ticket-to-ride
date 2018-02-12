package guifacade;

import android.graphics.Color;

import java.sql.SQLOutput;

import model.ClientRoot;
import proxy.serverproxies.GameSelectionServerProxy;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.model.Game;
import shared.model.Player;

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
        String createGameResult = createGame(4, Color.GREEN);
        System.out.println("createGame: " + createGameResult + "\n");
    }

    public static String createGame(int numberPlayer, int color) {
        GameSelectionServerProxy gssp = new GameSelectionServerProxy();
        CommandResult commandResult = new CommandResult(null,null);
        Player player = _clientRoot.getClientPlayer();

        player.setColor(color);

        if(player == null){

            return "Can't create a game without registering first";
        }

        commandResult = gssp.createGame(player, numberPlayer, color);

        if(commandResult.getCommandSuccess()){
            if(commandResult.getResult() == null){

                return "Couldn't add game to ClientRoot";
            }
            _addGame((Game) commandResult.getResult());
        }

        return commandResult.getUserMessage();
    }


    private static void _addGame(Game game){
        _clientRoot.setListGames(game);

        System.out.println("Game: " + _clientRoot.getClientGame().getId() + "\n");
    }
}
