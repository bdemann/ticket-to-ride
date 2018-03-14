package facade;

import model.ClientRoot;
import shared.model.history.events.GameEvent;
import shared.model.interfaces.IEdge;
import shared.model.interfaces.IGameInfo;

/**
 * Created by bdemann on 3/5/18.
 */

public class GameClientFacade {

    void updateGameInfo(IGameInfo gameInfo){
        System.out.println("---------UPDATE GAME INFO---------");
        for(GameEvent event : gameInfo.getGameHistory().getEvents()) {
            System.out.println(event);
        }
        System.out.println("---------END UPDATE GAME INFO---------");
        ClientRoot.setClientGameInfo(gameInfo);
    }

}
