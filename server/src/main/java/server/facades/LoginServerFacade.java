package server.facades;

import server.model.ServerRoot;
import server.proxies.ClientCommands;
import shared.commandResults.CommandResult;
import shared.commandResults.LoginCommandResult;
import shared.commandResults.RegisterCommandResult;
import shared.model.IPlayer;
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


        IPlayer player = ServerRoot.getPlayer(username);
        if(player == null){
            return new LoginCommandResult(false, ClientCommands.getCommandList(username), "Player does not exists");
        }
        if(player.getPassword().equals(password)){
            return new LoginCommandResult(true, ClientCommands.getCommandList(username), "Login successful");
        }
        return new LoginCommandResult(false, ClientCommands.getCommandList(username), "Wrong password");

    }

    @Override
    public CommandResult register(String username, String password) {
        IPlayer player = ServerRoot.getPlayer(username);
        if(player != null){
            // Player already exists
            return new RegisterCommandResult(false, ClientCommands.getCommandList(username), "Player already exists");
        }
        ServerRoot.addPlayer(new Player(username, password));
        return new RegisterCommandResult(true, ClientCommands.getCommandList(username),"Register successful");
    }
}
