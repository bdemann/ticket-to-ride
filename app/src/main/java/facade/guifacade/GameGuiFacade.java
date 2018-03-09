package facade.guifacade;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import model.ClientRoot;
import proxies.GameServerProxy;
import shared.model.CardSet;
import shared.model.DestCard;
import shared.model.TrainCard;
import shared.model.interfaces.Card;
import shared.model.interfaces.IGameInfo;
import shared.model.interfaces.ITrainCard;
import shared.results.DrawCardsResult;

/**
 * This helps the presenters talk to the model
 * Created by BenNelson on 3/7/18.
 */

public class GameGuiFacade {

    public static List<DestCard> getStarterDestinationCards(){
        return ClientRoot.getClientPlayer().getDestCards();
    }

    public static IGameInfo getStarterGameInfo(){
        return ClientRoot.getClientGameInfo();
    }

    public static List<TrainCard> getStarterPlayerHand(){
        return ClientRoot.getClientPlayer().getTrainCardHand().get_cards();
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

    public static List<Boolean> getCompleteDestination(){
        boolean isCompleted = false;
        List<Boolean> completedDestination = new ArrayList<>();
        for(DestCard destCard : ClientRoot.getClientPlayer().getUnresolvedDestCards()){
            completedDestination.add(isCompleted);
        }

        return completedDestination;
    }
}
