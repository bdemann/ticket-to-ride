package server.proxies;

import server.model.ServerRoot;
import server.poller.ClientCommands;
import shared.command.Command;
import shared.command.ICommand;
import shared.client.IGameLobbyClientFacade;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 * Created by bdemann on 2/12/18.
 */

public class LobbyClientFacadeProxy implements IGameLobbyClientFacade {
    @Override
    public void sendChat() {

    }

    @Override
    public void startGame(IGame game, String username) {

        for(IPlayer user : game.getPlayers()) {
            ClientCommands.addCommand(user.getUsername(), _createStartGameCommand(game, user.getUsername()));
        }
        //game.startGame();
        //TODO we need to initialize the game here I think. Or make an initialize game command?
    }

    @Override
    public void leaveGame(String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getGameId());
        for(IPlayer user : game.getPlayers()){
            ClientCommands.addCommand(user.getUsername(), _createLeaveGameCommand(username));
        }
        ServerRoot.getPlayer(username).setGameId(-1);
    }

    private ICommand _createLeaveGameCommand(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parms = {username};
        return new Command("app.client.facades.LobbyClientFacade", "leaveGame", parmTypes, parms);
    }

    private ICommand _createStartGameCommand(IGame game, String username) {
        Class<?>[] parmTypes = {IGame.class ,String.class};
        Object[] parms = {game, username};
        return new Command("app.facade.LobbyClientFacade", "startGame", parmTypes, parms);
    }
}
