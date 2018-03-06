package shared.facades.server;

import shared.model.TrainCardSet;
import shared.model.interfaces.IEdge;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;

/**
 * Created by bdemann on 2/28/18.
 */

public interface IGameServerFacade {

    public ClaimRouteResult claimRoute(IEdge route, TrainCardSet cards, String username);
    public DrawCardsResult drawTrainCard(String username);
    public DrawCardsResult drawTicketCards(String username);

}
