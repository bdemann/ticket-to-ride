package proxies;

import java.util.List;

import shared.facades.server.IGameServerFacade;
import shared.model.TrainCard;
import shared.model.interfaces.IEdge;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameServerProxy implements IGameServerFacade {
    @Override
    public ClaimRouteResult claimRoute(IEdge route, List<TrainCard> cards, String username) {
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
