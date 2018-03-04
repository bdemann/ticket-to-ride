package shared.facades.server;

import java.util.List;

import shared.model.IEdge;
import shared.model.IRoute;
import shared.model.TrainCard;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;

/**
 * Created by bdemann on 2/28/18.
 */

public interface IGameServerFacade {

    public ClaimRouteResult claimRoute(IEdge route, List<TrainCard> cards, String username);
    public DrawCardsResult drawTrainCard(String username);
    public DrawCardsResult drawTicketCards(String username);

}
