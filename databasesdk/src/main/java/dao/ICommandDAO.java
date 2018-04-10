package dao;

import shared.command.ICommand;

/**
 * Created by bdemann on 4/9/18.
 */

public interface ICommandDAO {
    public boolean addCommand(ICommand command);
    public ICommand getCommand(int commandId);
    public boolean deleteCommand(ICommand command);
}
