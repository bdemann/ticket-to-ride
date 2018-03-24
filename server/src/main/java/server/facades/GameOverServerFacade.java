package server.facades;

import shared.facades.server.IGameOverServerFacade;
import shared.results.GameOverResult;
import shared.results.Result;

/**
 * Created by paulinecausse on 3/24/18.
 */

public class GameOverServerFacade implements IGameOverServerFacade {
    @Override
    public GameOverResult getLongestRoute() {

        return new GameOverResult("","");
    }
}
