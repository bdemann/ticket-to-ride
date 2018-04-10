package nonrel_database;

import dao.ICommandDAO;
import shared.command.Command;
import shared.command.ICommand;

/**
 * Created by paulinecausse on 4/10/18.
 */

public class CommandDAO implements ICommandDAO {
    public boolean addCommand(ICommand command){return false;}
    public ICommand getCommand(int commandId){
        Class<?>[] paramTypes = {} ;
        Object[] parmValues = {};
        return new Command("class","method",paramTypes,parmValues);
    }
    public boolean deleteCommand(ICommand command){return false;}

}
