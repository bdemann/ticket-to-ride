package presenter;

import java.util.ArrayList;
import java.util.List;

import shared.model.DestCard;

/**
 * Interface for this presenter
 * Created by BenNelson on 3/6/18.
 */

public interface IDrawDestinationsPresenter {

    void drawDestinationCards();
    List<DestCard> getStarterDestinationCards();
}
