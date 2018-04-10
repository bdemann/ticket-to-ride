package nonrel_database;

import java.util.ArrayList;
import java.util.List;

import dao.IGameDAO;
import shared.model.Game;
import shared.model.Player;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;

/**
 * Created by paulinecausse on 4/9/18.
 */

public class GameDAO implements IGameDAO {
    public boolean addGame(IGame game){return false;}
    public boolean addPlayersToGame(List<IPlayer> players, int gameId){return false;}
    public boolean updateGame(IGame game){return false;}

    public IGame getGame(int gameId){
        List players = new ArrayList();
        Player player = new Player("username", "password");
        players.add(player);
        return new Game("game!", players,1);
    }
    public boolean deleteGame(IGame game){return false;}
}
