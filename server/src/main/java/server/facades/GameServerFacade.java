package server.facades;

import java.util.List;

import server.model.ServerRoot;
import server.poller.ClientCommands;
import server.poller.ClientNotifications;
import shared.facades.server.IGameServerFacade;
import shared.model.DestCard;
import shared.model.TrainCard;
import shared.model.history.events.ClaimRouteEvent;
import shared.model.history.events.GameEvent;
import shared.model.IGame;
import shared.model.IPlayer;
import shared.model.IRoute;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameServerFacade implements IGameServerFacade {
    @Override
    public ClaimRouteResult claimRoute(IRoute route, List<TrainCard> cards, String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getCurrentGame());

        //Check that the cards are the same color as the route.


        //TODO implement claiming a route

        game.getGameHistory().addEvent(new ClaimRouteEvent(username, route));
        ClientNotifications.playerClaimedRoute(username, route);
        return null;
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
