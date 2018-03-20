package shared.results;

import java.util.List;

import shared.command.ICommand;
import shared.model.interfaces.Card;

/**
 * Created by bdemann on 3/3/18.
 */

public abstract class DrawCardsResult extends Result {

    //TODO we should get rid of this class and have just the DrawDestCardsResult class which is the only one that extends this class.

    List<? extends Card> _cards;

    public DrawCardsResult(List<? extends Card> cards, boolean success, List<ICommand> clientCommands, String userMessage) {
        super(success, clientCommands, userMessage);
        this._cards = cards;
    }

    public DrawCardsResult(String exceptionType, String exceptionMessage) {
        super(exceptionType, exceptionMessage);
    }

    public List<? extends Card> getCards() {
        return _cards;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Draw Card Result - ");
        sb.append("Success: " + _success);
        sb.append("\n");
        sb.append("Drawn Cards: \n");
        for(Card card : _cards) {
            sb.append(card);
            sb.append("\t");
        }
        return sb.toString();
    }
}
