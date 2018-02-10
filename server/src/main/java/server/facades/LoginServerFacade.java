package server.facades;

import server.model.ServerRoot;
import shared.commandResults.CommandResult;
import shared.commandResults.LoginCommandResult;
import shared.commandResults.RegisterCommandResult;
import shared.model.Player;
import shared.facades.ILoginServerFacade;

/**
 *
 * Created by Ben on 2/6/2018.
 */

public class LoginServerFacade implements ILoginServerFacade {
    public static void main(String[] args){
        LoginServerFacade loginServerFacade = new LoginServerFacade();
        CommandResult commandResult = loginServerFacade.signin("username", "password");
    }

    @Override
    public CommandResult signin(String username, String password) {


        Player player = ServerRoot.getPlayer(username);
        if(player == null){
            return new LoginCommandResult(false, "Player does not exists");
        }
        if(player.getPassword().equals(password)){
            return new LoginCommandResult(true, "Login successful");
        }
        return new LoginCommandResult(false, "Wrong password");

    }

    @Override
    public CommandResult register(String username, String password) {
        Player player = ServerRoot.getPlayer(username);
        if(player != null){
            // Player already exists
            return new RegisterCommandResult(false, "Player already exists");
        }
        ServerRoot.addPlayer(new Player(username, password));
        return new RegisterCommandResult(true, "Register successful");
    }
}
