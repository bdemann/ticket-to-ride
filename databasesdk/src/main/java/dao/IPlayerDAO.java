package dao;

import java.util.List;

import shared.model.interfaces.IPlayer;

/**
 * Created by bdemann on 4/9/18.
 */

public interface IPlayerDAO {
    public boolean addPlayer(IPlayer player, int gameID);
    public List<IPlayer> getPlayers();
    public void deletePlayers();
}

