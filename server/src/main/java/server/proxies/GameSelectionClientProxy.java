package server.proxies;

import java.util.List;

import server.model.ServerRoot;
import shared.Command;
import shared.ICommand;
import shared.client.IGameSelectionClient;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 * Created by bdemann on 2/12/18.
 */

public class GameSelectionClientProxy implements IGameSelectionClient {
    @Override
    public void createGame(IGame game) {
        for(String username: ClientCommands.getUsers()) {
            ClientCommands.addCommand(username, _createGameCommand(game));
        }
    }

    @Override
    public void joinGame(IPlayer player, IGame game) {
        for(IPlayer user : game.getPlayers()){
            ClientCommands.addCommand(user.getUsername(), _createJoinCommand(player, game));
        }
    }

    @Override
    public void updateGameList(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parm = {username};
        Command command = new Command("facade.GameSelectionClientFacade", "updateGameList", parmTypes, parm);
        ClientCommands.addCommand(username, command);
    }

    @Override
    public void updatePlayerList(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parm = {username};
        Command command = new Command("facade.GameLobbyClientFacade", "updatePlayerList", parmTypes, parm);
    }

    private static ICommand _createJoinCommand(IPlayer player, IGame game){
        Class<?>[] parmTypes = {IPlayer.class,IGame.class};
        Object[] parm = {player,game};
        return new Command("facade.GameSelectionClientFacade", "joinGame", parmTypes, parm);
    }

    private static ICommand _createGameCommand(IGame game){
        Class<?>[] parmTypes = {IGame.class};
        IGame[] parm = {game};
        return new Command("facade.GameSelectionClientFacade", "createGame", parmTypes, parm);
    }
}
