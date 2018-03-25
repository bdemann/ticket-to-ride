package shared.facades.server;

import shared.results.GameOverResult;

/**
 * Created by paulinecausse on 3/24/18.
 */

public interface IGameOverServerFacade {
    GameOverResult getLongestRoute();
    GameOverResult getTotalPoints();
}
