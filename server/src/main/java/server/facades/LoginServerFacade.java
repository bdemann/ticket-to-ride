package server.facades;

import server.model.ServerRoot;
import server.poller.ClientCommands;
import shared.results.LoginResult;
import shared.results.RegisterResult;
import shared.results.Result;
import shared.logging.Level;
import shared.logging.Logger;
import shared.model.IPlayer;
import shared.model.Player;
import shared.facades.server.ILoginServerFacade;

/**
 *
 * Created by Ben on 2/6/2018.
 */

public class LoginServerFacade implements ILoginServerFacade {
    public static void main(String[] args){
        LoginServerFacade loginServerFacade = new LoginServerFacade();
        Result result = loginServerFacade.signin("username", "password");
    }

    @Override
    public Result signin(String username, String password) {
        Logger.log("Logging in user: " + username, Level.FINE);

        IPlayer player = ServerRoot.getPlayer(username);
        if(player == null){
            Logger.log("User " + username + " does not exist.", Level.FINNEST);
            return new LoginResult(false, ClientCommands.getCommandList(username), "Player does not exists");
        }
        if(player.getPassword().equals(password)){
            Logger.log("Login Successful", Level.FINE);
            return new LoginResult(true, ClientCommands.getCommandList(username), "Login successful");
        }
        Logger.log("Login failed", Level.FINE);
        return new LoginResult(false, ClientCommands.getCommandList(username), "Wrong password");

    }

    @Override
    public Result register(String username, String password) {
        IPlayer player = ServerRoot.getPlayer(username);
        if(player != null){
            // Player already exists
            return new RegisterResult(false, ClientCommands.getCommandList(username), "Player already exists");
        }
        ServerRoot.addPlayer(new Player(username, password));
        return new RegisterResult(true, ClientCommands.getCommandList(username),"Register successful");
    }
}
