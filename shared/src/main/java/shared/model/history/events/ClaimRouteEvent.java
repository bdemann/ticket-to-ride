package shared.model.history.events;

import java.io.Serializable;

import shared.model.interfaces.IEdge;

/**
 * Created by bdemann on 3/4/18.
 */

public class ClaimRouteEvent extends GameEvent implements Serializable {
    public ClaimRouteEvent(String username, IEdge claimedRoute) {
        super(username, "claimed " + claimedRoute.toString());
    }
}
