package proxies.syncProxy;

import shared.facades.server.IGameServerFacade;
import shared.model.CardSet;
import shared.model.TrainCard;
import shared.model.TrainCardSet;
import shared.model.interfaces.IEdge;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;
import shared.results.Result;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameServerProxySync implements IGameServerFacade {
    @Override
    public ClaimRouteResult claimRoute(IEdge route, TrainCardSet cards, String username) {
        return null;
    }

    @Override
    public DrawCardsResult drawFaceUpTrainCard(String username, TrainCard trainCard) {
        return null;
    }

    @Override
    public Result discardDestCards(String username, CardSet destCardSet) {
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
