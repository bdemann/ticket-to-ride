package nonrel_database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dao.IGameDAO;
import shared.comm.CommandEncoder;
import shared.model.interfaces.IGame;

/**
 * Created by paulinecausse on 4/9/18.
 */

public class GameDAO implements IGameDAO {
    private File file;
    private PrintWriter pw;
    private BufferedReader reader;
    private static GameDAO instance;
    public static GameDAO getInstance(File file) {
        if (instance == null)
            instance = new GameDAO(file);
        return instance;
    }

    private GameDAO(File file){
        try{
            this.file = file;
            this.pw = new PrintWriter(file);
            this.reader = new BufferedReader(new FileReader(file));
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean addGame(IGame game){
        try{
            //deserialize player
            String strGame = CommandEncoder.encodeDBInfo(game);
            pw.append(strGame + "\n");
            pw.flush();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<IGame> getGames(){
        String line;
        List<IGame> games = new ArrayList<>();

        try{
            while((line = reader.readLine()) != null) {
                IGame game = (IGame) CommandEncoder.decodeDBInfo(line);
                games.add(game);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return games;
    }


    @Override
    public void deleteGames(){
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
