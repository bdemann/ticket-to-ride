package shared.facades.server;

import java.util.List;

import shared.model.IRoute;
import shared.model.TrainCard;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;

/**
 * Created by bdemann on 2/28/18.
 */

public interface IGameServerFacade {

    public ClaimRouteResult claimRoute(IRoute route, List<TrainCard> cards, String username);
    public DrawCardsResult drawTrainCard(String username);
    public DrawCardsResult drawTicketCards(String username);

}
