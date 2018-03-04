package proxies;

import java.util.concurrent.ExecutionException;

import comm.ClientCommunicator;
import shared.command.Command;
import shared.command.ICommand;
import shared.logging.Logger;
import shared.model.Chat;
import shared.results.Result;
import shared.serverfacades.IChatServerFacade;
import tasks.CommandTask;

/**
 * Created by bdemann on 3/3/18.
 */

public class ChatServerProxy implements IChatServerFacade{
    @Override
    public Result sendChat(Chat message) {
        Class<?>[] parmTypes = {Chat.class};
        Object[] parmValues = {message};
        ICommand sendChatCommand = new Command("server.facades.LobbyServerFacade", "sendChat", parmTypes, parmValues);

        CommandTask task = new CommandTask();
        task.execute(sendChatCommand);

        Result result = null;
        try {
            result = task.get();
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return result;
    }
}
