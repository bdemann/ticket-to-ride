package server.facades;

import server.model.ServerRoot;
import server.poller.ClientCommands;
import server.poller.ClientNotifications;
import shared.model.GameEvent;
import shared.results.Result;
import shared.logging.Logger;
import shared.serverfacades.ILobbyServerFacade;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 * Created by Ben on 2/6/2018.
 */

public class LobbyServerFacade implements ILobbyServerFacade {

    @Override
    public Result startGame(IGame game, String username) {
        game = ServerRoot.getGame(game.getId());
        StartGameFacade.setUpGame(game);
        game.getGameHistory().addEvent(new GameEvent(username, "started game"));
        ClientNotifications.gameStarted(game);
        return new Result(true, ClientCommands.getCommandList(username), "Game Started");
    }

    @Override
    public Result leaveGame(String username) {
        //Find the game with this user.
        IPlayer player = ServerRoot.getPlayer(username);
        Logger.log("PLAYER GAMEID: " + player.getGameId());

        IGame game = ServerRoot.getGame(player.getGameId());
        game.removePlayer(player);
        game.getGameHistory().addEvent(new GameEvent(username, "left the game"));
        //Inform the client of the change
        ClientNotifications.playerLeftGame(username);

        return new Result(true, ClientCommands.getCommandList(username), "you done left the game");
    }
}
