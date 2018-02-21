package server.facades;

import server.model.ServerRoot;
import server.poller.ClientCommands;
import server.poller.ClientNotifications;
import server.proxies.LobbyClientFacadeProxy;
import shared.results.ChatResult;
import shared.results.Result;
import shared.logging.Logger;
import shared.model.Chat;
import shared.model.Game;
import shared.facades.ILobbyServerFacade;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 * Created by Ben on 2/6/2018.
 */

public class LobbyServerFacade implements ILobbyServerFacade {
    @Override
    public Result sendChat(Chat message) {
        IGame currentGame = ServerRoot.getGame(message.getSpeaker().getCurrentGame());
        ServerRoot.addChat(currentGame, message);
        ClientNotifications.messageSent(message, currentGame);
        return new ChatResult(message, true, ClientCommands.getCommandList(message.getSpeaker().getUsername()), "Chat sent");
    }

    @Override
    public Result startGame(Game game, String username) {
        //TODO What exactly should happen when we start a game?
        ClientNotifications.gameStarted(game);
        return new Result(true, ClientCommands.getCommandList(username), "Game Started");
    }

    @Override
    public Result leaveGame(String username) {
        //Find the game with this user.
        IPlayer player = ServerRoot.getPlayer(username);
        Logger.log("PLAYER GAMEID: " + player.getGameId());

        ServerRoot.getGame(player.getGameId()).removePlayer(player);
        //Inform the client of the change
        ClientNotifications.playerLeftGame(username);

        return new Result(true, ClientCommands.getCommandList(username), "you done left the game");
    }
}
