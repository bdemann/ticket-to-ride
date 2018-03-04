package shared.facades.server;

import shared.model.IRoute;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardResult;

/**
 * Created by bdemann on 2/28/18.
 */

public interface IGameServerFacade {

    public ClaimRouteResult claimRoute(IRoute route, String username);
    public DrawCardResult drawTrainCard(String username);
    public DrawCardResult drawTicketCard(String username);

}
