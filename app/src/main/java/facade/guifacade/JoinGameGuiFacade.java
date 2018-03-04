package facade.guifacade;

import model.ClientRoot;
import proxies.GameMenuServerProxy;
import shared.results.JoinGameResult;
import shared.facades.server.IGameMenuServerFacade;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;
import shared.results.Result;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class JoinGameGuiFacade {
    private static ClientRoot _clientRoot = ClientRoot.instance();

    public static String joinGame(int gameId) {
        IGameMenuServerFacade menuServerFacade = new GameMenuServerProxy();
        IPlayer player = _clientRoot.getClientPlayer();

        if(player == null){

            return "Could not find player";
        }

        Result commandResult = (Result) menuServerFacade.joinGame(gameId, player);

        if(commandResult.getCommandSuccess()){
            JoinGameResult joinGameResult = (JoinGameResult) commandResult;
            _addGame(joinGameResult.getGame());
            _addPlayer(joinGameResult.getGame(), player);
            _setPlayersGameId(joinGameResult.getGame());
        }

        return commandResult.getUserMessage();
    }


    private static void _addPlayer(IGame game, IPlayer player){
        _clientRoot.getGame(game.getId()).addPlayer(player);
    }

    private static void _setPlayersGameId(IGame game){
        _clientRoot.getClientPlayer().setGameId(game.getId());
    }


    private static void _addGame(IGame game){
        _clientRoot.setClientGame(game);
    }
}
