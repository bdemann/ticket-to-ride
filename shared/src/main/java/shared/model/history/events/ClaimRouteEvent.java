package shared.model.history.events;

import shared.model.IEdge;
import shared.model.IRoute;

/**
 * Created by bdemann on 3/4/18.
 */

public class ClaimRouteEvent extends GameEvent {
    public ClaimRouteEvent(String username, IEdge claimedRoute) {
        super(username, "claimed " + claimedRoute.toString());
    }
}
