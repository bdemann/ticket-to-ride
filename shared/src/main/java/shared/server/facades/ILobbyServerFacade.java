package shared.server.facades;

import shared.model.Chat;
import shared.model.Game;

/**
 * Created by Ben on 2/6/2018.
 */

public interface ILobbyServerFacade {
    public void sendChat(Chat message);
    public void startGame(Game game);
}
