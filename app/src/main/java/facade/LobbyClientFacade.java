package facade;

import model.ClientRoot;
import shared.client.IGameLobbyClientFacade;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class LobbyClientFacade implements IGameLobbyClientFacade {
    @Override
    public void sendChat() {

    }

    @Override
    public void startGame(IGame game) {
        //Set the initialized game.
        ClientRoot.setClientGame(game);
    }

    @Override
    public void leaveGame(String username) {
        IPlayer player = ClientRoot.instance().getClientGame().getPlayer(username);
        ClientRoot.instance().getClientGame().removePlayer(player);
    }
}
