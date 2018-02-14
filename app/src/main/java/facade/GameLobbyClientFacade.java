package facade;

import model.ClientRoot;
import shared.client.IGameLobbyClient;
import shared.model.IPlayer;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class GameLobbyClientFacade implements IGameLobbyClient {
    @Override
    public void sendChat() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public void leaveGame(String username) {
        IPlayer player = ClientRoot.instance().getClientGame().getPlayer(username);
        ClientRoot.instance().getClientGame().removePlayer(player);
    }
}
