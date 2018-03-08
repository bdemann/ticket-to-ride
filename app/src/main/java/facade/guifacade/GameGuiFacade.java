package facade.guifacade;

import java.util.ArrayList;
import java.util.List;

import model.ClientRoot;
import proxies.GameServerProxy;
import shared.model.CardSet;
import shared.model.DestCard;
import shared.model.interfaces.Card;
import shared.model.interfaces.IGameInfo;
import shared.results.DrawCardsResult;

/**
 * This helps the presenters talk to the model
 * Created by BenNelson on 3/7/18.
 */

public class GameGuiFacade {

    public static List<DestCard> getStarterDestinationCards(){
        CardSet set = ClientRoot.getClientPlayer().getUnresolvedDestCards();
        return set.cards;

    }

    public static IGameInfo getStarterGameInfo(){
        IGameInfo gameInfo = ClientRoot.getClientGameInfo();
        return gameInfo;
    }

    public static List<DestCard> drawDestinationCards() {
        GameServerProxy gsp = new GameServerProxy();
        DrawCardsResult cardResults = gsp.drawTicketCards(ClientRoot.getClientPlayer().getUsername());
        return _processDrawDestinationResults(cardResults);
    }

    private static List<DestCard> _processDrawDestinationResults(DrawCardsResult cardResults) {
        if(cardResults != null){
            return (List<DestCard>) cardResults.getCards();
        }
        else {
            return null;
        }
    }
}
