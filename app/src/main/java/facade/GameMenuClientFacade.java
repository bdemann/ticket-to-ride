package facade;

import model.ClientRoot;
import shared.client.IGameMenuClientFacade;
import shared.model.IGame;
import shared.model.IPlayer;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class GameMenuClientFacade implements IGameMenuClientFacade {
    private static ClientRoot _clientRoot = ClientRoot.instance();

    @Override
    public void createGame(IGame game) {
        _clientRoot.addToGameList(game);
    }

    @Override
    public void joinGame(IPlayer player, IGame game) {
        _clientRoot.getListGames().get(game.getId()).addPlayer(player);

        if(_clientRoot.getClientGame() != null){
            if(game.getId() == _clientRoot.getClientGame().getId()){
                _clientRoot.getClientGame().addPlayer(player);
            }
        }
    }

    @Override
    public void updateGameList(String username) {
        //TODO we need to implement this guy
    }

    @Override
    public void updatePlayerList(String username) {

    }
}
