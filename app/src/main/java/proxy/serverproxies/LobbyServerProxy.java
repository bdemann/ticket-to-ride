package proxy.serverproxies;

import proxy.ClientCommunicator;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.model.Chat;
import shared.model.Game;
import shared.model.Player;
import shared.server.facades.ILobbyServerFacade;

/**
 * Created by Ben on 2/7/2018.
 */

public class LobbyServerProxy implements ILobbyServerFacade {
    @Override
    public CommandResult sendChat(Chat message) {
        Class<?>[] parmTypes = {Chat.class};
        Object[] parmValues = {message};
        return ClientCommunicator.sendCommand(new Command("server.facades.LobbyServerFacade", "sendChat", parmTypes, parmValues));
    }

    @Override
    public CommandResult startGame(Game game) {
        Class<?>[] parmTypes = {Game.class};
        Object[] parmValues = {game};
        return ClientCommunicator.sendCommand(new Command("server.facades.LobbyServerFacade", "startGame", parmTypes, parmValues));
    }
}
