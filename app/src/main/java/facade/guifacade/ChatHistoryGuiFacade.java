package facade.guifacade;

import java.util.List;

import model.ClientRoot;
import proxies.ChatServerProxy;
import shared.model.Chat;
import shared.model.GameInfo;
import shared.model.history.GameHistory;
import shared.model.history.events.GameEvent;
import shared.results.ChatResult;

/**
 * Created by paulinecausse on 3/8/18.
 */

public class ChatHistoryGuiFacade {
    public static List<GameEvent> getEvents(){
        return ClientRoot.getClientGameInfo().getGameHistory().getEvents();
    }

    public static List<Chat> getChats() {
        System.out.println("Before chat");
        for(Chat chat: ClientRoot.getChats()){
            System.out.println("CHAT: " + chat);
        }
        return ClientRoot.getChats();
    }

    public static void sendChat(String message){
        ChatServerProxy chatServerProxy = new ChatServerProxy();
        ChatResult chatResult = chatServerProxy.sendChat(new Chat(ClientRoot.getClientPlayer(), message, System.currentTimeMillis()));
        System.out.println("Chat result: " + chatResult);

        System.out.println("Message: " + message);
        ClientRoot.addChatMessage(chatResult.getMessage());
        System.out.println("Before chat2");
        for(Chat chat: ClientRoot.getChats()){
            System.out.println("CHAT: " + chat);
        }
    }

    //TODO: add chat and events
}
