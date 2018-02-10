package server.facades;

import java.util.ArrayList;
import java.util.List;

import server.model.ServerRoot;
import shared.commandResults.CommandResult;
import shared.commandResults.CreateGameCommandResult;
import shared.commandResults.JoinGameCommandResult;
import shared.model.Game;
import shared.model.Player;
import shared.facades.IGameSelectionServerFacade;

/**
 * Created by Ben on 2/6/2018.
 */

public class GameSelectionServerFacade implements IGameSelectionServerFacade {
    @Override
    public CommandResult createGame(Player creator) {
        List<Player> playerList = new ArrayList<>();
        playerList.add(creator);
        ServerRoot.addGame(new Game(playerList));
        return new CreateGameCommandResult(true, ServerRoot.getCommandList());
    }

    @Override
    public CommandResult joinGame(Game game, Player joiner) {
        ServerRoot.getGame(game.getId()).addPlayer(joiner);
        return new JoinGameCommandResult(true, ServerRoot.getCommandList());
    }
}
