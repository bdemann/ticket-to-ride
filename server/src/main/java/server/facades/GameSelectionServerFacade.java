package server.facades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import server.model.ServerRoot;
import shared.commandResults.CommandResult;
import shared.commandResults.CreateGameCommandResult;
import shared.commandResults.JoinGameCommandResult;
import shared.model.Game;
import shared.model.Player;
import shared.server.facades.IGameSelectionServerFacade;

/**
 * Created by Ben on 2/6/2018.
 */

public class GameSelectionServerFacade implements IGameSelectionServerFacade {
    @Override
    public CommandResult createGame(Player creator, int numberPlayer) {
        System.out.println("in createGame!!");
        Random rand = new Random();
        int  id = rand.nextInt(500) + 1;

        Player player = ServerRoot.getPlayer(creator.getUsername());
        if(player.getGameId() != 0){
            return new CreateGameCommandResult(false, "Player can only be part of one game");
        }
        player.setGameId(id);

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);

        Game game = new Game(playerList,id,numberPlayer);
        ServerRoot.addGame(game);
        CreateGameCommandResult createGameCommandResult =  new CreateGameCommandResult(true, "createGameSuccessfull");
        createGameCommandResult.setResult(game);

        return createGameCommandResult;
    }

    @Override
    public CommandResult joinGame(Game game, Player joiner) {
        ServerRoot.getGame(game.getId()).addPlayer(joiner);
        return new JoinGameCommandResult(true, ServerRoot.getCommandList());
    }

}
