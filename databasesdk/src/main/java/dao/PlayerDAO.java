package dao;

import shared.model.interfaces.IPlayer;

/**
 * Created by bdemann on 4/9/18.
 */

public interface PlayerDAO {
    public boolean addPlayer(IPlayer player, int gameID);
    public IPlayer getPlayer(String username);
    public boolean updatePlayer(IPlayer player);
    public boolean deletePlayer(IPlayer player);
}
