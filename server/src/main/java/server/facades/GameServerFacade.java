package server.facades;

import java.util.List;

import server.model.ServerRoot;
import server.poller.ClientCommands;
import server.poller.ClientNotifications;
import shared.facades.server.IGameServerFacade;
import shared.model.Color;
import shared.model.DestCard;
import shared.model.IEdge;
import shared.model.TrainCard;
import shared.model.history.events.ClaimRouteEvent;
import shared.model.history.events.GameEvent;
import shared.model.IGame;
import shared.model.IPlayer;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameServerFacade implements IGameServerFacade {
    @Override
    public ClaimRouteResult claimRoute(IEdge route, List<TrainCard> cards, String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getCurrentGame());

        //Check that the cards are the same color as the route.
        boolean cardsMatch = _colorsMatch(cards, route);
        if (!cardsMatch) {
            return new ClaimRouteResult(false, ClientCommands.getCommandList(username), "Cards did not match the color of the route.");
        }

        //TODO implement claiming a route

        game.getGameHistory().addEvent(new ClaimRouteEvent(username, route));
        ClientNotifications.playerClaimedRoute(username, route);
        return null;
    }

    private boolean _colorsMatch(List<TrainCard> cards, IEdge route) {
        if (_colorsMatch(cards)) {
            if(route.getColor().equals(Color.GRAY)) {
                return true;
            } else {
                Color cardColor = getCardColor(cards);
                //TODO can you claim a route with all wilds? I am assuming so but we will have to change this if not.
                return cardColor.equals(route.getColor()) || cardColor.equals(Color.RAINBOW);
            }
        }
        return false;
    }

    private boolean _colorsMatch(List<TrainCard> cards) {
        Color currColor = null;
        for( TrainCard card : cards) {
            if (card.getColor().equals(Color.RAINBOW)) {
                continue;
            }
            if (currColor == null){
                currColor = card.getColor();
            }else if (!currColor.equals(card.getColor())){
                return false;
            }
        }
        return true;
    }

    private Color getCardColor(List<TrainCard> cards) {
        for( TrainCard card : cards) {
            if (card.getColor().equals(Color.RAINBOW)) {
                continue;
            }
            return card.getColor();
        }
        return Color.RAINBOW;
    }

    @Override
    public DrawCardsResult drawTrainCard(String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getCurrentGame());

        List<TrainCard> cards = game.getTrainCardDeck().draw(1);

        game.getGameHistory().addEvent(new GameEvent(username, "drew a train card"));
        ClientNotifications.playerDrewTrainCards(username);

        return new DrawCardsResult(cards, true, ClientCommands.getCommandList(username), "Draw a train card");
    }

    @Override
    public DrawCardsResult drawTicketCards(String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getCurrentGame());

        List<DestCard> cards = game.getDestCardDeck().draw(3);

        game.getGameHistory().addEvent(new GameEvent(username, "drew three destination card"));
        ClientNotifications.playerDrewDestinationCards(username);

        return new DrawCardsResult(cards, true, ClientCommands.getCommandList(username), "Draw three destination card");
    }
}
