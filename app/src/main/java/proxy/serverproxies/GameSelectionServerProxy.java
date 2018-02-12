package proxy.serverproxies;

import java.util.concurrent.ExecutionException;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.commandResults.GameListCommandResult;
import shared.model.Game;
import shared.model.IPlayer;
import shared.model.Player;
import shared.facades.IGameSelectionServerFacade;
import tasks.CreateGameTask;

/**
 *
 * Created by Ben on 2/7/2018.
 */

public class GameSelectionServerProxy implements IGameSelectionServerFacade {
    @Override
<<<<<<< HEAD
    public CommandResult createGame(IPlayer creator, int numberPlayer, int color) {
        Class<?>[] parmTypes = {IPlayer.class, int.class, int.class};
        Object[] parmValues = {creator, numberPlayer, color};
        return ClientCommunicator.sendCommand(new Command("server.facades.GameSelectionServerFacade", "createGame", parmTypes, parmValues));
=======
    public CommandResult createGame(Player creator, int numberPlayer, int color, String gameName) {
        Class<?>[] parmTypes = {Player.class, int.class, int.class, String.class};
        Object[] parmValues = {creator, numberPlayer, color, gameName};
        Command createGameCommand = new Command("server.facades.GameSelectionServerFacade", "createGame", parmTypes, parmValues);

        CreateGameTask task = new CreateGameTask();
        task.execute(createGameCommand);

        CommandResult results = null;
        try {
            results = task.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return results;
>>>>>>> c3afba9fe4c386be6cdbf96940f6d54bed9db83a
    }

    @Override
    public CommandResult joinGame(int gameId, IPlayer joiner) {
        Class<?>[] parmTypes = {int.class, IPlayer.class};
        Object[] parmValues = {gameId, joiner};
        return ClientCommunicator.sendCommand(new Command("server.facades.GameSelectionServerFacade", "joinGame", parmTypes, parmValues));
    }

    @Override
    public GameListCommandResult getGamesList(String username) {
        return null;
    }
}
