package facade;

import model.ClientRoot;
import shared.model.interfaces.IEdge;
import shared.model.interfaces.IGameInfo;

/**
 * Created by bdemann on 3/5/18.
 */

public class GameClientFacade {

    void updateGameInfo(IGameInfo gameInfo){
        ClientRoot.setClientGameInfo(gameInfo);
    }

}
