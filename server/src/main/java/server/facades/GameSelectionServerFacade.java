package server.facades;

import java.util.ArrayList;
import java.util.List;

import server.model.ServerRoot;
import server.proxies.ClientCommands;
import server.proxies.GameSelectionClientProxy;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.commandResults.CreateGameCommandResult;
import shared.commandResults.GameListCommandResult;
import shared.commandResults.JoinGameCommandResult;
import shared.model.Game;
import shared.model.IGame;
import shared.model.IPlayer;
import shared.facades.IGameSelectionServerFacade;

/**
 * Created by Ben on 2/6/2018.
 */

public class GameSelectionServerFacade implements IGameSelectionServerFacade {
    @Override
    public CommandResult createGame(IPlayer creator, int numberPlayer, int color, String gameName) {
        IPlayer player = ServerRoot.getPlayer(creator.getUsername());

        player.setColor(color);

        List<IPlayer> playerList = new ArrayList<>();
        playerList.add(player);

        IGame game = new Game(playerList, numberPlayer);
        ServerRoot.addGame(game);
        ServerRoot.getGame(game.getId()).setGameName(gameName);

        //System.out.println("PLAYER ID: " + player.getGameId()) ;

        try {
<<<<<<< HEAD
            if (player.getGameId() != 0) {
                return new CreateGameCommandResult(false, ClientCommands.getCommandList(creator.getUsername()),"Player can only be part of one game");
            }
=======
//            if (player.getGameId() != 0) {
//                return new CreateGameCommandResult(false, "Player can only be part of one game");
//            }
>>>>>>> c3afba9fe4c386be6cdbf96940f6d54bed9db83a

            //System.out.println("GameID: " + game.getId());

            player.setGameId(game.getId());
        } catch (NullPointerException e) {
            return new CreateGameCommandResult(false, ClientCommands.getCommandList(creator.getUsername()),"Player does not exist");
        }

        CreateGameCommandResult createGameCommandResult = new CreateGameCommandResult(true, ClientCommands.getCommandList(creator.getUsername()), "createGameSuccessfull");
        createGameCommandResult.setResult(game);

        //System.out.println("GAME: " + ((Game) createGameCommandResult.getResult()).getId());

        _createGameCommand(game);

        new GameSelectionClientProxy().updateGameList();

        return createGameCommandResult;
        //TODO I think I have a different idea of what we need to be passing into these results... Lets talk about it. What is the message? Why don't we pass in this list of commands?
        // return new CreateGameCommandResult(true, ServerRoot.getCommandList(creator.getUsername()));
    }

    @Override
    public CommandResult joinGame(int gameId, IPlayer joiner) {

        IGame currentGame = ServerRoot.getGame(gameId);
        if(currentGame == null){
            return new JoinGameCommandResult(false, ClientCommands.getCommandList(joiner.getUsername()),"Could not find game");
        }
        else if(currentGame.getNumberPlayer() >= currentGame.getMaxNumberPlayer()){
            return new JoinGameCommandResult(false, ClientCommands.getCommandList(joiner.getUsername()),"Cannot join. Game is full");
        }

        ServerRoot.getGame(currentGame.getId()).addPlayer(joiner);

        CreateGameCommandResult createGameCommandResult =  new CreateGameCommandResult(true, "createGameSuccessfull");
        createGameCommandResult.setResult(ServerRoot.getGame(currentGame.getId()));

        _createJoinCommand(joiner, currentGame);

<<<<<<< HEAD
        return new JoinGameCommandResult(true, ClientCommands.getCommandList(joiner.getUsername()));
    }

    @Override
    public GameListCommandResult getGamesList(String username) {
        return new GameListCommandResult(true, ServerRoot.getGames(), ClientCommands.getCommandList(username));
=======
        return new JoinGameCommandResult(true, "join successful");
>>>>>>> c3afba9fe4c386be6cdbf96940f6d54bed9db83a
    }

    private void _createJoinCommand(IPlayer player, IGame game){
        Class<?>[] parmTypes = {IPlayer.class,IGame.class};
        Object[] parm = {player,game};

        Command command = new Command("app.facade.GameSelectionClientFacade", "joinGame", parmTypes, parm);
    }

    private void _createGameCommand(IGame game){
        Class<?>[] parmTypes = {IGame.class};
        IGame[] parm = {game};

        Command command = new Command("app.facade.GameSelectionClientFacade", "createGame", parmTypes, parm);

    }

}
