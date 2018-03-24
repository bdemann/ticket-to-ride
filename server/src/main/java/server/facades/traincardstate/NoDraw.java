package server.facades.traincardstate;

import server.facades.GameServerFacade;
import shared.model.TrainCard;
import shared.model.interfaces.IGame;

/**
 * Created by bdemann on 3/24/18.
 */

public class NoDraw extends TrainCardState {

    public NoDraw(GameServerFacade gameServerFacade) {
        //TODO problaby what we will want to do is have second draw go back to first draw and have the turn state machine worry about stopping them from drawing cards.
        super(gameServerFacade);
    }

    @Override
    public TrainCard drawFaceUpCard(IGame game, int cardIndex) {
        return null;
    }

    @Override
    public TrainCard drawFaceDownCard(IGame game) {
        return null;
    }
}
