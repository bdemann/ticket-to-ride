package proxies;

import java.util.concurrent.ExecutionException;

import shared.command.Command;
import shared.command.ICommand;
import shared.model.Chat;
import shared.results.Result;
import shared.facades.server.IChatServerFacade;
import tasks.CommandTask;
import tasks.TaskExecutor;

/**
 * Created by bdemann on 3/3/18.
 */

public class ChatServerProxy implements IChatServerFacade{
    @Override
    public Result sendChat(Chat message) {
        Class<?>[] parmTypes = {Chat.class};
        Object[] parmValues = {message};
        ICommand sendChatCommand = new Command("server.facades.LobbyServerFacade", "sendChat", parmTypes, parmValues);

        return TaskExecutor.runTask(sendChatCommand);
    }
}
