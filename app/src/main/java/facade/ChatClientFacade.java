package facade;

import shared.facades.client.IChatClientFacade;
import shared.model.Chat;

/**
 * Created by bdemann on 3/5/18.
 */

public class ChatClientFacade implements IChatClientFacade {

    @Override
    public void updateChat(Chat message){
        //TODO take this chat an put it where ever chats go in the client
    }

}
