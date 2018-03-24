package facade.guifacade;

import model.ClientRoot;
import proxies.GameOverServerProxy;
import proxies.GameServerProxy;
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
}
