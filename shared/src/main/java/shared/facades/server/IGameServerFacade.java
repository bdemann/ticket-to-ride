package shared.facades.server;

import shared.model.DestCardSet;
import shared.model.TrainCard;
import shared.model.TrainCardSet;
import shared.model.interfaces.IEdge;
import shared.results.ClaimRouteResult;
import shared.results.DrawDestCardsResult;
import shared.results.DrawTrainCardsResult;
import shared.results.Result;

/**
 * Created by bdemann on 2/28/18.
 */

public interface IGameServerFacade {

    public ClaimRouteResult claimRoute(IEdge route, TrainCardSet cards, String username);

    public DrawDestCardsResult drawDestCards(String username);
    public Result discardDestCards(String username, DestCardSet keptCards, DestCardSet discardCards);

    public DrawTrainCardsResult drawFaceUpTrainCard(String username, int trainCardIndex);
    public DrawTrainCardsResult drawFaceDownTrainCard(String username);

}
