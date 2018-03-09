package facade.guifacade;

import java.util.List;

import model.ClientRoot;
import proxies.ChatServerProxy;
import shared.model.Chat;
import shared.model.GameInfo;
import shared.model.history.GameHistory;
import shared.model.history.events.GameEvent;

/**
 * Created by paulinecausse on 3/8/18.
 */

public class ChatHistoryGuiFacade {
    public static List<GameEvent> getEvents(){
        return ClientRoot.getClientGameInfo().getGameHistory().getEvents();
    }

    public static List<Chat> getChats() {
        return ClientRoot.getChats();
    }

    public static void sendChat(String message){
        ChatServerProxy chatServerProxy = new ChatServerProxy();
        chatServerProxy.sendChat(new Chat(ClientRoot.getClientPlayer(), message, System.currentTimeMillis()));
    }

    //TODO: add chat and events
}
