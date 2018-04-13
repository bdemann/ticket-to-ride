package nonrel_database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dao.ICommandDAO;
import shared.comm.CommandEncoder;
import shared.command.ICommand;

/**
 * Created by paulinecausse on 4/10/18.
 */

public class CommandDAO implements ICommandDAO {
    private PrintWriter pw;
    private BufferedReader reader;
    private File file;
    private int numCommands;
    private static CommandDAO instance;
    public static CommandDAO getInstance(File file) {
        if (instance == null)
            instance = new CommandDAO(file);
        return instance;
    }

    private CommandDAO(File file){
        try{
            this.pw = new PrintWriter(file);
            this.reader = new BufferedReader(new FileReader(file));
            this.file = file;
            numCommands = 0;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getCommandLimit(){
        return numCommands;
    }

    public boolean addCommand(ICommand command){
        try{
            //deserialize player
            String strCommand = CommandEncoder.encodeDBInfo(command);
            pw.append(strCommand + "\n");
            pw.flush();
            numCommands ++;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<ICommand> getCommands(){
        String line;
        List<ICommand> commands = new ArrayList<>();

        try{
            while((line = reader.readLine()) != null) {
                ICommand command = (ICommand) CommandEncoder.decodeDBInfo(line);
                commands.add(command);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return commands;
    }

    public void deleteCommands(){
        try{
            pw.close();
            pw = new PrintWriter(file);
            pw.append("");
            pw.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        numCommands = 0;
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
