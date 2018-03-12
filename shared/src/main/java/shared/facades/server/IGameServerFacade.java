package shared.facades.server;

import shared.model.DestCardSet;
import shared.model.TrainCard;
import shared.model.TrainCardSet;
import shared.model.interfaces.IEdge;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;
import shared.results.Result;

/**
 * Created by bdemann on 2/28/18.
 */

public interface IGameServerFacade {

    public ClaimRouteResult claimRoute(IEdge route, TrainCardSet cards, String username);

    DrawCardsResult drawFaceUpTrainCard(String username, TrainCard trainCard);

    Result discardDestCards(String username, DestCardSet keptCards, DestCardSet discardCards);

    public DrawCardsResult drawTrainCard(String username);
    public DrawCardsResult drawTicketCards(String username);

}
