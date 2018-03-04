package proxies;

import java.util.concurrent.ExecutionException;

import shared.command.Command;
import shared.command.ICommand;
import shared.results.Result;
import shared.logging.Logger;
import shared.model.IPlayer;
import shared.serverfacades.IGameMenuServerFacade;
import tasks.CommandTask;

/**
 *
 * Created by Ben on 2/7/2018.
 */

public class GameMenuServerProxy implements IGameMenuServerFacade {
    @Override
    public Result createGame(IPlayer creator, int numberPlayer, String gameName) {
        Class<?>[] parmTypes = {IPlayer.class, int.class, String.class};
        Object[] parmValues = {creator, numberPlayer, gameName};
        ICommand createGameCommand = new Command("server.facades.GameMenuServerFacade", "createGame", parmTypes, parmValues);

        CommandTask task = new CommandTask();
        task.execute(createGameCommand);

        Result results = null;
        try {
            results = task.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public Result joinGame(int gameId, IPlayer joiner) {
        Class<?>[] parmTypes = {int.class, IPlayer.class};
        Object[] parmValues = {gameId, joiner};

        ICommand joinGameCommand = new Command("server.facades.GameMenuServerFacade", "joinGame", parmTypes, parmValues);

        CommandTask joinTask = new CommandTask();
        joinTask.execute(joinGameCommand);

        Result results = null;
        try {
            results = joinTask.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public Result getGamesList(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        ICommand getGamesCommand = new Command("server.facades.GameMenuServerFacade", "getGamesList", parmTypes, parmValues);


        CommandTask loginTask = new CommandTask();
        loginTask.execute(getGamesCommand);

        Result results = null;
        try {
            results = loginTask.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return results;
    }
}
