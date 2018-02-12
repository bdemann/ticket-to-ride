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
import shared.facades.IGameSelectionServerFacade;

/**
 * Created by Ben on 2/6/2018.
 */

public class GameSelectionServerFacade implements IGameSelectionServerFacade {
    @Override
    public CommandResult createGame(Player creator, int numberPlayer) {
        Player player = ServerRoot.getPlayer(creator.getUsername());
        List<Player> playerList = new ArrayList<>();
        playerList.add(player);

        Game game = new Game(playerList, numberPlayer);
        ServerRoot.addGame(game);

        try {
            if (player.getGameId() != 0) {
                return new CreateGameCommandResult(false, "Player can only be part of one game");
            }

            System.out.println("GameID: " + game.getId());

            player.setGameId(game.getId());
        }catch (NullPointerException e){
            return new CreateGameCommandResult(false, "Player does not exist");
        }

        CreateGameCommandResult createGameCommandResult =  new CreateGameCommandResult(true, "createGameSuccessfull");
        createGameCommandResult.setResult(game);

        return createGameCommandResult;
    }

    @Override
    public CommandResult joinGame(Game game, Player joiner) {
        Game currentGame = ServerRoot.getGame(game.getId());
        if(currentGame == null){
            return new JoinGameCommandResult(false, "Could not find game");
        }
        else if(game.getNumberPlayer() >= game.getMaxNumberPlayer()){
            return new JoinGameCommandResult(false, "Cannot join. Game is full");
        }

        game.addPlayer(joiner);

        return new JoinGameCommandResult(true, ServerRoot.getCommandList());
    }

}
