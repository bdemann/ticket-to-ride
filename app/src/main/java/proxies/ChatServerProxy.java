package proxies;

import comm.ClientCommunicator;
import shared.command.Command;
import shared.model.Chat;
import shared.results.ChatResult;
import shared.results.Result;
import shared.serverfacades.IChatServerFacade;

/**
 * Created by bdemann on 3/3/18.
 */

public class ChatServerProxy implements IChatServerFacade{
    @Override
    public ChatResult sendChat(Chat message) {
        //TODO this needs to be an async task
        Class<?>[] parmTypes = {Chat.class};
        Object[] parmValues = {message};
        return (ChatResult)ClientCommunicator.sendCommand(new Command("server.facades.LobbyServerFacade", "sendChat", parmTypes, parmValues));
    }
}
