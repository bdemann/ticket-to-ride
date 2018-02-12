package server.proxies;

import java.util.List;

import shared.Command;
import shared.client.IGameSelectionClient;
import shared.model.IGame;

/**
 * Created by bdemann on 2/12/18.
 */

public class GameSelectionClientProxy implements IGameSelectionClient {
    @Override
    public void createGame() {

    }

    @Override
    public void joinGame() {

    }

    @Override
    public List<IGame> getGames() {
        return null;
    }

    @Override
    public void updateGameList() {
        for(String username : ClientCommands.getUsers()){
            Command command = new Command("GameLobbyClientFacade", "updateGameList");
            ClientCommands.addCommand(username, command);
        }

    }
}
