package facade;

import model.ClientRoot;
import shared.client.IGameSelectionClient;
import shared.model.Game;
import shared.model.Player;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class GameSelectionClientFacade{
    private static ClientRoot _clientRoot = ClientRoot.instance();

    public void createGame(Game game) {
        _clientRoot.setListGames(game);

    }

    public void joinedGame(Player player, Game game) {
        _clientRoot.getListGames().get(game.getId()).addPlayer(player);

        if(_clientRoot.getClientGame() != null){
            if(game.getId() == _clientRoot.getClientGame().getId()){
                _clientRoot.getClientGame().addPlayer(player);
            }
        }
    }
}
