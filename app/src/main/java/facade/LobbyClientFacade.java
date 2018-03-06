package facade;

import model.ClientRoot;
import shared.facades.client.IGameLobbyClientFacade;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IGameInfo;
import shared.model.interfaces.IPlayer;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class LobbyClientFacade implements IGameLobbyClientFacade {
    @Override
    public void sendChat() {

    }

    @Override
    public void startGame(IGameInfo gameInfo, IPlayer player) {
        //Set the initialized gameInfo.
        ClientRoot.setClientGameInfo(gameInfo);
        ClientRoot.setClientPlayer(player);
    }

    @Override
    public void leaveGame(String username) {
        IPlayer player = ClientRoot.getClientGame().getPlayer(username);
        ClientRoot.getClientGame().removePlayer(player);
    }
}
