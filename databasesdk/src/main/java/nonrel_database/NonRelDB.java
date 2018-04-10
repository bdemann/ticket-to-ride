package nonrel_database;

import java.util.ArrayList;
import java.util.List;

import dao.IModelDAO;
import shared.command.ICommand;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;

/**
 * Created by paulinecausse on 4/9/18.
 */

public class NonRelDB implements IModelDAO {
    public void initializeDB(int commandLimit){}
    public void storeCommand(ICommand command){}
    public void isCommandLimitReached(){}
    public void executeCommandList(){}
    public void setGames(List<IGame> games){}
    public void setPlayers(List<IPlayer>players, int gameID){}
    public List<IGame> getGames(){
        List<IGame> games = new ArrayList<IGame>();
        return games;
    }
    public List<IPlayer>getPlayers(int gameID){
        List<IPlayer> players = new ArrayList<>();
        return players;
    }

}
