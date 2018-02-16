package server.proxies;

import server.Server;
import server.model.ServerRoot;
import shared.Command;
import shared.ICommand;
import shared.client.IGameLobbyClient;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 * Created by bdemann on 2/12/18.
 */

public class LobbyClientProxy implements IGameLobbyClient {
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
