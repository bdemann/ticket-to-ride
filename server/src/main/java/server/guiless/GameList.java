package server.guiless;

import server.facades.GameMenuServerFacade;
import server.facades.LoginServerFacade;
import shared.model.Player;

/**
 * Created by bdemann on 2/12/18.
 */

public class GameList {
    public static void main(String[] args) {
        GameMenuServerFacade gssf = new GameMenuServerFacade();
        new LoginServerFacade().register("bdemann", "a");
        gssf.createGame(new Player("bdemann", "a"),5, "hello Wold");
        System.out.println(gssf.getGamesList("bdemann"));
    }
}
