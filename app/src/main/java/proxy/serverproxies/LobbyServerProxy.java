package proxy.serverproxies;

import java.util.concurrent.ExecutionException;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.model.Chat;
import shared.model.Game;
import shared.facades.ILobbyServerFacade;
import tasks.JoinGameTask;
import tasks.LeaveGameTask;

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
        Class<?>[] parmTypes = {Game.class};
        Object[] parmValues = {game};
        return ClientCommunicator.sendCommand(new Command("server.facades.LobbyServerFacade", "startGame", parmTypes, parmValues));
    }

    @Override
    public CommandResult leaveGame(String username) {
        Class<?>[] parmTypes = {Game.class};
        Object[] parmValues = {username};
        Command leaveCommand = new Command("server.facades.LobbyServerFacade", "leaveGame", parmTypes, parmValues);

        LeaveGameTask leaveGameTask = new LeaveGameTask();
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
