package nonrel_database;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.IPlayerDAO;
import shared.model.Player;
import shared.model.interfaces.IPlayer;

/**
 * Created by paulinecausse on 4/9/18.
 */

public class PlayerDAO implements IPlayerDAO {
    private File file;
    private static PlayerDAO instance;
    public static PlayerDAO getInstance(File file) {
        if (instance == null)
            instance = new PlayerDAO(file);
        return instance;
    }

    private PlayerDAO(File file){
        this.file = file;
    }

    public boolean addPlayer(IPlayer player, int gameID){return false;}

    public IPlayer getPlayer(String username){return new Player("username");}

    public List<IPlayer> getPlayers(){
        return new ArrayList<>();
    }

    public boolean updatePlayer(IPlayer player){return false;}

    public boolean deletePlayer(IPlayer player){return false;}
}
