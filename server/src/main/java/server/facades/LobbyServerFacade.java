package server.facades;

import server.model.ServerRoot;
import shared.model.Chat;
import shared.model.Game;
import shared.server.facades.ILobbyServerFacade;

/**
 * Created by Ben on 2/6/2018.
 */

public class LobbyServerFacade implements ILobbyServerFacade {
    @Override
    public void sendChat(Chat message) {
        Game currentGame = ServerRoot.getGame(message.getSpeaker().getCurrentGame());
        ServerRoot.addChat(currentGame, message);
    }

    @Override
    public void startGame(Game game) {
        //TODO What exactly should happen when we start a game?
    }
}
