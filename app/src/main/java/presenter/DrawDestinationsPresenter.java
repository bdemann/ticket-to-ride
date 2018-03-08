package presenter;


import java.util.List;

import facade.guifacade.GameGuiFacade;
import shared.model.DestCard;

/**
 *
 * Created by BenNelson on 3/6/18.
 */

public class DrawDestinationsPresenter implements IDrawDestinationsPresenter {



    @Override
    public void drawDestinationCards() {

    }

    @Override
    public List<DestCard> getStarterDestinationCards() {
        return GameGuiFacade.getStarterDestinationCards();
    }
}
