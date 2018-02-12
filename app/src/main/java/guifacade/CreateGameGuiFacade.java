package guifacade;

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
        CommandResult createGameResult = createGame(4);
        System.out.println("createGame: " + createGameResult.getUserMessage() + "\n");
        Game game = (Game) createGameResult.getResult();
        System.out.println("Game id: " + game.getId());
    }

    public static CommandResult createGame(int numberPlayer) {
        GameSelectionServerProxy gssp = new GameSelectionServerProxy();
        CommandResult commandResult = new CommandResult(null,null);
        Player player = _clientRoot.getClientPlayer();

        if(player == null){
            commandResult.setUserMessage("Can't create a game without registering first");
            return commandResult;
        }

        commandResult = gssp.createGame(player, numberPlayer);

        if(commandResult.getCommandSuccess()){
            if(commandResult.getResult() == null){
                commandResult.setUserMessage("Couldn't add game to ClientRoot");
                return commandResult;
            }
            _addGame((Game) commandResult.getResult());
            CommandResult joinResult = JoinGameGuiFacade.joinGame((Game) commandResult.getResult());
            if(!joinResult.getCommandSuccess()){
                commandResult.setUserMessage(joinResult.getUserMessage());
            }
        }

        return commandResult;
    }


    private static void _addGame(Game game){
        _clientRoot.setListGames(game);

        System.out.println("Game: " + _clientRoot.getClientGame().getId() + "\n");
    }
}
