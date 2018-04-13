package nonrel_database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dao.IPlayerDAO;
import shared.comm.CommandEncoder;
import shared.model.interfaces.IPlayer;

/**
 * Created by paulinecausse on 4/9/18.
 */

public class PlayerDAO implements IPlayerDAO {
    private PrintWriter pw;
    private File file;
    private BufferedReader reader;

    private static PlayerDAO instance;
    public static PlayerDAO getInstance(File file) {
        if (instance == null)
            instance = new PlayerDAO(file);
        return instance;
    }

    private PlayerDAO(File file){
        try{
            this.file = file;
            pw = new PrintWriter(file);
            reader = new BufferedReader(new FileReader(file));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean addPlayer(IPlayer player, int gameID){
        try{
            //deserialize player
            String strPlayer = CommandEncoder.encodeDBInfo(player);
            pw.append(strPlayer + "\n");
            pw.flush();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public List<IPlayer> getPlayers(){
        String line;
        List<IPlayer> players = new ArrayList<>();

        try{
            while((line = reader.readLine()) != null) {
                IPlayer player = (IPlayer) CommandEncoder.decodeDBInfo(line);
                players.add(player);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return players;
    }

    public void deletePlayers(){
        try{
            pw.close();
            pw = new PrintWriter(file);
            pw.append("");
            pw.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void closeFile(){
        pw.close();
        try{
            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
