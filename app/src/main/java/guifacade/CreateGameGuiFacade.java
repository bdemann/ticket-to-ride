package guifacade;

import java.sql.SQLOutput;

import model.ClientRoot;
import proxy.serverproxies.GameSelectionServerProxy;
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
        Player player = _clientRoot.getClientPlayer();
        System.out.println("player: " + player.getUsername() + "\n");

        String createGameResult = createGame(4);
        System.out.println("createGame: " + createGameResult + "\n");
    }

    public static String createGame(int numberPlayer) {
        GameSelectionServerProxy gssp = new GameSelectionServerProxy();
        CommandResult commandResult = new CommandResult(null,null);
        Player player = _clientRoot.getClientPlayer();

        if(player == null){
            return "Can't create a game without registering first";
        }

        commandResult = gssp.createGame(player, numberPlayer);

        if(commandResult.getCommandSuccess()){
            if(commandResult.getResult() == null){
                return "Couldn't add game to ClientRoot";
            }
            _addGame((Game) commandResult.getResult());
        }
        else{
            if(commandResult.getExceptionType() != null){
                return "Exception of type: " + commandResult.getExceptionType() +
                        ". " + commandResult.getExceptionMessage();
            }

            return commandResult.getUserMessage();
        }

        return commandResult.getUserMessage();
    }


    private static void _addGame(Game game){
        _clientRoot.setClientGame(game);

        System.out.println("Game: " + _clientRoot.getClientGame().getId() + "\n");
    }
}
