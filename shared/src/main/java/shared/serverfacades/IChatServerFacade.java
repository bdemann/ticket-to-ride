package shared.serverfacades;

import shared.model.Chat;
import shared.results.ChatResult;

/**
 * Created by bdemann on 2/28/18.
 */

public interface IChatServerFacade {

    public ChatResult sendChat(Chat message);

}
