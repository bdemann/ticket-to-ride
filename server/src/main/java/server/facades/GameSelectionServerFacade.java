package server.facades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import server.model.ServerRoot;
import shared.Command;
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
    public CommandResult createGame(Player creator, int numberPlayer, int color, String gameName) {
        Player player = ServerRoot.getPlayer(creator.getUsername());

        player.setColor(color);

        List<Player> playerList = new ArrayList<>();
        playerList.add(player);

        Game game = new Game(playerList, numberPlayer);
        ServerRoot.addGame(game);
        ServerRoot.getGame(game.getId()).setGameName(gameName);

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

        _createGameCommand(game);

        return createGameCommandResult;
        //TODO I think I have a different idea of what we need to be passing into these results... Lets talk about it. What is the message? Why don't we pass in this list of commands?
        // return new CreateGameCommandResult(true, ServerRoot.getCommandList(creator.getUsername()));
    }

    @Override
    public CommandResult joinGame(int gameId, Player joiner) {

        Game currentGame = ServerRoot.getGame(gameId);
        if(currentGame == null){
            return new JoinGameCommandResult(false, "Could not find game");
        }
        else if(currentGame.getNumberPlayer() >= currentGame.getMaxNumberPlayer()){
            return new JoinGameCommandResult(false, "Cannot join. Game is full");
        }

        ServerRoot.getGame(currentGame.getId()).addPlayer(joiner);

        CreateGameCommandResult createGameCommandResult =  new CreateGameCommandResult(true, "createGameSuccessfull");
        createGameCommandResult.setResult(ServerRoot.getGame(currentGame.getId()));

        _createJoinCommand(joiner, currentGame);

        return new JoinGameCommandResult(true, "join successful");
    }

    private void _createJoinCommand(Player player, Game game){
        Class<?>[] parmTypes = {Player.class,Game.class};
        Object[] parm = {player,game};

        Command command = new Command("app.facade.GameSelectionClientFacade", "joinGame", parmTypes, parm);
    }

    private void _createGameCommand(Game game){
        Class<?>[] parmTypes = {Game.class};
        Game[] parm = {game};

        Command command = new Command("app.facade.GameSelectionClientFacade", "createGame", parmTypes, parm);

    }

}
