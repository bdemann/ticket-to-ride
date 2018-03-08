package facade.guifacade;

import java.util.ArrayList;
import java.util.List;

import model.ClientRoot;
import shared.model.CardSet;
import shared.model.DestCard;
import shared.model.GameInfo;
import shared.model.interfaces.Card;
import shared.model.interfaces.IGameInfo;

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
}
