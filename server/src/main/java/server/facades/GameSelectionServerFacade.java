package server.facades;

import com.sun.corba.se.spi.activation.Server;

import java.util.ArrayList;
import java.util.List;

import server.ClientNotifications;
import server.model.ServerRoot;
import server.proxies.ClientCommands;
import shared.commandResults.CommandResult;
import shared.commandResults.CreateGameCommandResult;
import shared.commandResults.GameListResult;
import shared.commandResults.JoinGameCommandResult;
import shared.facades.IGameSelectionServerFacade;
import shared.logging.Level;
import shared.logging.Logger;
import shared.model.Game;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 * Created by Ben on 2/6/2018.
 */

public class GameSelectionServerFacade implements IGameSelectionServerFacade {
    @Override
    public CommandResult createGame(IPlayer creator, int numberPlayer, String gameName) {
        Logger.log("Creating game: " + gameName + ". Creator: " + creator.toString() + " ", Level.FINE);
        IPlayer player = ServerRoot.getPlayer(creator.getUsername());

        //set color to creator
        ServerRoot.getPlayer(creator.getUsername()).setColor(creator.getColor());

        if(player == null) {
            Logger.log("player couldn't be found", Level.ALL);
        }

        //Create a list of players for the game.
        List<IPlayer> playerList = new ArrayList<>();
        playerList.add(player);

        //Add game to server
        IGame game = new Game(gameName, playerList, numberPlayer);
        ServerRoot.addGame(game);

        player.setGameId(game.getId());

        CreateGameCommandResult createGameCommandResult = new CreateGameCommandResult(true, ClientCommands.getCommandList(creator.getUsername()));
        //TODO probably not so important right now but I think that we could make the game part of the contructor for the CreateGameCommandResults class. Otherwise there is no point having it if we aren't going to take advantage of some of the things.
        //TODO we could also rename our command results. This would do two things. 1) it would make them shorter and perhaps a little easier to read. Secondly if you think about it its not really a command result at all. The server facade doesn't know that we are using the command pattern. Its just returning results and that is all it knows.
        createGameCommandResult.setResult(game);

        //System.out.println("GAME: " + ((Game) createGameCommandResult.getResult()).getId());

        ClientNotifications.gameCreated(game.getId(), player.getUsername());

        Logger.log("Game Creation Successful! Results:" + createGameCommandResult.toString(), Level.FINNEST);

        System.out.println("NUMBER OF PLAYERS!!! " + game.getPlayers().size());

        return createGameCommandResult;
        //TODO I think I have a different idea of what we need to be passing into these results... Lets talk about it. What is the message? Why don't we pass in this list of commands?
        // return new CreateGameCommandResult(true, ServerRoot.getCommandList(creator.getUsername()));
    }

    @Override
    public CommandResult joinGame(int gameId, IPlayer joiner) {
        Logger.log("Joining game: " + gameId + "Joining player: " + joiner, Level.FINE);
        IGame currentGame = ServerRoot.getGame(gameId);
        if(currentGame == null){
            Logger.log("Couldn't find the current game", Level.ALL);
            return new JoinGameCommandResult(currentGame, false, ClientCommands.getCommandList(joiner.getUsername()),"Could not find game");
        }
        else if(currentGame.getNumberPlayer() >= currentGame.getMaxNumberPlayer()){
            Logger.log("Already has the max number of players.", Level.ALL);
            return new JoinGameCommandResult(currentGame, false, ClientCommands.getCommandList(joiner.getUsername()),"Cannot join. Game is full");
        }

        joiner.setGameId(currentGame.getId());

        //check color
        _assignColor(currentGame.getId(), joiner);
        _updatePlayerList(currentGame, joiner);


        ClientNotifications.playerJoinedGame(gameId, joiner.getUsername());

        JoinGameCommandResult results = new JoinGameCommandResult(ServerRoot.getGame(currentGame.getId()), true, ClientCommands.getCommandList(joiner.getUsername()),"Join successful");

        Logger.log("Join Game successful " + results.toString());
        return results;
    }

    private void _assignColor(int gameId, IPlayer joiner){
        List<IPlayer> players = ServerRoot.getGame(gameId).getPlayers();
        for(int i = 0; i < ServerRoot.getColors().size(); i++){
            int notSame = 0;
            for(int j = 0; j < players.size(); j++){
                if(ServerRoot.getColors().get(i) != players.get(j).getColor()){
                    notSame++;
                }
            }
            if(notSame == players.size()){
                ServerRoot.getPlayer(joiner.getUsername()).setColor(ServerRoot.getColors().get(i));
                break;
            }
        }
    }

    private void _updatePlayerList(IGame currentGame, IPlayer joiner){
        boolean playerExists =  false;
        for(IPlayer player : ServerRoot.getGame(currentGame.getId()).getPlayers()){
            if(player.getUsername().equals(joiner.getUsername())){
                playerExists = true;
            }
        }
        if(!playerExists){
            ServerRoot.getGame(currentGame.getId()).addPlayer(joiner);
        }
    }

    @Override
    public CommandResult getGamesList(String username) {
        Logger.log("Getting the games list", Level.FINE);
        for (IGame game: ServerRoot.getGames()) {
            Logger.log("Games: " + game.toString());
        }
        Logger.log("Finished getting the game list");
        return new GameListResult(true, ServerRoot.getGames(), ClientCommands.getCommandList(username));
    }

}
