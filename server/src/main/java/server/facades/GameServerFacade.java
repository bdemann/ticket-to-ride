package server.facades;

import java.util.List;

import server.model.ServerRoot;
import server.poller.ClientCommands;
import server.poller.ClientNotifications;
import shared.facades.server.IGameServerFacade;
import shared.model.DestCardSet;
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
import shared.results.DrawDestCardsResult;
import shared.results.DrawTrainCardsResult;
import shared.results.Result;

/**
 * Created by bdemann on 3/4/18.
 */

/**
 * The GameServerFacade processes data coming from the Client before it stores it in the ServerModel
 * classes. It is also in charge of getting the information needed by the Client from the Model.
 * This facade specifically takes care of data that is used for the main GameActivity. It will add
 * cards and routes that have been drawn and claimed to the model and return the associated result.
 */
public class GameServerFacade implements IGameServerFacade {
    /**
     * A player can claim a route (an edge connecting two cities) using the right amount of train
     * cards.
     *
     * @param route the Edge object representing the routes claimed by a player
     * @param cards the set of cards used to claim the route
     * @param username the username of the player claiming the route as a String
     *
     * @pre route.getLength() == number of cards in cardSet
     * @pre username != null
     * @pre route != null
     * @pre cards != null
     *
     * @post turn goes to the next player
     * @post train card are discarded from player's hand
     * @post discarded trainCards go to the trainCards discard deck
     * @post the players' score is incremented
     * @post event of the action is sent
     *
     * @return returns a ClaimRoute result if the trainCards don't match with the edge explaining
     *         what went wrong
     *         returns null if everything is successful (In this case a new Command object is sent)
     */
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

        game.getGameHistory().addEvent(new ClaimRouteEvent(username, route, System.currentTimeMillis()));
        ClientNotifications.playerClaimedRoute(username, route);

        return null;
    }

    /**
     * Checks the color of the train cards and of the route claimed to see if they match.
     *
     * @param cards the set of cards used to claim the route
     * @param route the Edge object representing the routes claimed by a player
     *
     * @pre route.getLength() == number of cards in cardSet
     * @pre route != null
     * @pre cards != null
     * @pre both cards and route's color parameter != null
     *
     * @post none
     *
     * @return returns a boolean value stating whether the color of the cards and the route match
     * or not.
     */
    private boolean _colorsMatch(TrainCardSet cards, IEdge route) {
        if (cards.colorsMatch()) {
            if(route.getColor().equals(Color.GRAY)) {
                return true;
            } else {
                Color cardColor = cards.getSetColor();
                return cardColor.equals(route.getColor()) || cardColor.equals(Color.RAINBOW);
            }
        }
        return false;
    }

    /**
     * When a player draws a train card from the faceUpDeck. A card is added to his/her hand
     * and the same card is taken from the deck.
     *
     * @param username the username of the player claiming the route as a String
     * @param trainCard an object representing the train cards in the game
     *
     * @pre username != null
     * @pre trainCard != null
     *
     * @post FaceUpDeck.cardCount -= 1
     * @post player.trainCards += 1
     * @post trainCard is added to player's hand
     * @post trainCard is removed from faceUpDeck
     *
     * @return
     */
    @Override
    public DrawTrainCardsResult drawFaceUpTrainCard(String username, TrainCard trainCard) {
        //TODO implement this method
        return null;
    }


    /**
     * Discards the Destination Card that wasn't chosen by a player
     *
     * @param username the username of the player claiming the route as a String
     * @param keptCards Destination cards that are kept by the player
     * @param discardCards Destination cards that are discarded by player
     *
     * @pre 2 <= keptCard.size() <= 3
     * @pre 0 <= discardCards <= 1
     * @pre username != null
     * @pre keptCards != null
     * @pre discardCards != null
     *
     * @post player's destCard count += 2 or 3
     * @post DestCard discard deck.size() += 0 or 1
     * @post Event of the action is sent
     * @post Command is sent
     *
     * @return returns a Result Object with a message about the success of the action
     */
    @Override
    public Result discardDestCards(String username, DestCardSet keptCards, DestCardSet discardCards) {
        //TODO implement this method
        // add kept cards to user cards
        IPlayer player = ServerRoot.getPlayer(username);
        player.addDestCards(keptCards.toList());
        // add discarded cards to discard

        //Update game history
        ServerRoot.getGame(player.getGameId()).getGameHistory().addEvent(new GameEvent(username, "kept " + keptCards.size() + " cards", System.currentTimeMillis()));

        //Notify other users
        ClientNotifications.gameUpdated(username);

        ServerRoot.getGame(player.getGameId()).getDestCardDeck().discard(discardCards.toList());
        return new Result(true, ClientCommands.getCommandList(username), "discarded successfully");
    }

    /**
     * When a player draws a train card from the face down Deck. A card is added to his/her hand
     * and the same card is taken from the deck.
     *
     * @param username the username of the player claiming the route as a String
     *
     * @pre username != null
     *
     * @post FaceDownDeck.cardCount -= 1
     * @post player.trainCards += 1
     * @post trainCard is added to player's hand
     * @post trainCard is removed from faceDown deck
     * @post turn goes to the next player
     * @post Event of the action is sent
     *
     * @return returns a DrawCardResult with a message about the success of the action
     */
    @Override
    public DrawTrainCardsResult drawTrainCard(String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getCurrentGame());

        List<TrainCard> cards = game.getTrainCardDeck().draw(1);

        game.incrementTurnIndex();

        game.getGameHistory().addEvent(new GameEvent(username, "drew a train card", System.currentTimeMillis()));
        ClientNotifications.playerDrewTrainCards(username);

        return new DrawTrainCardsResult(cards, true, ClientCommands.getCommandList(username), "Draw a train card");
    }

    /**
     * A player draws destination cards
     *
     * @param username the username of the player claiming the route as a String
     *
     * @pre username != null
     *
     * @post destCard deck.size() -= 3
     * @post turn goes to the next player
     * @post Event of action is sent
     * @post Command is sent
     *
     * @return returns s DrawCardsResult with a message about the success of the action
     */
    @Override
    public DrawDestCardsResult drawDestCards(String username) {
        IPlayer player = ServerRoot.getPlayer(username);
        IGame game = ServerRoot.getGame(player.getCurrentGame());

        List<DestCard> cards = game.getDestCardDeck().draw(3);

        game.incrementTurnIndex();

        game.getGameHistory().addEvent(new GameEvent(username, "drew three destination card", System.currentTimeMillis()));
        ClientNotifications.playerDrewDestinationCards(username);

        return new DrawDestCardsResult(cards, true, ClientCommands.getCommandList(username), "Draw three destination card");
    }
}
