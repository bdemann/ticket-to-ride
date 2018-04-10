package nonrel_database;

import dao.IPlayerDAO;
import shared.model.Player;
import shared.model.interfaces.IPlayer;

/**
 * Created by paulinecausse on 4/9/18.
 */

public class PlayerDAO implements IPlayerDAO {
    public boolean addPlayer(IPlayer player, int gameID){return false;}
    public IPlayer getPlayer(String username){return new Player("username");}
    public boolean updatePlayer(IPlayer player){return false;}
    public boolean deletePlayer(IPlayer player){return false;}
}
