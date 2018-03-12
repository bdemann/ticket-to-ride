package proxies;

import shared.command.Command;
import shared.command.ICommand;
import shared.facades.server.IGameServerFacade;
import shared.model.DestCardSet;
import shared.model.TrainCard;
import shared.model.TrainCardSet;
import shared.model.interfaces.IEdge;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;
import shared.results.Result;
import tasks.TaskExecutor;

/**
 * The GameServerProxy implements the IGameServerFacade
 *
 */
public class GameServerProxy implements IGameServerFacade {

    /**
     * Claims a route and returns the result of the claimed route
     *
     * @param route Route being claimed
     * @param cards Cards being used to claim the route
     * @param username Username of the player claiming the route
     *
     * @pre route != null && route is not already claimed.
     * @pre cards != null && cards are sufficient number and correct color for the route.
     * @pre username is a real player in the game
     *
     * @post route is claimed.
     * @return ClaimRouteResult the results of the action.
     */
    @Override
    public ClaimRouteResult claimRoute(IEdge route, TrainCardSet cards, String username) {
        Class<?>[] parmTypes = {IEdge.class, TrainCardSet.class, String.class};
        Object[] parmValues = {route, cards, username};

        ICommand command = _generateGameServerFacadeCommand("claimRoute", parmTypes, parmValues);

        Result result = TaskExecutor.runTask(command);

        if(result.getCommandSuccess()){
            return (ClaimRouteResult) result;
        }
        return new ClaimRouteResult(result.getExceptionType(), result.getExceptionMessage());
    }

    /**
     *
     * @param username Username of a player in the game
     * @param trainCard A train card from the player
     * @return DrawCardsResult
     */
    @Override
    public DrawCardsResult drawFaceUpTrainCard(String username, TrainCard trainCard) {
        //TODO implement method
        return null;
    }

    /**
     * Discards destination cards that the player doesn't want to keep.
     *
     * @param username Username of the player discarding the cards.
     * @param keptCards Cards that the given user is keeping.
     * @param discardCards Cards that the given user is discarding.
     *
     * @pre keptCards != null
     * @pre discardCards != null
     * @pre username is a real player in the game
     *
     *
     * @post destination cards are discarded from the given player's hand.
     * @return Result of the discard.
     */
    @Override
    public Result discardDestCards(String username, DestCardSet keptCards, DestCardSet discardCards) {
        Class<?>[] parmTypes = {String.class, DestCardSet.class, DestCardSet.class};
        Object[] parmValues = {username, keptCards, discardCards};
        ICommand command = _generateGameServerFacadeCommand("discardDestCards", parmTypes, parmValues);
        return TaskExecutor.runTask(command);
    }

    /**
     * Draws a train card from the deck and gives it to the specified player
     *
     * @param username Username of the player drawing a Train card
     *
     * @pre username is a real user in the game.
     *
     * @post the player's train cards will be +1
     * @return DrawCardResult from the action.
     */
    @Override
    public DrawCardsResult drawTrainCard(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};

        ICommand command = _generateGameServerFacadeCommand("drawTrainCard", parmTypes, parmValues);

        Result result = TaskExecutor.runTask(command);

        if(result.getCommandSuccess()){
            return (DrawCardsResult) result;
        }
        return new DrawCardsResult(result.getExceptionType(), result.getExceptionMessage());
    }

    /**
     * Draws a ticket (Destination) card from the deck and gives it to the specified player.
     *
     * @param username Username of the player drawing a Ticket (Destination) card.
     *
     * @pre the username is the name of an actual player in the game.
     *
     * @post the player's destination cards will be +1
     * @return DrawCardsResult from the action
     */
    @Override
    public DrawCardsResult drawTicketCards(String username) {
        Class<?>[] parmTypes = {String.class};
        Object[] parmValues = {username};

        ICommand command = _generateGameServerFacadeCommand("drawTicketCards", parmTypes, parmValues);

        Result result = TaskExecutor.runTask(command);

        if(result.getCommandSuccess()){
            return (DrawCardsResult) result;
        }
        return new DrawCardsResult(result.getExceptionType(), result.getExceptionMessage());
    }

    /**
     * Generates a generic game server command.
     *
     * @param method Method to be invoked.
     * @param parmTypes Parameter Types to be used.
     * @param parmValues Parameter Values to be used.
     *
     * @pre method is a valid method from a valid class.
     * @pre parmTypes are valid parameter types.
     * @pre parmValues are valid values of the given parameter types.
     *
     * @post ICommand command will be returned.
     * @return ICommand to be sent to the server
     */
    private ICommand _generateGameServerFacadeCommand(String method, Class<?>[] parmTypes, Object[] parmValues){
        return new Command("server.facades.GameServerFacade", method, parmTypes, parmValues);
    }
}
