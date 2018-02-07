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
        String[] parmTypes = {Chat.class.toString()};
        Object[] parmValues = {message};
        //TODO it still feels weird that any code in the client module would need to know so specifcally about the location of the LobbyServerFacade... even if its the Lobby Server Proxy. Am I doing this right?
        return ClientCommunicator.sendCommand(new Command("server.facades.LobbyServerFacade", "sendChat", parmTypes, parmValues));
    }

    @Override
    public CommandResult startGame(Game game) {
        String[] parmTypes = {Game.class.toString()};
        Object[] parmValues = {game};
        return ClientCommunicator.sendCommand(new Command("server.facades.LobbyServerFacade", "startGame", parmTypes, parmValues));
    }
}
