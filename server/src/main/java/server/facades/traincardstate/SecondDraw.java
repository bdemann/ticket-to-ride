package server.facades.traincardstate;

import server.facades.GameServerFacade;
import shared.model.Color;
import shared.model.TrainCard;
import shared.model.interfaces.IGame;

/**
 * Created by bdemann on 3/24/18.
 */

public class SecondDraw extends TrainCardState {
    public SecondDraw(GameServerFacade gameServerFacade) {
        super(gameServerFacade);
    }

    @Override
    public TrainCard drawFaceUpCard(IGame game, int cardIndex) {
        //Get card
        TrainCard result = game.getCardsFaceUp().get(cardIndex);
        //if locomotive
        if(result.getColor().equals(Color.RAINBOW)){
            //Do nothing
            gameServerFacade.setState(new SecondDraw(gameServerFacade));
            return null;
        } else {
            gameServerFacade.setState(new NoDraw(gameServerFacade));
            game.incrementTurnIndex();
            return result;
        }
    }

    @Override
    public TrainCard drawFaceDownCard(IGame game) {
        gameServerFacade.setState(new NoDraw(gameServerFacade));
        game.incrementTurnIndex();
        return this.gameServerFacade.drawCardFromDeck(game.getId());
    }
}
