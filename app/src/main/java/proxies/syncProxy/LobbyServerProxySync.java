package proxies.syncProxy;

import comm.ClientCommunicator;
import shared.command.Command;
import shared.results.Result;
import shared.serverfacades.ILobbyServerFacade;
import shared.logging.Logger;
import shared.model.Chat;
import shared.model.Game;

/**
 * Created by Ben on 2/7/2018.
 *
 */

public class LobbyServerProxySync implements ILobbyServerFacade {

    @Override
    public Result startGame(Game game, String username) {
        Logger.log("We are starting the game.");
        Class<?>[] parmTypes = {Game.class};
        Object[] parmValues = {game};
        return ClientCommunicator.sendCommand(new Command("server.facades.LobbyServerFacade", "startGame", parmTypes, parmValues));
    }

    @Override
    public Result leaveGame(String username) {
        Logger.log("We are leaving the game");
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        Command leaveCommand = new Command("server.facades.LobbyServerFacade", "leaveGame", parmTypes, parmValues);
        Logger.log("This is the leave command: " + leaveCommand);
        return ClientCommunicator.sendCommand(leaveCommand);
    }
}
