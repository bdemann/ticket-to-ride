package server.facades;

import server.model.ServerRoot;
import shared.commandResults.CommandResult;
import shared.commandResults.LoginCommandResult;
import shared.commandResults.RegisterCommandResult;
import shared.model.Player;
import shared.server.facades.ILoginServerFacade;

/**
 * Created by Ben on 2/6/2018.
 */

public class LoginServerFacade implements ILoginServerFacade {

    @Override
    public CommandResult signin(String username, String password) {
        Player player = ServerRoot.getPlayer(username);
        if(player.getPassword().equals(password)){
            return new LoginCommandResult(true, ServerRoot.getCommandList());
        }
        return new LoginCommandResult(false, ServerRoot.getCommandList());
    }

    @Override
    public CommandResult register(String username, String password) {
        Player player = ServerRoot.getPlayer(username);
        if(player != null){
            // Player already exists
            return new RegisterCommandResult(false, ServerRoot.getCommandList());
        }
        ServerRoot.addPlayer(new Player(username, password));
        return new RegisterCommandResult(true, ServerRoot.getCommandList());
    }
}
