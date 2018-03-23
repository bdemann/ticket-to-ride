package shared.results;

import java.util.List;

import shared.command.ICommand;
import shared.model.DestCard;

/**
 * Created by bdemann on 3/20/18.
 */

public class DrawDestCardsResult extends DrawCardsResult {
    public DrawDestCardsResult(List<DestCard> cards, boolean success, List<ICommand> clientCommands, String userMessage) {
        super(cards, success, clientCommands, userMessage);
    }

    public DrawDestCardsResult(String exceptionType, String exceptionMessage) {
        super(exceptionType, exceptionMessage);
    }

    @Override
    public List<DestCard> getCards() {
        return (List<DestCard>) super.getCards();
    }
}
