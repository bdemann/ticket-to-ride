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
    public void saveGames(List<IGame>games);
    public void savePlayers(List<IPlayer>players);
    public List<IGame> getGames();
    public void clearCommands();

    void addPlayer(IPlayer player);

    List<IPlayer> getPlayers();
    List<ICommand> getCommandList(int id);
}
