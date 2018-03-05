package server.facades;

import server.facades.helpers.StartGameFacade;
import server.model.ServerRoot;
import server.poller.ClientCommands;
import server.poller.ClientNotifications;
import shared.logging.Level;
import shared.model.history.events.GameEvent;
import shared.results.Result;
import shared.logging.Logger;
import shared.facades.server.ILobbyServerFacade;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;
import shared.results.StartGameResult;

/**
 * Created by Ben on 2/6/2018.
 */

public class LobbyServerFacade implements ILobbyServerFacade {

    @Override
    public Result startGame(IGame game, String username) {
        game = ServerRoot.getGame(game.getId());
        StartGameFacade.setUpGame(game);
        game.getGameHistory().addEvent(new GameEvent(username, "started the game"));
        ClientNotifications.gameStarted(game);
        Logger.log(game.toString() + " started", Level.FINE);
        IPlayer player = game.getPlayer(username);
        return new StartGameResult(player, game.getGameInfo(), true, ClientCommands.getCommandList(username), "Game Started");
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
