package server.proxies;

import server.model.ServerRoot;
import server.poller.ClientCommands;
import shared.command.Command;
import shared.command.ICommand;
import shared.client.IGameLobbyClientFacade;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 * Created by bdemann on 2/12/18.
 */

public class LobbyClientFacadeProxy implements IGameLobbyClientFacade {
    @Override
    public void sendChat() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public void leaveGame(String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getGameId());
        for(IPlayer user : game.getPlayers()){
            ClientCommands.addCommand(user.getUsername(), _createLeaveGameCommand(username));
        }
        ServerRoot.getPlayer(username).setGameId(-1);
    }

    private ICommand _createLeaveGameCommand(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parms = {username};
        return new Command("app.client.facades.LobbyClientFacade", "leaveGame", parmTypes, parms);
    }
}
