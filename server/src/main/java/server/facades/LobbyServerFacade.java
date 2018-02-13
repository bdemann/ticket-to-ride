package server.facades;

import server.model.ServerRoot;
import server.proxies.ClientCommands;
import shared.commandResults.ChatCommandResult;
import shared.commandResults.CommandResult;
import shared.model.Chat;
import shared.model.Game;
import shared.facades.ILobbyServerFacade;
import shared.model.IGame;

/**
 * Created by Ben on 2/6/2018.
 */

public class LobbyServerFacade implements ILobbyServerFacade {
    @Override
    public CommandResult sendChat(Chat message) {
        IGame currentGame = ServerRoot.getGame(message.getSpeaker().getCurrentGame());
        ServerRoot.addChat(currentGame, message);
        return new ChatCommandResult(true, ClientCommands.getCommandList(message.getSpeaker().getUsername()));
    }

    @Override
    public CommandResult startGame(Game game, String username) {
        //TODO What exactly should happen when we start a game?
        return new CommandResult(true, ClientCommands.getCommandList(username));
    }

    @Override
    public CommandResult leaveGame(String username) {
        return null;
    }
}
