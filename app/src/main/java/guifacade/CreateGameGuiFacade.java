package guifacade;

import android.graphics.Color;

import java.sql.SQLOutput;

import model.ClientRoot;
import proxy.serverproxies.GameSelectionServerProxy;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.model.Game;
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

        GameSelectionServerProxy proxy = new GameSelectionServerProxy();
        CommandResult createGameResult = proxy.createGame(_clientRoot.getClientPlayer(),numberPlayer,color,gameName);
        boolean isGameCreated = _processResults(createGameResult);

        if(isGameCreated){
            //Get the player and gameID for the player to join
            Player player = _clientRoot.getClientPlayer();
            Game game = (Game) createGameResult.getResult();
            int gameId = game.getId();

            //Join the game
            CommandResult joinResults = proxy.joinGame(gameId,player);
            return _processJoinResults(joinResults, createGameResult.getUserMessage());
        }
        else{
            return "Failed to create game";
        }
    }

    private static boolean _processResults(CommandResult results)
    {
        if(results == null){
            return false;
        }

        if(results.getCommandSuccess()){

            if(results.getResult() == null){
                return false;
            }

            //add the game to the root.
            _addGame((Game) results.getResult());
        }
        else{
            return false;
        }

        return true;
    }

    private static String _processJoinResults(CommandResult joinResults, String gameCreatedMessage){
        if(joinResults == null){
            return "Created game but failed to join it";
        }
        if(joinResults.getCommandSuccess()){
            if(joinResults.getResult() == null){
                return "Join result is null for some reason";
            }
            //game joined
            _setJoinedGame((Game) joinResults.getResult());
        }
        else{
            return "Created game but failed to join it";
        }
        return gameCreatedMessage;
    }


    private static void _addGame(Game game){
        _clientRoot.setListGames(game);
    }

    private static void _setJoinedGame(Game game){
        _clientRoot.setClientGame(game);
    }
}
