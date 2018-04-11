package dao;

import java.util.List;

import shared.command.ICommand;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;

/**
 * Created by bdemann on 4/9/18.
 */

public interface IModelDAO {
    public void initializeDB(int commandLimit);
    public void storeCommand(ICommand command);
    public boolean isCommandLimitReached();
    public void executeCommandList();
    public void setGames(List<IGame>games);
    public void setPlayers(List<IPlayer>players, int gameID);
    public List<IGame> getGames();
    public List<IPlayer>getPlayers(int gameID);

    void clearCommands();

    void saveGame();
}
