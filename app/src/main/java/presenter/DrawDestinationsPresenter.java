package presenter;


import java.util.List;

import facade.guifacade.GameGuiFacade;
import shared.model.DestCard;
import shared.model.DestCardSet;

/**
 *
 * Created by BenNelson on 3/6/18.
 */

public class DrawDestinationsPresenter implements IDrawDestinationsPresenter {



    @Override
    public List<DestCard> drawDestinationCards() {
        return GameGuiFacade.drawDestinationCards();
    }

    @Override
    public List<DestCard> getStarterDestinationCards() {
        return GameGuiFacade.getStarterDestinationCards();
    }

    @Override
    public void discardDestCards(List<DestCard> chosenDestList, DestCardSet removeDestCardSet){
        GameGuiFacade.discardDestinationCards(chosenDestList,removeDestCardSet);
    }
}
