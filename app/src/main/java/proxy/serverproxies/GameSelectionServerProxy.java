package proxy.serverproxies;

import android.util.Log;

import java.util.concurrent.ExecutionException;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.commandResults.GameListResult;
import shared.logging.Level;
import shared.logging.Logger;
import shared.model.IPlayer;
import shared.facades.IGameSelectionServerFacade;
import tasks.CreateGameTask;
import tasks.JoinGameTask;

/**
 *
 * Created by Ben on 2/7/2018.
 */

public class GameSelectionServerProxy implements IGameSelectionServerFacade {
    @Override
    public CommandResult createGame(IPlayer creator, int numberPlayer, String gameName) {
        Class<?>[] parmTypes = {IPlayer.class, int.class, String.class};
        Object[] parmValues = {creator, numberPlayer, gameName};
        Command createGameCommand = new Command("server.facades.GameSelectionServerFacade", "createGame", parmTypes, parmValues);

        CreateGameTask task = new CreateGameTask();
        task.execute(createGameCommand);

        CommandResult results = null;
        try {
            results = task.get();
            Logger.log("Here we are" + results.toString());
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public CommandResult joinGame(int gameId, IPlayer joiner) {
        Class<?>[] parmTypes = {int.class, IPlayer.class};
        Object[] parmValues = {gameId, joiner};

        Command joinGameCommand = new Command("server.facades.GameSelectionServerFacade", "joinGame", parmTypes, parmValues);

        JoinGameTask joinTask = new JoinGameTask();
        joinTask.execute(joinGameCommand);

        CommandResult results = null;
        try {
            results = joinTask.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public CommandResult getGamesList(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        CommandResult result = ClientCommunicator.sendCommand(new Command("server.facades.GameSelectionServerFacade", "getGamesList", parmTypes, parmValues));
        Logger.log("Command Result is " + result.toString(), Level.FINNEST);
        return result;
    }
}
