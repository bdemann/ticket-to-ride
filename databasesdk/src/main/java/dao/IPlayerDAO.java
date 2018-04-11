package dao;

import java.util.List;

import shared.model.interfaces.IPlayer;

/**
 * Created by bdemann on 4/9/18.
 */

public interface IPlayerDAO {
    public boolean addPlayer(IPlayer player, int gameID);
    public IPlayer getPlayer(String username);
    public List<IPlayer> getPlayers();
    public boolean updatePlayer(IPlayer player);
    public boolean deletePlayer(IPlayer player);
}

