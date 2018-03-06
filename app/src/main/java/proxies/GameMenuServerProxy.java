package proxies;

import android.util.Log;

import java.util.concurrent.ExecutionException;

import shared.command.Command;
import shared.command.ICommand;
import shared.logging.Logger;
import shared.results.CreateGameResult;
import shared.results.Result;
import shared.model.interfaces.IPlayer;
import shared.facades.server.IGameMenuServerFacade;
import tasks.CommandTask;
import tasks.TaskExecutor;

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

        return TaskExecutor.runTask(createGameCommand);
    }

    @Override
    public Result joinGame(int gameId, IPlayer joiner) {
        Class<?>[] parmTypes = {int.class, IPlayer.class};
        Object[] parmValues = {gameId, joiner};

        ICommand joinGameCommand = new Command("server.facades.GameMenuServerFacade", "joinGame", parmTypes, parmValues);

        return TaskExecutor.runTask(joinGameCommand);
    }

    @Override
    public Result getGamesList(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        ICommand getGamesCommand = new Command("server.facades.GameMenuServerFacade", "getGamesList", parmTypes, parmValues);

        return TaskExecutor.runTask(getGamesCommand);
    }
}
