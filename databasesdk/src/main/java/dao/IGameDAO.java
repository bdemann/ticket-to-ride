package dao;

import java.util.List;

import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;

/**
 * Created by bdemann on 4/9/18.
 */

public interface IGameDAO {
    public boolean addGame(IGame game);
    public boolean addPlayersToGame(List<IPlayer> players, int gameId);
    public boolean updateGame(IGame game);
    public IGame getGame(int gameId);
    public boolean deleteGame(IGame game);
}
