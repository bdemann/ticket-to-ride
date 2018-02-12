package proxy.serverproxies;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.model.Game;
import shared.model.Player;
import shared.facades.IGameSelectionServerFacade;

/**
 * Created by Ben on 2/7/2018.
 */

public class GameSelectionServerProxy implements IGameSelectionServerFacade {
    @Override
    public CommandResult createGame(Player creator, int numberPlayer, int color, String gameName) {
        Class<?>[] parmTypes = {Player.class, int.class, int.class, String.class};
        Object[] parmValues = {creator, numberPlayer, color, gameName};
        return ClientCommunicator.sendCommand(new Command("server.facades.GameSelectionServerFacade", "createGame", parmTypes, parmValues));
    }

    @Override
    public CommandResult joinGame(int gameId, Player joiner) {
        Class<?>[] parmTypes = {int.class, Player.class};
        Object[] parmValues = {gameId, joiner};
        return ClientCommunicator.sendCommand(new Command("server.facades.GameSelectionServerFacade", "joinGame", parmTypes, parmValues));
    }
}
