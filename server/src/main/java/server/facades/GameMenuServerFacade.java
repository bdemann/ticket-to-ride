package server.facades;

import java.util.ArrayList;
import java.util.List;

import server.poller.ClientNotifications;
import server.model.ServerRoot;
import server.poller.ClientCommands;
import shared.results.CreateGameResult;
import shared.results.JoinGameResult;
import shared.results.Result;
import shared.results.GameListResult;
import shared.facades.IGameMenuServerFacade;
import shared.logging.Level;
import shared.logging.Logger;
import shared.model.Game;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 * Created by Ben on 2/6/2018.
 */

public class GameMenuServerFacade implements IGameMenuServerFacade {
    @Override
    public Result createGame(IPlayer creator, int maxNumberPlayer, String gameName) {
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
        IGame game = new Game(gameName, playerList, maxNumberPlayer);
        ServerRoot.addGame(game);

        Logger.log("Game: " + game);

        CreateGameResult createGameCommandResult = new CreateGameResult(game, true, ClientCommands.getCommandList(creator.getUsername()));

        ClientNotifications.gameCreated(game.getId(), player.getUsername());

        Logger.log("Game Creation Successful! Results:" + createGameCommandResult.toString(), Level.FINNEST);

        Logger.log("CommandResult: " + createGameCommandResult.getGame());

        return createGameCommandResult;
    }

    @Override
    public Result joinGame(int gameId, IPlayer joiner) {
        Logger.log("Joining game: " + gameId + "Joining player: " + joiner, Level.FINE);
        IGame currentGame = ServerRoot.getGame(gameId);
        if(currentGame == null){
            Logger.log("Couldn't find the current game", Level.ALL);
            return new JoinGameResult(currentGame, false, ClientCommands.getCommandList(joiner.getUsername()),"Could not find game");
        }
        else if(currentGame.getNumberPlayer() >= currentGame.getMaxNumberPlayer()){
            Logger.log("Already has the max number of players.", Level.ALL);
            return new JoinGameResult(currentGame, false, ClientCommands.getCommandList(joiner.getUsername()),"Cannot join. Game is full");
        }

        joiner.setGameId(currentGame.getId());

        //check color
        _assignColor(currentGame.getId(), joiner);
        //add the player if not already in
        _updatePlayerList(currentGame, joiner);

        ClientNotifications.playerJoinedGame(gameId, joiner.getUsername());

        JoinGameResult results = new JoinGameResult(ServerRoot.getGame(currentGame.getId()), true, ClientCommands.getCommandList(joiner.getUsername()),"Join successful");

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
            ServerRoot.getPlayer(joiner.getUsername()).setGameId(currentGame.getId());
        }
        else{
            ServerRoot.getGame(currentGame.getId()).getPlayer(joiner.getUsername()).setGameId(currentGame.getId());
            ServerRoot.getPlayer(joiner.getUsername()).setGameId(currentGame.getId());
        }
    }

    @Override
    public Result getGamesList(String username) {
        Logger.log("Getting the games list", Level.FINE);
        for (IGame game: ServerRoot.getGames()) {
            Logger.log("Games: " + game.toString());
        }
        Logger.log("Finished getting the game list");
        return new GameListResult(ServerRoot.getGames(), true, ClientCommands.getCommandList(username));
    }

}