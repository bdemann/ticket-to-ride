package server.facades;

import java.util.ArrayList;
import java.util.List;

import server.model.ServerRoot;
import shared.model.Game;
import shared.model.Player;
import shared.server.facades.IGameSelectionServerFacade;

/**
 * Created by Ben on 2/6/2018.
 */

public class GameSelectionServerFacade implements IGameSelectionServerFacade {
    @Override
    public void createGame(Player creator) {
        List<Player> playerList = new ArrayList<>();
        playerList.add(creator);
        ServerRoot.addGame(new Game(playerList));
    }

    @Override
    public void joinGame(Game game, Player joiner) {
        ServerRoot.getGame(game.getId()).addPlayer(joiner);
    }
}
