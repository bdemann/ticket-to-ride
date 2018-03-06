package proxies.syncProxy;

import shared.facades.server.IGameServerFacade;
import shared.model.TrainCardSet;
import shared.model.interfaces.IEdge;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameServerProxySync implements IGameServerFacade {
    @Override
    public ClaimRouteResult claimRoute(IEdge route, TrainCardSet cards, String username) {
        return null;
    }

    @Override
    public DrawCardsResult drawTrainCard(String username) {
        return null;
    }

    @Override
    public DrawCardsResult drawTicketCards(String username) {
        return null;
    }
}
