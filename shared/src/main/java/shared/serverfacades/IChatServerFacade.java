package shared.serverfacades;

import shared.model.Chat;
import shared.results.Result;

/**
 * Created by bdemann on 2/28/18.
 */

public interface IChatServerFacade {

    public Result sendChat(Chat message);

}
