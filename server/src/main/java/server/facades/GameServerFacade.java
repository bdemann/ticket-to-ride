package server.facades;

import java.util.List;

import server.model.ServerRoot;
import server.poller.ClientCommands;
import server.poller.ClientNotifications;
import shared.facades.server.IGameServerFacade;
import shared.model.CardSet;
import shared.model.Color;
import shared.model.DestCard;
import shared.model.TrainCardSet;
import shared.model.interfaces.IEdge;
import shared.model.TrainCard;
import shared.model.history.events.ClaimRouteEvent;
import shared.model.history.events.GameEvent;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;
import shared.results.Result;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameServerFacade implements IGameServerFacade {
    @Override
    public ClaimRouteResult claimRoute(IEdge route, TrainCardSet cards, String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getCurrentGame());

        //Check that the cards are the same color as the route.
        boolean cardsMatch = _colorsMatch(cards, route);
        if (!cardsMatch) {
            return new ClaimRouteResult(false, ClientCommands.getCommandList(username), "Cards did not match the color of the route.");
        }


        //TODO implement claiming a route
        //Claim the route
        //TODO where we we store all of the routes (and by routes I mean edges, but I mean routes)?
        //Add cards to discard pile
        game.discardTrainCards(cards);
        //Adjust the players score
        player.incrementScore(route.getValue());
        //Adjust the number of remaining trains player has.
        player.decrementTrains(route.getLength());

        game.incrementTurnIndex();

        game.getGameHistory().addEvent(new ClaimRouteEvent(username, route));
        ClientNotifications.playerClaimedRoute(username, route);
        return null;
    }

    private boolean _colorsMatch(TrainCardSet cards, IEdge route) {
        if (cards.colorsMatch()) {
            if(route.getColor().equals(Color.GRAY)) {
                return true;
            } else {
                Color cardColor = cards.getSetColor();
                //TODO can you claim a route with all wilds? I am assuming so but we will have to change this if not.
                return cardColor.equals(route.getColor()) || cardColor.equals(Color.RAINBOW);
            }
        }
        return false;
    }

    @Override
    public DrawCardsResult drawFaceUpTrainCard(String username, TrainCard trainCard) {
        //TODO implement this method
        return null;
    }

    @Override
    public Result discardDestCards(String username, CardSet destCardSet) {
        return null;
    }

    @Override
    public DrawCardsResult drawTrainCard(String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getCurrentGame());

        List<TrainCard> cards = game.getTrainCardDeck().draw(1);

        game.incrementTurnIndex();

        game.getGameHistory().addEvent(new GameEvent(username, "drew a train card"));
        ClientNotifications.playerDrewTrainCards(username);

        return new DrawCardsResult(cards, true, ClientCommands.getCommandList(username), "Draw a train card");
    }

    @Override
    public DrawCardsResult drawTicketCards(String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getCurrentGame());

        List<DestCard> cards = game.getDestCardDeck().draw(3);

        game.incrementTurnIndex();

        game.getGameHistory().addEvent(new GameEvent(username, "drew three destination card"));
        ClientNotifications.playerDrewDestinationCards(username);

        return new DrawCardsResult(cards, true, ClientCommands.getCommandList(username), "Draw three destination card");
    }
}
