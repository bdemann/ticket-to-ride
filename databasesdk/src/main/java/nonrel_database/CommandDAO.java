package nonrel_database;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.ICommandDAO;
import shared.command.Command;
import shared.command.ICommand;

/**
 * Created by paulinecausse on 4/10/18.
 */

public class CommandDAO implements ICommandDAO {
    private File file;
    private static CommandDAO instance;
    public static CommandDAO getInstance(File file) {
        if (instance == null)
            instance = new CommandDAO(file);
        return instance;
    }

    private CommandDAO(File file){
        this.file = file;
    }

    public boolean addCommand(ICommand command){return false;}

    public List<ICommand> getCommands(){
        return new ArrayList<>();
    }
    public ICommand getCommand(int commandId){
        Class<?>[] paramTypes = {} ;
        Object[] parmValues = {};
        return new Command("class","method",paramTypes,parmValues);
    }

    public boolean deleteCommand(ICommand command){return false;}

}
