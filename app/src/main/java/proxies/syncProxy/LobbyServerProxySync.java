package proxies.syncProxy;

import comm.ClientCommunicator;
import shared.command.Command;
import shared.results.Result;
import shared.facades.server.ILobbyServerFacade;
import shared.logging.Logger;
import shared.model.interfaces.IGame;
import shared.results.StartGameResult;

/**
 * Created by Ben on 2/7/2018.
 *
 */

public class LobbyServerProxySync implements ILobbyServerFacade {

    private static final String CLASS = "server.facades.LobbyServerFacade";

    @Override
    public StartGameResult startGame(IGame game, String username) {
        Logger.log("We are starting the game.");
        Class<?>[] parmTypes = {IGame.class, String.class};
        Object[] parmValues = {game, username};

        Result result = ClientCommunicator.sendCommand(new Command(CLASS, "startGame", parmTypes, parmValues));
        if(result.getCommandSuccess()) {
            return (StartGameResult) result;
        }
        return new StartGameResult(result.getExceptionType(), result.getExceptionMessage());
    }

    @Override
    public Result leaveGame(String username) {
        Logger.log("We are leaving the game");
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        Command leaveCommand = new Command(CLASS, "leaveGame", parmTypes, parmValues);
        Logger.log("This is the leave command: " + leaveCommand);
        return ClientCommunicator.sendCommand(leaveCommand);
    }
}
