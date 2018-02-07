package server.facades;

import server.model.ServerRoot;
import shared.model.Player;
import shared.server.facades.ILoginServerFacade;

/**
 * Created by Ben on 2/6/2018.
 */

public class LoginServerFacade implements ILoginServerFacade {
    @Override
    public boolean login(String username, String password) {
        Player player = ServerRoot.getPlayer(username);
        return player.getPassword().equals(password);
    }

    @Override
    public boolean register(String username, String password) {
        Player player = ServerRoot.getPlayer(username);
        if(player != null){
            // Player already exists
            return false;
        }
        ServerRoot.addPlayer(new Player(username, password));
        return true;
    }
}
