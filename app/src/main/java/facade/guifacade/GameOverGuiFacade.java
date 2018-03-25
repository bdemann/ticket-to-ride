package facade.guifacade;

import java.util.List;

import model.ClientRoot;
import proxies.GameOverServerProxy;
import proxies.GameServerProxy;
import shared.model.EndGameTotals;
import shared.results.DrawDestCardsResult;
import shared.results.GameOverResult;

/**
 * Created by paulinecausse on 3/24/18.
 */

public class GameOverGuiFacade {
    public void getLongestRoute(){
        GameOverServerProxy gosp = new GameOverServerProxy();
        GameOverResult result = gosp.getLongestRoute();
        processLongestRoute(result);
    }

    private void processLongestRoute(GameOverResult result){
        //TODO: update player with longest route
    }

    public void getPointTotals(){
        GameOverServerProxy gosp = new GameOverServerProxy();
        GameOverResult result = gosp.getTotalPoints();
        processPointTotals(result);
    }

    private void processPointTotals(GameOverResult result){
        List<EndGameTotals> endGameTotals = result.getEndGameTotals();
        ClientRoot.setEndGameTotals(endGameTotals);
    }
}
