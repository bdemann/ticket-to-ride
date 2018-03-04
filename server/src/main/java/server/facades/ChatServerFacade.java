package server.facades;

import server.model.ServerRoot;
import server.poller.ClientCommands;
import server.poller.ClientNotifications;
import shared.model.Chat;
import shared.model.IGame;
import shared.results.ChatResult;
import shared.facades.server.IChatServerFacade;

/**
 * Created by bdemann on 3/3/18.
 */

public class ChatServerFacade implements IChatServerFacade {
    @Override
    public ChatResult sendChat(Chat message) {
        IGame currentGame = ServerRoot.getGame(message.getSpeaker().getCurrentGame());
        ServerRoot.addChat(currentGame, message);
        ClientNotifications.messageSent(message, currentGame);
        return new ChatResult(message, true, ClientCommands.getCommandList(message.getSpeaker().getUsername()), "Chat sent");
    }
}
