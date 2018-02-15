package proxy.serverproxies;

import java.util.concurrent.ExecutionException;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.logging.Logger;
import shared.model.Chat;
import shared.model.Game;
import shared.facades.ILobbyServerFacade;
import tasks.CommandTask;

/**
 * Created by Ben on 2/7/2018.
 *
 */

public class LobbyServerProxy implements ILobbyServerFacade {
    @Override
    public CommandResult sendChat(Chat message) {
        Class<?>[] parmTypes = {Chat.class};
        Object[] parmValues = {message};
        return ClientCommunicator.sendCommand(new Command("server.facades.LobbyServerFacade", "sendChat", parmTypes, parmValues));
    }

    @Override
    public CommandResult startGame(Game game, String username) {
        Logger.log("We are starting the game.");
        Class<?>[] parmTypes = {Game.class};
        Object[] parmValues = {game};
        return ClientCommunicator.sendCommand(new Command("server.facades.LobbyServerFacade", "startGame", parmTypes, parmValues));
    }

    @Override
    public CommandResult leaveGame(String username) {
        Logger.log("We are leaving the game");
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};
        Command leaveCommand = new Command("server.facades.LobbyServerFacade", "leaveGame", parmTypes, parmValues);

        Logger.log("This is the leave command: " + leaveCommand);

        CommandTask leaveGameTask = new CommandTask();
        leaveGameTask.execute(leaveCommand);

        CommandResult results = null;
        try {
            results = leaveGameTask.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return results;
    }
}
