package server.proxies;

import java.util.List;

import shared.Command;
import shared.client.IGameSelectionClient;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 * Created by bdemann on 2/12/18.
 */

public class GameSelectionClientProxy implements IGameSelectionClient {
    @Override
    public void createGame(IGame game) {

    }

    @Override
    public void joinGame(IPlayer player, IGame game) {

    }

    @Override
    public void updateGameList() {
        for(String username : ClientCommands.getUsers()){
            Command command = new Command("facade.GameLobbyClientFacade", "updateGameList");
            ClientCommands.addCommand(username, command);
        }
    }
}
