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
    public CommandResult createGame(Player creator) {
        Class<?>[] parmTypes = {Player.class};
        Object[] parmValues = {creator};
        return ClientCommunicator.sendCommand(new Command("server.facades.GameSelectionServerFacade", "createGame", parmTypes, parmValues));
    }

    @Override
    public CommandResult joinGame(Game game, Player joiner) {
        Class<?>[] parmTypes = {Game.class, Player.class};
        Object[] parmValues = {game, joiner};
        return ClientCommunicator.sendCommand(new Command("server.facades.GameSelectionServerFacade", "joinGame", parmTypes, parmValues));
    }
}
