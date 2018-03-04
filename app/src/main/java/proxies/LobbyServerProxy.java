package proxies;

import java.util.concurrent.ExecutionException;

import comm.ClientCommunicator;
import shared.command.Command;
import shared.results.Result;
import shared.logging.Logger;
import shared.model.Chat;
import shared.model.Game;
import shared.facades.ILobbyServerFacade;
import tasks.CommandTask;

/**
 * Created by Ben on 2/7/2018.
 *
 */

public class LobbyServerProxy implements ILobbyServerFacade {
    @Override
    public Result sendChat(Chat message) {
        //TODO this needs to be an async task
        Class<?>[] parmTypes = {Chat.class};
        Object[] parmValues = {message};
        return ClientCommunicator.sendCommand(new Command("server.facades.LobbyServerFacade", "sendChat", parmTypes, parmValues));
    }

    @Override
    public Result startGame(Game game, String username) {

        Logger.log("We are starting the game.");
        Class<?>[] parmTypes = {Game.class, String.class};
        Object[] parmValues = {game, username};
        Command startGameCommand = new Command("server.facades.LobbyServerFacade", "startGame", parmTypes, parmValues);

        Logger.log("This is the startGame command: " + startGameCommand);

        CommandTask startGameTask = new CommandTask();
        startGameTask.execute(startGameCommand);

        Result results = null;
        try {
            results = startGameTask.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public Result leaveGame(String username) {
        Logger.log("We are leaving the game");
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        Command leaveCommand = new Command("server.facades.LobbyServerFacade", "leaveGame", parmTypes, parmValues);

        Logger.log("This is the leave command: " + leaveCommand);

        CommandTask leaveGameTask = new CommandTask();
        leaveGameTask.execute(leaveCommand);

        Result results = null;
        try {
            results = leaveGameTask.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return results;
    }
}
