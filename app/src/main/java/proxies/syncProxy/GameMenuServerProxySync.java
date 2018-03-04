package proxies.syncProxy;

import comm.ClientCommunicator;
import shared.command.Command;
import shared.results.Result;
import shared.facades.server.IGameMenuServerFacade;
import shared.model.interfaces.IPlayer;

/**
 *
 * Created by Ben on 2/7/2018.
 */

public class GameMenuServerProxySync implements IGameMenuServerFacade {
    @Override
    public Result createGame(IPlayer creator, int numberPlayer, String gameName) {
        Class<?>[] parmTypes = {IPlayer.class, int.class, String.class};
        Object[] parmValues = {creator, numberPlayer, gameName};
        Command createGameCommand = new Command("server.facades.GameMenuServerFacade", "createGame", parmTypes, parmValues);
        return ClientCommunicator.sendCommand(createGameCommand);
    }

    @Override
    public Result joinGame(int gameId, IPlayer joiner) {
        Class<?>[] parmTypes = {int.class, IPlayer.class};
        Object[] parmValues = {gameId, joiner};
        Command joinGameCommand = new Command("server.facades.GameMenuServerFacade", "joinGame", parmTypes, parmValues);
        return ClientCommunicator.sendCommand(joinGameCommand);
    }

    @Override
    public Result getGamesList(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        Command getGamesCommand = new Command("server.facades.GameMenuServerFacade", "getGamesList", parmTypes, parmValues);
        return ClientCommunicator.sendCommand(getGamesCommand);
    }
}
