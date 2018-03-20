package shared.results;

import java.util.List;

import shared.command.ICommand;
import shared.model.TrainCard;
import shared.model.interfaces.Card;

/**
 * Created by bdemann on 3/20/18.
 */

public class DrawTrainCardsResult extends DrawCardsResult {

    public DrawTrainCardsResult(List<TrainCard> cards, boolean success, List<ICommand> clientCommands, String userMessage) {
        super(cards, success, clientCommands, userMessage);
    }

    public DrawTrainCardsResult(String exceptionType, String exceptionMessage) {
        super(exceptionType, exceptionMessage);
    }

    @Override
    public List<TrainCard> getCards() {
        return (List<TrainCard>) super.getCards();
    }
}
