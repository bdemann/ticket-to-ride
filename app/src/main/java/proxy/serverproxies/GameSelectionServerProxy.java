package proxy.serverproxies;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.commandResults.GameListCommandResult;
import shared.model.Game;
import shared.model.IPlayer;
import shared.model.Player;
import shared.facades.IGameSelectionServerFacade;

/**
 * Created by Ben on 2/7/2018.
 */

public class GameSelectionServerProxy implements IGameSelectionServerFacade {
    @Override
    public CommandResult createGame(IPlayer creator, int numberPlayer, int color) {
        Class<?>[] parmTypes = {IPlayer.class, int.class, int.class};
        Object[] parmValues = {creator, numberPlayer, color};
        return ClientCommunicator.sendCommand(new Command("server.facades.GameSelectionServerFacade", "createGame", parmTypes, parmValues));
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
