package server.facades;

import java.util.ArrayList;
import java.util.List;

import server.model.ServerRoot;
import server.proxies.ClientCommands;
import server.proxies.GameSelectionClientProxy;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.commandResults.CreateGameCommandResult;
import shared.commandResults.GameListResult;
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
    public CommandResult createGame(IPlayer creator, int numberPlayer, String gameName) {
        IPlayer player = ServerRoot.getPlayer(creator.getUsername());

        //Create a list of players for the game.
        List<IPlayer> playerList = new ArrayList<>();
        playerList.add(player);

        //Add game to server
        IGame game = new Game(gameName, playerList, numberPlayer);
        ServerRoot.addGame(game);

        try {
            //TODO Is this supposed to be commented out? I think that's how it was before the merge so I'm going to do that.
//            if (player.getGameId() != 0) {
//                return new CreateGameCommandResult(false, ClientCommands.getCommandList(creator.getUsername()),"Player can only be part of one game");
//            }

            //System.out.println("GameID: " + game.getId());

            player.setGameId(game.getId());
        } catch (NullPointerException e) {
            return new CreateGameCommandResult(false, ClientCommands.getCommandList(creator.getUsername()),"Player does not exist");
        }

        CreateGameCommandResult createGameCommandResult = new CreateGameCommandResult(true, ClientCommands.getCommandList(creator.getUsername()));
        //TODO probably not so important right now but I think that we could make the game part of the contructor for the CreateGameCommandResults class. Otherwise there is no point having it if we aren't going to take advantage of some of the things.
        //TODO we could also rename our command results. This would do two things. 1) it would make them shorter and perhaps a little easier to read. Secondly if you think about it its not really a command result at all. The server facade doesn't know that we are using the command pattern. Its just returning results and that is all it knows.
        createGameCommandResult.setResult(game);

        //System.out.println("GAME: " + ((Game) createGameCommandResult.getResult()).getId());

        //TODO Move this function to the client proxy.
        _createGameCommand(game);

        //Tell the clients that there is an update to the game list.
        new GameSelectionClientProxy().updateGameList();

        return createGameCommandResult;
        //TODO I think I have a different idea of what we need to be passing into these results... Lets talk about it. What is the message? Why don't we pass in this list of commands?
        // return new CreateGameCommandResult(true, ServerRoot.getCommandList(creator.getUsername()));
    }

    @Override
    public CommandResult joinGame(int gameId, IPlayer joiner) {

        IGame currentGame = ServerRoot.getGame(gameId);
        if(currentGame == null){
            return new JoinGameCommandResult(currentGame, false, ClientCommands.getCommandList(joiner.getUsername()),"Could not find game");
        }
        else if(currentGame.getNumberPlayer() >= currentGame.getMaxNumberPlayer()){
            return new JoinGameCommandResult(currentGame, false, ClientCommands.getCommandList(joiner.getUsername()),"Cannot join. Game is full");
        }

        ServerRoot.getGame(currentGame.getId()).addPlayer(joiner);

        //TODO Move this function to the client proxy.
        _createJoinCommand(joiner, currentGame);

        return new JoinGameCommandResult(ServerRoot.getGame(currentGame.getId()), true, ClientCommands.getCommandList(joiner.getUsername()));
    }

    @Override
    public CommandResult getGamesList(String username) {
        return new GameListResult(true, ServerRoot.getGames(), ClientCommands.getCommandList(username));
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
